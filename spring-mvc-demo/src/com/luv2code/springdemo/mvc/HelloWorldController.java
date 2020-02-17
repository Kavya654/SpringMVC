package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// show the initial form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// process the form data

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// read form data through new controller method and add data to model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		String name = request.getParameter("studentName");

		name = name.toUpperCase();

		String result = "Yo! " + name;

		model.addAttribute("message", result);

		return "helloworld";

	}

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {

		name = name.toUpperCase();

		String result = "Hello My friend from Spring!! " + name;

		model.addAttribute("message", result);

		return "helloworld";

	}

}
