package com.nt.doc;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class PersonInfo {
	@Id
	private Integer pid;
	private String pname;
	private String padd;
	private Set<VisaInfo> visaSet;
	private Map<String,BankAccount> mapAcc;

}
