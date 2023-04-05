package com.security.demo.service.impl;

import com.security.demo.exception.GiftCertificateIsNotEnabledException;
import com.security.demo.mapper.dto.GiftCertificateMapper;
import com.security.demo.mapper.dto.TagMapper;
import com.security.demo.mapper.request.GiftCertificateCreateMapper;
import com.security.demo.mapper.request.GiftCertificateUpdateMapper;
import com.security.demo.model.dto.GiftCertificateDto;
import com.security.demo.model.entity.GiftCertificate;
import com.security.demo.model.entity.Tag;
import com.security.demo.model.request.GiftCertificateCreateRequest;
import com.security.demo.model.request.GiftCertificateUpdateRequest;
import com.security.demo.repository.GiftCertificateRepository;
import com.security.demo.service.GiftCertificateService;
import com.security.demo.service.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GiftCertificateServiceImpl implements GiftCertificateService {

    private final TagService tagService;
    private final TagMapper tagMapper;
    private final GiftCertificateMapper giftCertificateMapper;
    private final GiftCertificateRepository giftCertificateRepository;
    private final GiftCertificateCreateMapper giftCertificateCreateMapper;
    private final GiftCertificateUpdateMapper giftCertificateUpdateMapper;
    private static final String NOT_FOUND = " not found";

    @Modifying
    @Override
    public GiftCertificateDto create(GiftCertificateCreateRequest request) {
        log.info("Creating gift certificate... ");
        GiftCertificate giftCertificate = giftCertificateCreateMapper.toEntity(request);

        List<Tag> tags = tagMapper.toEntityList(tagService.create(request.getTagCreateRequest()));

        giftCertificate.setTags(tags);
        giftCertificate.setCreateDate(LocalDateTime.now());
        giftCertificate.setLastUpdateDate(LocalDateTime.now());
        giftCertificate.setExpirationDate(LocalDateTime.now().plusDays(request.getDurationInDays()));
        giftCertificateRepository.save(giftCertificate);

        return giftCertificateMapper.toDto(giftCertificate);
    }

    @Override
    public GiftCertificateDto getOne(Long id) {
        log.info("Searching for certificate by id = {}", id);
        return giftCertificateMapper.toDto(giftCertificateRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Modifying
    @Override
    public GiftCertificateDto updateOne(GiftCertificateUpdateRequest request, Long id) {
        log.info("Update certificate by id = {}", id);
        if (!giftCertificateRepository.existsById(id)) {
            throw new EntityNotFoundException("Gift Certificate by id = {}" + id + NOT_FOUND);
        }
        GiftCertificate giftCertificate = giftCertificateUpdateMapper.toEntity(request);
        return giftCertificateMapper.toDto(giftCertificateRepository.save(giftCertificate));
    }

    @Modifying
    @Override
    public GiftCertificateDto deleteOne(Long id) {
        log.info("Delete one by id = {}", id);
        return giftCertificateMapper.toDto(giftCertificateRepository.findById(id).map(n -> {
            if (Boolean.FALSE.equals(n.getIsEnabled())) {
                throw new GiftCertificateIsNotEnabledException();
            }
            n.setIsEnabled(false);
            return giftCertificateRepository.save(n);
        }).orElseThrow(() -> new EntityNotFoundException("Gift Certificate by id = " + id + NOT_FOUND)));
    }

    @Modifying
    @Override
    public GiftCertificateDto deleteOne(String name) {
        log.info("Delete one Certificate by name = {}", name);
        return giftCertificateMapper.toDto(giftCertificateRepository.findByName(name).map(n -> {
            if (Boolean.FALSE.equals(n.getIsEnabled())) {
                throw new GiftCertificateIsNotEnabledException();
            }
            n.setIsEnabled(false);
            return giftCertificateRepository.save(n);
        }).orElseThrow(() -> new EntityNotFoundException("Gift Certificate by name = " + name + NOT_FOUND)));
    }

    @Modifying
    @Override
    public GiftCertificateDto entirelyDelete(Long id) {
        log.info("Entirely deleting from DB by id = {}", id);
        GiftCertificate giftCertificate = giftCertificateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gift certificate by id = " + id + NOT_FOUND));
        giftCertificateRepository.deleteById(id);
        return giftCertificateMapper.toDto(giftCertificate);
    }
}
