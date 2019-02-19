package kr.co.ensecure.piias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piias")
public class PiiasController {

	@GetMapping("/test")
	public String test() {
		return "Rest request is successful.";
	}
	
}
