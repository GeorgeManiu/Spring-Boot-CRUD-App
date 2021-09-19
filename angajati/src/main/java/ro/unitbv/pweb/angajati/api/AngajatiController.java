package ro.unitbv.pweb.angajati.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ro.unitbv.pweb.angajati.model.AngajatiModel;
import ro.unitbv.pweb.angajati.service.AngajatiService;

@Controller
public class AngajatiController {
	
	@Autowired
	private AngajatiService  angajatiService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listAngajati", angajatiService.getAllAngajati());
		return "index";
	}
	@GetMapping("/angajatNou")
	public String angajatNou(Model model) {
		AngajatiModel angajat =new AngajatiModel();
		model.addAttribute("angajat", angajat);
		return "angajat_nou";	
	}
	
	@PostMapping("/saveAngajat")
	public String saveAngajat(@ModelAttribute("angajat") AngajatiModel angajat) {
		 angajatiService.saveAngajat(angajat);
		 return "redirect:/";
	}

	@GetMapping("/updateAngajat/{id}")
	public String updateAngajat(@PathVariable (value = "id") long id, Model model) {
		AngajatiModel angajat =angajatiService.getaAngajatiModelbyId(id);
		model.addAttribute("angajat", angajat);
		return "update_angajat";
	}

	@GetMapping("/deleteAngajat/{id}")
	public String deleteAngajatiModelById(@PathVariable (value = "id") long id) {
		this.angajatiService.deleteAngajatiModelById(id);
		 return "redirect:/";
	}
}