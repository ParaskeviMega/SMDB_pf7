package com.pf7.smdb.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MvcController {
	

	@GetMapping
	public String index(){
		return "index";
	}

	@GetMapping("/movie")
	public String indexMovie(){
		return "movie";
	}

	@GetMapping("/show")
	public String indexShow(){
		return "show";
	}

	@GetMapping("/person")
	public String indexPerson(){
		return "person";
	}
}
