package com.intern.demoproject.controller;

import com.intern.demoproject.dto.commom.CustomResponseEntity;
import com.intern.demoproject.email.SendHTMLEmailRequest;
import com.intern.demoproject.service.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "Email Controller", description = "Send email to customer")
@RequestMapping("/api/v1/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/sendHTMLEmail")
    public CustomResponseEntity<String> sendHTMLEmail(@RequestBody SendHTMLEmailRequest sendHTMLEmailRequest) {

        emailService.htmlSend(sendHTMLEmailRequest);

        return CustomResponseEntity.of("Email Queued");
    }

}
