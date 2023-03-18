package com.security.demo.mapper;

import com.security.demo.model.dto.TagDto;
import com.security.demo.model.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface TagMapper {

    Tag toEntity(TagDto tagDto);

    TagDto toDto(Tag entity);
}
