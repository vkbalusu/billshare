package com.billshare.mappers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.billshare.entities.BillEntity;
import com.billshare.entities.CurrencyEntity;
import com.billshare.entities.UserEntity;
import com.billshare.models.dtos.BillInfoDTO;
import com.billshare.models.dtos.BillMetaDTO;

@Mapper
public interface BillDTOMapper {
	
	
	@Mapping(source = "currency", target = "currency", qualifiedByName = "currencyToCurrencyCode")
	@Mapping(source = "createdBy", target = "createdBy", qualifiedByName = "getUserName")
	@Mapping(source = "creationDate", target = "creationDate", qualifiedByName = "toLocalDateTime")
	@Mapping(source = "dueDate", target = "overDue", qualifiedByName = "isBillOverDue")
	BillInfoDTO convertEntityToDTO(BillEntity bill);
	
	@Mapping(source = "currency", target = "currency", qualifiedByName = "currencyToCurrencyCode")
	@Mapping(source = "createdBy", target = "createdBy", qualifiedByName = "getUserName")
	@Mapping(source = "creationDate", target = "creationDate", qualifiedByName = "toLocalDateTime")
	@Mapping(source = "dueDate", target = "overDue", qualifiedByName = "isBillOverDue")
	BillMetaDTO convertEntitytoMetaDTO(BillEntity bill);
	
	@Named("currencyToCurrencyCode")
    public static String currencyToCurrencyCode(CurrencyEntity currencyEntity) {
        return currencyEntity.getCurrencyCode();
    }
	
	@Named("getUserName")
	public static String getUserName(UserEntity userEntity) {
        return userEntity.getFirstName() + " " + userEntity.getLastName();
    }
	
	@Named("toLocalDateTime")
	public static String toLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
	
	@Named("isBillOverDue")
	public static boolean isBillOverDue(LocalDate dueDate) {
		return dueDate.isBefore(LocalDate.now());
	}
}
