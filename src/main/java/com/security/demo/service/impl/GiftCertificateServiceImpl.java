package com.security.demo.service.impl;

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
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public GiftCertificateDto updateOne(GiftCertificateUpdateRequest request, Long id) {
        if (!giftCertificateRepository.existsById(id)) {
            throw new EntityNotFoundException("Gift Certificate by id = {}" + id + " not found");
        }
        GiftCertificate giftCertificate = giftCertificateUpdateMapper.toEntity(request);
        return giftCertificateMapper.toDto(giftCertificateRepository.save(giftCertificate));
    }

    @Override
    public GiftCertificateDto deleteOne(Long id) {
        return null;
    }

    @Override
    public GiftCertificateDto deleteOne(String name) {
        return null;
    }

    @Override
    public GiftCertificateDto entirelyDelete(Long id) {
        return null;
    }
}
