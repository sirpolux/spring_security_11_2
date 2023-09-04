package com.example.spring_security_v11.registration.token;



import com.example.spring_security_v11.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date expirationTime;

    public  VerificationToken(String token, User user,int duration){
        super();
        this.token=token;
        this.user=user;
        this.expirationTime=this.getTokenExpirationTime(duration);
    }

    public  VerificationToken(String token, int duration){
        super();
        this.token=token;
        this.expirationTime=this.getTokenExpirationTime(duration);
    }

    private Date getTokenExpirationTime(int duration) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,duration);
        return new Date(calendar.getTime().getTime());
    }
}
