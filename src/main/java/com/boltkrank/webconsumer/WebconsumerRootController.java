package com.boltkrank.webconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebconsumerRootController {
    
    @GetMapping("/")
    public String index() {
        return "Hello from Web Consumer";
    }

}
