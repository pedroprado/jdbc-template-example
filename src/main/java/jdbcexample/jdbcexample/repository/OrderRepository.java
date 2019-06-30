package jdbcexample.jdbcexample.repository;

import jdbcexample.jdbcexample.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Order> listOrders(String GET_ALL_ORDERS_QUERY) {
        return  jdbcTemplate.query(GET_ALL_ORDERS_QUERY,
                (res, rowNum)->
                new Order(
                        res.getInt("order_id"), res.getInt("customer_id"),
                        res.getDate("order_date"), res.getInt("status"),
                        res.getString("comments"), res.getDate("shipped_date"),
                        res.getInt("shipper_id")
                ));
    }

    public Order getOrderById(String GET_ORDER_BY_ID_QUERY, int order_id) {
        return jdbcTemplate.queryForObject(GET_ORDER_BY_ID_QUERY,
                new Object[]{order_id},
                new BeanPropertyRowMapper<Order>(Order.class));
    }

    public void createOrder(String CREATE_ORDER_QUERY, Order order){
        jdbcTemplate.update(CREATE_ORDER_QUERY, new Object[]{
                order.getOrder_id(), order.getCustomer_id(), order.getOrder_date(), order.getStatus(), order.getComments(),
                order.getShipped_date(), order.getShipper_id()
        });
    }

    public void updateOrder(String UPDATE_ORDER_QUERY, Order order, Integer order_id){
        jdbcTemplate.update(UPDATE_ORDER_QUERY, new Object[]{
                order.getCustomer_id(), order.getOrder_date(), order.getStatus(), order.getComments(),
                order.getShipped_date(), order.getShipper_id(), order_id
        });
    }

    public void deleteOrder(String DELETE_ORDER_QUERY, int order_id) {
        jdbcTemplate.update(DELETE_ORDER_QUERY, new Object[]{order_id});
    }
}
