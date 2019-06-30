package jdbcexample.jdbcexample.model;

public class Product {
    private int shipper_id;
    private String name;

    public Product(){}

    public Product(int shipper_id, String name) {
        this.shipper_id = shipper_id;
        this.name = name;
    }

    public int getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
