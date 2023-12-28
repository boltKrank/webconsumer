package com.boltkrank.webconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class WebconsumerRootController {
    
    @GetMapping("/")
	public String consumerForm(Model model) {
		model.addAttribute("consumer", new Consumer());
		return "webconsumer";
	}

}
