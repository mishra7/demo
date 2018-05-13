package com.tcs;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.entity.Customer;
import com.tcs.service.CustomerRepository;
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		System.out.println("DATASOURCE = " + dataSource);

		System.out.println("\n1.findAll()...");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println("*************Customer details***************");
			System.out.println("Id :"+customer.getId());
			System.out.println("Name : "+customer.getName());
			System.out.println("email: "+customer.getEmail());
			
		}

		System.out.println("\n2.findByEmail(String email)...");
		for (Customer customer : customerRepository.findByEmail("mishra_ranjit7@optum.com")) {
			System.out.println(customer);
			System.out.println("*************Customer details***************");
			System.out.println("Id :"+customer.getId());
			System.out.println("Name : "+customer.getName());
			System.out.println("email: "+customer.getEmail());
			
		}

		System.out.println("Done!");

	}

}
