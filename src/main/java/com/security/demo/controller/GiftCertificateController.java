package com.security.demo.controller;

import com.security.demo.model.dto.GiftCertificateDto;
import com.security.demo.model.request.GiftCertificateCreateRequest;
import com.security.demo.service.GiftCertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gift-certificate")
public class GiftCertificateController {

    private final GiftCertificateService giftCertificateService;

    @PostMapping
    public ResponseEntity<GiftCertificateDto> create(@RequestBody @Valid GiftCertificateCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(giftCertificateService.create(request));
    }

    @GetMapping("/{id}")
    public GiftCertificateDto getOne(@PathVariable Long id) {
        return giftCertificateService.getOne(id);
    }
}
