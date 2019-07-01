package jdbcexample.jdbcexample.controller;

import jdbcexample.jdbcexample.model.Customer;
import jdbcexample.jdbcexample.model.CustomerOrderData;
import jdbcexample.jdbcexample.model.Shipper;
import jdbcexample.jdbcexample.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> listCustomers(){

        List<Customer> customers = customerService.listCustomers();
        return  new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(path = "/get_one/{customer_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(
            @PathVariable int customer_id
    ){
        Customer customer = customerService.getCustomerById(customer_id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createCustomer(
            @RequestBody Customer customer
    ){
        customerService.createCustomer(customer);
        return new ResponseEntity<>("{\"Message\": \"Created.\"}", HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/{customer_id}")
    public ResponseEntity<?> updatecustomerById(
            @RequestBody Customer updatedCustomer,
            @PathVariable Integer customer_id
    ){
        customerService.updateCustomer(customer_id, updatedCustomer);
        return new ResponseEntity<>("{\"Message\": \"Updated.\"}", HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{customer_id}")
    public ResponseEntity<?> deleteCustomerById(
            @PathVariable int customer_id
    ){
        customerService.deleteCustomer(customer_id);
        return new ResponseEntity<>("{\"Message\": \"Deleted.\"}", HttpStatus.OK);

    }

    @GetMapping(path = "/order_data/{customer_name}")
    public ResponseEntity<?> getCustomerOrderData(
            @PathVariable String customer_name
    ){
        List<CustomerOrderData> customerOrderData = customerService.listCustomersOrderData(customer_name);
        return  new ResponseEntity<>(customerOrderData, HttpStatus.OK);
    }
}
