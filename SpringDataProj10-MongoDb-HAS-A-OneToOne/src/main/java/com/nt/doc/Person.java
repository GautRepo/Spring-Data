package com.nt.doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	@Id
	private Integer pid;
	private String pname;
	private String padd;
	private DrivingLicence licence;
	
	

}
