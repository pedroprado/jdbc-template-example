package jdbcexample.jdbcexample.repository;

import jdbcexample.jdbcexample.model.Customer;
import jdbcexample.jdbcexample.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> listCustomers(String GET_ALL_CUSTOMERS_QUERY) {
        return  jdbcTemplate.query(GET_ALL_CUSTOMERS_QUERY,
                (res, rowNum)->
                        new Customer(
                                res.getInt("customer_id"), res.getString("first_name"),
                                res.getString("last_name"), res.getDate("birth_date"),
                                res.getString("phone"), res.getString("address"),
                                res.getString("city"), res.getString("state"),
                                res.getInt("points")
                        ));
    }

    public Customer getCustomerById(String GET_CUSTOMER_BY_ID_QUERY, int customer_id) {
        return jdbcTemplate.queryForObject(GET_CUSTOMER_BY_ID_QUERY,
                new Object[]{customer_id},
                new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public void createCustomer(String CREATE_CUSTOMER_QUERY, Customer customer){
        jdbcTemplate.update(CREATE_CUSTOMER_QUERY, new Object[]{
                customer.getCustomer_id(), customer.getFirst_name(), customer.getLast_name(), customer.getBirth_date(),
                customer.getPhone(), customer.getAddress(), customer.getCity(), customer.getState(),
                customer.getPoints()
        });
    }

    public void updateCustomer(String UPDATE_CUSTOMER_QUERY, Customer customer, Integer customer_id){
        jdbcTemplate.update(UPDATE_CUSTOMER_QUERY, new Object[]{
                customer.getFirst_name(), customer.getLast_name(), customer.getBirth_date(),
                customer.getPhone(), customer.getAddress(), customer.getCity(), customer.getState(),
                customer.getPoints(), customer_id
        });
    }

    public void deleteCustomer(String DELETE_CUSTOMER_QUERY, int customer_id) {
        jdbcTemplate.update(DELETE_CUSTOMER_QUERY, new Object[]{customer_id});
    }
}
