package com.example.spring_security_v11.registration;

import com.example.spring_security_v11.event.RegistrationCompleteEvent;
import com.example.spring_security_v11.user.IUserServices;
import com.example.spring_security_v11.user.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
    private  final IUserServices userServices;
    private final ApplicationEventPublisher publisher;
    @PostMapping("/save")
    public String registerUser(RegistrationRequest registrationRequest, final HttpServletRequest request){
        User user=userServices.registerUser(registrationRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
        return "Success! Please check your email to complete the registration process.";
    }

    @GetMapping("/verify")
    public  String verifyEmail(){

        return "";

    }
    private String applicationUrl(HttpServletRequest request) {
        String link= "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        System.out.println(link);
        return link;
    }


}
