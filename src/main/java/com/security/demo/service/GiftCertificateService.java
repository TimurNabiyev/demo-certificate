package com.security.demo.service;

import com.security.demo.model.dto.GiftCertificateDto;
import com.security.demo.model.entity.GiftCertificate;

public interface GiftCertificateService {
    GiftCertificateDto create(GiftCertificateDto giftCertificateDto);
    GiftCertificateDto getOne(Long id);
}
