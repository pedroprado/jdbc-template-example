package jdbcexample.jdbcexample.model;

import java.util.Date;

public class CustomerOrderData {

    private String first_name;
    private String last_name;
    private Date order_date;
    private String shipper_name;

    public CustomerOrderData(){}

    public CustomerOrderData(String first_name, String last_name, Date order_date, String shipper_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.order_date = order_date;
        this.shipper_name = shipper_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getShipper_name() {
        return shipper_name;
    }

    public void setShipper_name(String shipper_name) {
        this.shipper_name = shipper_name;
    }
}
