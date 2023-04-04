package com.security.demo.mapper.dto;

import com.security.demo.mapper.config.AppMapperConfig;
import com.security.demo.mapper.config.DtoMapper;
import com.security.demo.mapper.config.EntityMapper;
import com.security.demo.model.dto.TagDto;
import com.security.demo.model.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(config = AppMapperConfig.class)
public interface TagMapper extends DtoMapper<TagDto, Tag>, EntityMapper<Tag, TagDto> {
}
