package com.example.spring_security_v11.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IVerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
