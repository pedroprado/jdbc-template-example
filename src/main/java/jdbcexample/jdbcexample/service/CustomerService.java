package jdbcexample.jdbcexample.service;

import jdbcexample.jdbcexample.model.Customer;
import jdbcexample.jdbcexample.model.CustomerOrderData;
import jdbcexample.jdbcexample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    private final String GET_ALL_CUSTOMERS_QUERY = "select * from customers";
    private final String GET_CUSTOMER_BY_ID_QUERY = "select * from customers where customer_id =?";
    private final String CREATE_CUSTOMER_QUERY = "insert into customers(customer_id, first_name, last_name, birth_date, phone, address, city, " +
            "state, points) values (?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_CUSTOMER_QUERY = "update customers set first_name=?, last_name=?, birth_date=?, phone=?, address=?, " +
            "city=?, state=?, points=?  where customer_id=?";
    private final String DELETE_CUSTOMER_QUERY = "delete from customers where customer_id=?";

    private final String GET_CUSTOMER_ORDER_DATA_QUERY =
            "select c.first_name, c.last_name, o.order_date, s.name AS shipper_name from customers c " +
                    "inner join orders o ON c.customer_id = o.customer_id " +
                    "inner join shippers s ON o.shipper_id = s.shipper_id " +
                    "where c.first_name = ?";

    public List<Customer> listCustomers(){
        return customerRepository.listCustomers(GET_ALL_CUSTOMERS_QUERY);
    }

    public Customer getCustomerById(int customer_id){
        return customerRepository.getCustomerById(GET_CUSTOMER_BY_ID_QUERY, customer_id);
    }

    public void createCustomer(Customer customer){
        customerRepository.createCustomer(CREATE_CUSTOMER_QUERY, customer);
    }

    public void updateCustomer(int customer_id, Customer updatedCustomer){
        customerRepository.updateCustomer(UPDATE_CUSTOMER_QUERY, updatedCustomer, customer_id);
    }

    public void deleteCustomer(int customer_id){
        customerRepository.deleteCustomer(DELETE_CUSTOMER_QUERY, customer_id);
    }

    public List<CustomerOrderData> listCustomersOrderData(String customer_name) {
        return customerRepository.listCustomersOrderData(GET_CUSTOMER_ORDER_DATA_QUERY, customer_name);
    }
}
