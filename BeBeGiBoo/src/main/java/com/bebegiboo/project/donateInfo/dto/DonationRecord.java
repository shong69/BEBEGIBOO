package com.bebegiboo.project.donateInfo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DonationRecord {
	
	private int recordNo; 
	private String date; 
	private int donatorNo; 
	private int acceptorNo; 

}
