package com.telstra.springboot.endpoint;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telstra.springboot.domain.Customer;
import com.telstra.springboot.repository.CustomerRepository;

/**
 * <pre>
 * 
 * the serviceName is used by SimpleJaxWsServiceExporter to export to
 * http://0.0.0.0:7080/serviceName?wsdl
 * 
 * the name is Used as the name of the wsdl:portType when mapped to WSDL 1.1.
 * the serviceName is Used as the name of the wsdl:service when mapped to WSDL 1.1.
 * the portName is Used as the name of the wsdl:port when mapped to WSDL 1.1.
 * 
 * You can use the endpointInterface attribute to separate between the implementing class and the interface. 
 * Basically, this determines what will be mapped to your wsdl:portType when you deploy the service and the wsdl:definition is generated.
 * 
 * If you do not define the endpointInterface all public methods of the annotated class will be mapped to wsdl:operation 
 * (as long as you do not influence this behaviour with @WebMethod annotations).
 * 
 * If you do define the endpointInterface, it has to point to some type which the annotated class implements 
 * (or, well, itself as demonstrated in your question). Then, the public methods of this type are used for mapping the wsdl:portType,
 * instead of the methods of the annotated class.
 *  
 * sum up: The definition of endpointInterface only makes sense if you use the @WebService on an implementing class and want 
 * your WSDL to be generated based on the interface it implements. In your current setting where you use the annotation on the interface com.ws.HelloWorldIfc, 
 * there really isn't any difference. So you lose nothing by just skipping it. The annotation is useful if you want your implementation 
 * class to provide public methods that should not go into the generated WSDL.
 * </pre>
 * 
 * @author d716042
 *
 */
@Service
@WebService(name = "CustomerService", serviceName = "CustomerService", portName = "CustomerServicePort", endpointInterface = "com.telstra.springboot.endpoint.CustomerService")
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	private CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@WebMethod
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}

	@WebMethod
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@WebMethod
	public Customer get(Long id) {
		return customerRepository.findOne(id);

	}

	@WebMethod
	public List<Customer> list() {
		return customerRepository.findAll();
	}

}
