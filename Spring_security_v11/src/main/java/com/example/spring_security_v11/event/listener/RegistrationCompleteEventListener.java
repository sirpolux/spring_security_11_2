package com.example.spring_security_v11.event.listener;

import com.example.spring_security_v11.event.RegistrationCompleteEvent;
import com.example.spring_security_v11.user.IUserServices;
import com.example.spring_security_v11.user.User;
import com.example.spring_security_v11.user.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private  final IUserServices userServices;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //1. GET NEWLY REGISTERED USER
        User user = event.getUser();
        //2. CREATE A VERIFICATION TOKEN FOR USER
        String verificationToken = UUID.randomUUID().toString();
        System.out.println(verificationToken);
        userServices.saveUserVerificationToken(user,verificationToken);
        //3. SAVE VERIFICATION TOKEN FOR USER
        //4. BUILD VERIFICATION URL
        String url= event.getApplicationUrl()+"/register/verify_email?token="+verificationToken;
        //5. SEND EMAIL
        log.info("Click on the link to verify your email: {}",url);
    }
}
