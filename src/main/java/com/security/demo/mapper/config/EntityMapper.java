package com.security.demo.mapper.config;

import java.util.List;

/**
 * The interface that defines basic methods for mapping sto to entity. Object types are generic and
 * must be specified in parameters of class
 *
 * @param <T>
 * @param <S>
 */
public interface EntityMapper<T, S> {

    T toEntity(S dto);

    List<T> toEntityList(List<S> dtoList);

}
