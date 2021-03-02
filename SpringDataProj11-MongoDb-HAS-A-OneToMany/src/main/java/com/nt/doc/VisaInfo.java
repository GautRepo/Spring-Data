package com.nt.doc;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class VisaInfo {
	@Id
	private Long visaNo;
	private String contry;
	private LocalDate expDate;

}
