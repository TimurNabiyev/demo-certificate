package com.security.demo.repository;

import com.security.demo.model.entity.GiftCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftCertificateRepository extends JpaRepository<GiftCertificate, Long> {
}
