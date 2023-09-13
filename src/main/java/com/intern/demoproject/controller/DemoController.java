package com.intern.demoproject.controller;

import com.intern.demoproject.dto.commom.CustomResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {



    @GetMapping("/hello")
    public CustomResponseEntity<String> hello() {
        return CustomResponseEntity.of("Body");
    }


}
