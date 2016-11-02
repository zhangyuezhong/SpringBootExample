package com.telstra.springboot.endpoint;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.telstra.springboot.domain.Customer;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface CustomerService {
	@WebMethod
	public void delete(Customer customer);
	
	@WebMethod
	public Customer save(Customer customer);

	@WebMethod
	public Customer get(Long id);

	@WebMethod
	public List<Customer> list();
}
