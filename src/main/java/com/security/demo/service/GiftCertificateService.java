package com.security.demo.service;

import com.security.demo.model.dto.GiftCertificateDto;

public interface GiftCertificateService {
    GiftCertificateDto create(GiftCertificateDto giftCertificateDto);
    GiftCertificateDto getOne(Long id);
}
