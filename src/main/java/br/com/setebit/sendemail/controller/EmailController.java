package br.com.setebit.sendemail.controller;

import br.com.setebit.sendemail.request.EmailRequest;
import br.com.setebit.sendemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("send")
    public ResponseEntity<String> send(@RequestBody EmailRequest emailRequest){
        if( emailService.sendSimpleMessage(emailRequest))
            return new ResponseEntity<>("ok", HttpStatus.OK);
        return new ResponseEntity<>("ocorreu error ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
