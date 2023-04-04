package com.security.demo.mapper.request;

import com.security.demo.mapper.config.AppMapperConfig;
import com.security.demo.mapper.config.EntityMapper;
import com.security.demo.model.entity.GiftCertificate;
import com.security.demo.model.request.GiftCertificateCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = AppMapperConfig.class)
public interface GiftCertificateCreateMapper extends EntityMapper<GiftCertificate, GiftCertificateCreateRequest> {

    @Override
    @Mapping(target = "isEnabled", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "expirationDate", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "id", ignore = true)
    GiftCertificate toEntity(GiftCertificateCreateRequest request);
}
