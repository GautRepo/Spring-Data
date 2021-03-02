package com.nt.doc;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrivingLicence {

	@Id
	private Long lid;
	private String type;
	private LocalDate expiryDate;
	
}
