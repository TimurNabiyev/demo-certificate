package com.security.demo.mapper.dto;

import com.security.demo.mapper.config.AppMapperConfig;
import com.security.demo.mapper.config.DtoMapper;
import com.security.demo.mapper.config.EntityMapper;
import com.security.demo.model.dto.GiftCertificateDto;
import com.security.demo.model.entity.GiftCertificate;
import org.mapstruct.Mapper;

@Mapper(config = AppMapperConfig.class)
public interface GiftCertificateMapper extends EntityMapper<GiftCertificate, GiftCertificateDto>,
        DtoMapper<GiftCertificateDto, GiftCertificate> {
}
