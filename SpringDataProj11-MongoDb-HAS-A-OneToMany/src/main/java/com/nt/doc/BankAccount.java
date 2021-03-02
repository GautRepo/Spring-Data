package com.nt.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class BankAccount {
	
	@Id
	private Long acno;
	private String type;
	private Float bal;

}
