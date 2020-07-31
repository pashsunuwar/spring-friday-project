package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Trainee;
import com.example.demo.Service.TraineeService;

@RestController
public class TraineeController {
	
	@Autowired
	TraineeService service;
	
	@PostMapping("/newconsultant")
	public String newconsultant(@RequestBody Trainee t) {
		return service.newconsultant(t);
	}

	
	@GetMapping("/showallclients/{client}/")
	public List<Trainee> showclients(@PathVariable("client") String client){
		return service.clientTrainees(client);	
	}
	
	//find all data by entering a mark for e.g (120) //works
	@GetMapping("/marks/{m}")
	public List<Trainee> consultantmarks(@PathVariable("m") int m) {
		return service.consultantbymark(m);
	}
	
	// works
	@GetMapping("/maxsalary")
	public int maxSalary() {
		return service.maxsalary();
	}
	
	// works
	@GetMapping("/maxsalary/{client}")
	public int maxSalaryClinet(@PathVariable("client")String client) {
		return service.maxsalaryclient(client);
	}
	
	// works
	//highest paid consultant on site
	@GetMapping("/number1techconsultants/{client}/{tech}")
	public int number1techconsultants(@PathVariable("client")String client,
			@PathVariable("tech") String tech) {
		return service.numbertechconsultants(client, tech);
	}
	
	// works
	@GetMapping("/listofclients")
	public List<String> listofclients() {
		return service.listofClients();
	}
}
