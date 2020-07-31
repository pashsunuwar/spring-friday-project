package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Trainee;
import com.example.demo.Repository.TraineeRepo;

@Service
public class TraineeService {

	@Autowired
	TraineeRepo repo;

	//example
	public List<Trainee> clientTrainees(String c) {
		return repo.findByClient(c);
	}
	
	public String newconsultant(Trainee t) {
		repo.save(t);
		return "you did it!";
	}
	
	public List<Trainee> consultantbymark(int m) {
		return repo.findByMarkGreaterThan(m);	
	}
	
	public int maxsalary() {
		return repo.maxsalary();
	}
	
	public int maxsalaryclient(String client) {
		return repo.maxsalaryclient(client);
	}
	
	public int numbertechconsultants(String client, String tech ) {
		return repo.number1techconsultants(client, tech);
	}

	public List<String> listofClients() {
		return repo.listofClients(); 
	}
	
	
	
	
	
	
	
	
	
	
	
}
