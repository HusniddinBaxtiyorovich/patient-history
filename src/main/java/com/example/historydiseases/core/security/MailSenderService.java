package com.example.historydiseases.core.security;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender javaMailSender;

    void sendEmail(String toAccount, String subject, String text) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toAccount); // freepik45@gmail.com
        msg.setSubject(subject); //
        msg.setText(text); //
        javaMailSender.send(msg);
    }
}
