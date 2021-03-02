package com.nt.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	private String sid;
	private Integer sno;
	private String sname;
	private Integer marks[];
	private List<String> sub;
	private Set<Long> phone;
	private Map<String,Integer> ageDetails;
	private Properties batchInfo;
	
	

}
