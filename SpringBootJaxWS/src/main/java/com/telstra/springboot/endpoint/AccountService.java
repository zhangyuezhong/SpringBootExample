package com.telstra.springboot.endpoint;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.telstra.springboot.domain.Customer;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface AccountService {

	public String getAccountNumber(Customer customer);
}
