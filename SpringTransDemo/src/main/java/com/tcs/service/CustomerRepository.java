package com.tcs.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tcs.entity.Customer;

public interface CustomerRepository  extends CrudRepository<Customer,Integer>{
	
	 	List<Customer> findByEmail(String email);

		// custom query example and return a stream
	    @Query("select c from Customer c where c.email = :email")
	    Stream<Customer> findByEmailReturnStream(@Param("email") String email);

}
