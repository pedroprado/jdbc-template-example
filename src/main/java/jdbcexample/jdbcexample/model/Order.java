package jdbcexample.jdbcexample.model;

import java.util.Date;

public class Order {
    private Integer order_id;
    private Integer customer_id;
    private Date order_date;
    private Integer status;
    private String comments;
    private Date shipped_date;

    private Integer shipper_id;

    public Order() {
    }

    public Order(Integer order_id, Integer customer_id, Date order_date, Integer status, String comments, Date shipped_date, Integer shipper_id) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.status = status;
        this.comments = comments;
        this.shipped_date = shipped_date;
        this.shipper_id = shipper_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public Integer getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(Integer shipper_id) {
        this.shipper_id = shipper_id;
    }
}