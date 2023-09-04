package com.example.spring_security_v11.user;

import com.example.spring_security_v11.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface IUserServices {
    List<User> getALlUsers();
    Optional<User> findByEmail(String email);
    User registerUser(RegistrationRequest registrationRequest);

    void saveUserVerificationToken(User user, String verificationToken);
}
