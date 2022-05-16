package com.billshare.models.dtos;

import java.util.List;

public class BillInfoDTO extends BillMetaDTO{
	
	
    public List<IndebtDTO> debtors;
    
    public BillInfoDTO() {
    	
    }
    
	public BillInfoDTO(List<IndebtDTO> debtors) {
		super();
		this.debtors = debtors;
	}

	public List<IndebtDTO> getDebtors() {
		return debtors;
	}

	public void setDebtors(List<IndebtDTO> debtors) {
		this.debtors = debtors;
	}

}
