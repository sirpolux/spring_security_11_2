package com.example.spring_security_v11.registration;


public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role){
}
