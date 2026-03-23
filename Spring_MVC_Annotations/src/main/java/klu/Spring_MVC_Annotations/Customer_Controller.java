package klu.Spring_MVC_Annotations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Customer_Controller {

  List<Customer> customers  = new ArrayList<Customer>();
  
  //add customer
  @PostMapping("/addcustomer")
  public String getcutomers(@RequestBody Customer cust) {
    customers.add(cust);
    return "customer added successfully";
    
  }
  
  //view customers
  @GetMapping("/displaycustomer")
  public List<Customer> viewcustomer(){
	  return customers;
  }
}