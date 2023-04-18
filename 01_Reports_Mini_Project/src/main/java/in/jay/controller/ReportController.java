package in.jay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.jay.entity.CitizenPlan;
import in.jay.request.SearchRequest;
import in.jay.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search")SearchRequest search, Model model) {

		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans", plans);
		//model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	
		return "index";
	}

	
	
	@GetMapping("/")
	public String indexPage(Model model) {
		
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {
		//model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}

}
