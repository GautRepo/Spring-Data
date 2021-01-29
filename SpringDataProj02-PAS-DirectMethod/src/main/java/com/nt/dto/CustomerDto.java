package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class CustomerDto implements Serializable {
	@NonNull
	private Integer cno;
	private String cname;
	private String cadd;
	private double bAmt;

}
