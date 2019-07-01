package jdbcexample.jdbcexample.model;

public class Shipper {

    private Integer shipper_id;
    private String name;

    public Shipper(){}

    public Shipper(Integer shipper_id, String name) {
        this.shipper_id = shipper_id;
        this.name = name;
    }

    public Integer getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(Integer shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
