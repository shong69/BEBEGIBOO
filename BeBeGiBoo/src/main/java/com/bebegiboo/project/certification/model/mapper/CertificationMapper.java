package com.bebegiboo.project.certification.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bebegiboo.project.certification.model.dto.Certification;
import com.bebegiboo.project.certification.model.dto.CertificationImg;


@Mapper
public interface CertificationMapper {

	int certificationSubmit(Certification inputCertification);

	int insertUploadList(List<CertificationImg> uploadImgs);

}
