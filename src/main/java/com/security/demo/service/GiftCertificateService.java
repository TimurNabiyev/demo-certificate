package com.security.demo.service;

import com.security.demo.model.dto.GiftCertificateDto;
import com.security.demo.model.request.GiftCertificateCreateRequest;
import com.security.demo.model.request.GiftCertificateUpdateRequest;

public interface GiftCertificateService {
    GiftCertificateDto create(GiftCertificateCreateRequest giftCertificateCreateRequest);
    GiftCertificateDto getOne(Long id);

    GiftCertificateDto updateOne(GiftCertificateUpdateRequest request, Long id);

    GiftCertificateDto deleteOne(Long id);
    GiftCertificateDto deleteOne(String name);
    GiftCertificateDto entirelyDelete(Long id);
}
