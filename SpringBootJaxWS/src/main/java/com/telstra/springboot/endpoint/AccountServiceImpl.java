package com.telstra.springboot.endpoint;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.telstra.springboot.domain.Customer;

@Service
@WebService(name = "AccountService", portName = "AccountServicePort", serviceName = "AccountService", endpointInterface = "com.telstra.springboot.endpoint.AccountService")
public class AccountServiceImpl implements AccountService {

	@Override
	public String getAccountNumber(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
