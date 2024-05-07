package com.bebegiboo.project.certification.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Certification {
	
	
	private int cNo; 
	
	private String memberId; 
	private String memberName; 
	private String certificationId;
	private String memberBirth; 
	private String phone; 
	private String address; 
	
	//member
	private int memberNo;
	
	//image 

}
