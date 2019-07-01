package jdbcexample.jdbcexample.service;

import jdbcexample.jdbcexample.model.Shipper;
import jdbcexample.jdbcexample.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;

    private final String GET_ALL_SHIPPERS_QUERY = "select * from shippers";
    private final String GET_SHIPPER_BY_ID_QUERY = "select * from shippers where shipper_id =?";
    private final String CREATE_SHIPPER_QUERY = "insert into shippers(shipper_id, name) values (?,?)";
    private final String UPDATE_SHIPPER_QUERY = "update shippers set name=? where shipper_id=?";
    private final String DELETE_SHIPPER_QUERY = "delete from shippers where shipper_id=?";

    public List<Shipper> listShippers(){
        return shipperRepository.listShippers(GET_ALL_SHIPPERS_QUERY);
    }

    public Shipper getShipperById(int shipper_id){
        return shipperRepository.getShipperById(GET_SHIPPER_BY_ID_QUERY, shipper_id);
    }

    public void createShipper(Shipper shipper){
        shipperRepository.createShipper(CREATE_SHIPPER_QUERY, shipper);
    }

    public void updateShipper(int shipper_id, Shipper shipper){
        shipperRepository.updateShipper(UPDATE_SHIPPER_QUERY, shipper, shipper_id);
    }

    public void deleteShipper(int shipper_id){
        shipperRepository.deleteShipper(DELETE_SHIPPER_QUERY, shipper_id);
    }

}
