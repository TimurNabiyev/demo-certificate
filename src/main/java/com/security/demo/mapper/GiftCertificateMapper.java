package com.security.demo.mapper;

import com.security.demo.model.dto.GiftCertificateDto;
import com.security.demo.model.entity.GiftCertificate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface GiftCertificateMapper {
    GiftCertificate toEntity(GiftCertificateDto giftCertificateDto);
    GiftCertificateDto toDto(GiftCertificate entity);
}
