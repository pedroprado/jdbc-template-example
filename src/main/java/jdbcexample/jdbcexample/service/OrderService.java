package jdbcexample.jdbcexample.service;

import jdbcexample.jdbcexample.model.Order;
import jdbcexample.jdbcexample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    private final String GET_ALL_ORDERS_QUERY = "select * from orders";
    private final String GET_ORDER_BY_ID_QUERY = "select * from orders where order_id =?";
    private final String CREATE_ORDER_QUERY = "insert into orders(order_id, customer_id, order_date, status, comments, shipped_date, shipper_id) values (?,?,?,?,?,?,?)";
    private final String UPDATE_ORDER_QUERY = "update orders set customer_id=?, order_date=?, status=?, comments=?, shipped_date=?, shipper_id=? where order_id=?";
    private final String DELETE_ORDER_QUERY = "delete from orders where order_id=?";
    public List<Order> listOrders(){
        return orderRepository.listOrders(GET_ALL_ORDERS_QUERY);
    }

    public Order getOrderById(int order_id){
        return orderRepository.getOrderById(GET_ORDER_BY_ID_QUERY, order_id);
    }

    public void createOrder(Order order){
        orderRepository.createOrder(CREATE_ORDER_QUERY, order);
    }

    public void updateOrder(int order_id, Order updatedOrder){
        orderRepository.updateOrder(UPDATE_ORDER_QUERY, updatedOrder, order_id);
    }

    public void deleteOrder(int order_id){
        orderRepository.deleteOrder(DELETE_ORDER_QUERY, order_id);
    }
}
