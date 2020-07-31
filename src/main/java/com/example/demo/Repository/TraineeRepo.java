package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Trainee;


@Repository
public interface TraineeRepo extends JpaRepository<Trainee, Integer> {
	
	public List<Trainee> findByTechnology(String tech);
	public List<Trainee> findByClient(String client);
	public List<Trainee> findByMarkGreaterThan(int mark);
	public List<Trainee> findBySalary(int salary);
	public List<Trainee> findByAddress(String address);
	
	@Query(value="Select max(mark) from consultant", nativeQuery=true)
	public int maxmarks();
	
	@Query(value="Select max(salary) from consultant", nativeQuery=true)
	public int maxsalary();
	
	@Query(value="Select max(salary) from consultant where client=?1", nativeQuery=true)
	public int maxsalaryclient(String c);
	
	@Query(value="Select max(salary) from consultant where client=?1 and technology=?2", nativeQuery=true)
	public int number1techconsultants(String client, String tech);
	
	@Query(value="Select distinct client from consultant", nativeQuery=true)
	public List<String> listofClients();
	 
	@Query(value="Select distinct address from consultant", nativeQuery=true)
	public List<String> listofAddress();
}
