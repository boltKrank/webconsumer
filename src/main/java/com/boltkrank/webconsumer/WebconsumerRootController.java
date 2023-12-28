package com.boltkrank.webconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;


@RestController
public class WebconsumerRootController {
    
    @GetMapping("/")
	public String revHashForm(Model model) {
		model.addAttribute("consumer", new Consumer());
		return "webconsumer";
	}

}
