package com.billshare.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billshare.entities.BillEntity;
import com.billshare.entities.CurrencyEntity;
import com.billshare.entities.GroupEntity;
import com.billshare.entities.IndebtEntity;
import com.billshare.entities.UserEntity;
import com.billshare.exceptions.BillShareException;
import com.billshare.exceptions.RecordNotFoundException;
import com.billshare.models.forms.CreateBillForm;
import com.billshare.models.forms.CreateIndebtForm;
import com.billshare.repositories.BillRepository;
import com.billshare.repositories.IndebtRepository;
import com.billshare.utils.BillShareMessages;
import com.billshare.utils.ExceptionMessages;

@Service
public class BillService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FriendService friendService;
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	CurrencyService currencyService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	IndebtRepository indebtRepository;
	

	public List<BillEntity> getUserInvolvedBills(String token){
		UserEntity user = userService.findUser(token);
		List<BillEntity> bills = user.getIndebtBills().stream().map(indebt -> indebt.getBill()).collect(Collectors.toList());
//		//removing bills in groups
		return bills.stream().filter(bill -> bill.getGroup() == null).collect(Collectors.toList());
	}
	
	public BillEntity getBillInformation(Long billId) {
		BillEntity bill = billRepository.getById(billId);
		if(bill == null)
			throw new RecordNotFoundException(ExceptionMessages.BILL_NOT_FOUND);
		return bill;
	}
	
	public String createBill(String token, CreateBillForm createBillForm) {
		
		if(createBillForm.getDueDate().isBefore(LocalDate.now()))
			throw new BillShareException(ExceptionMessages.PAST_DUE_DATE);
		
		//currency code validation
		CurrencyEntity currencyEntity = currencyService.getCurrencyByCode(createBillForm.getCurrencyCode());
		if(currencyEntity == null)
			throw new BillShareException(ExceptionMessages.NO_CURRENCY_FOUND);
		
		UserEntity creator = userService.findUser(token);
		
		GroupEntity group = null;
		if(createBillForm.getGroupId() != null) {
			group = groupService.getGroupById(createBillForm.getGroupId());
		}
		
		BillEntity billEntity = new BillEntity(createBillForm);
		billEntity.setCurrency(currencyEntity);
		billEntity.setCreatedBy(creator);
		billEntity.setLastUpdateBy(creator);
		billEntity.setGroup(group);
		
		List<UserEntity> groupMembers = group.getMembers().stream().map(rec -> rec.getMember()).collect(Collectors.toList());
		
		List<UserEntity> friends = friendService.getAllFriendsofUser(creator.getEmail());
		
		List<IndebtEntity> indebtEntities = new ArrayList<>();
		
		BigDecimal sumOfIndebtAmounts = new BigDecimal(0);
		
		boolean isCreatorInvolved = false;
		
		//debtors validation
		for(CreateIndebtForm debtorInfo : createBillForm.getDebtorsInfo()) {
			UserEntity debtor = userService.findUserByEmail(debtorInfo.getEmail());
			if(debtor.getEmail() == creator.getEmail()) {
				isCreatorInvolved = true;
			}
			else if(group == null && friends.contains(debtor) == false)
				throw new BillShareException(debtor.firstName + " " + debtor.getLastName() + " is not in your friends list. Can not create a bill.");
			
			else if(group != null && groupMembers.contains(debtor) == false)
				throw new BillShareException(debtor.firstName + " " + debtor.getLastName() + " is not in the group. Can not create a bill.");
			
			//linking bill and user to each indebt record
			indebtEntities.add(new IndebtEntity(debtor, billEntity, debtorInfo.getAmount()));
			sumOfIndebtAmounts = sumOfIndebtAmounts.add(debtorInfo.getAmount());
		}
		
		if(isCreatorInvolved == false) {
			indebtEntities.add(new IndebtEntity(creator, billEntity, new BigDecimal(0)));
		}
		
		//if sum of individual amounts is greater than total amount
		if(sumOfIndebtAmounts.compareTo(createBillForm.getAmount()) == 1)
			throw new BillShareException(ExceptionMessages.INDEBTS_AMNTS_EXCEED);
		//linking debtors to single bill record.
		billEntity.setDebtors(indebtEntities);
		billRepository.save(billEntity);
		return BillShareMessages.BILL_CREATED;
	}
}
