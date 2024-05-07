package com.bebegiboo.project.certification.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bebegiboo.project.certification.model.dto.Certification;

public interface CertificationService  {

	int certificationSubmit(Certification inputCertification, String[] memberAddress, List<MultipartFile> images) throws IllegalStateException, IOException;

}
