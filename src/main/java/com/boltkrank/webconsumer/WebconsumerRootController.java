package com.boltkrank.webconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class WebconsumerRootController {
    
    @GetMapping("/")
	public String consumerForm(Model model) {
		model.addAttribute("consumer", new Consumer());
		return "webconsumer_input";
	}

    @PostMapping("/")
	public String consumerSubmit(@ModelAttribute Consumer consumer, Model model) {

		model.addAttribute("consumer", consumer);

        System.out.println("Level: " + consumer.getLevel());

        System.out.println("Iterations: " + consumer.getIterations());

        consumer.runConsumption();

	  
	  return "webconsumer_output";
	}

}
