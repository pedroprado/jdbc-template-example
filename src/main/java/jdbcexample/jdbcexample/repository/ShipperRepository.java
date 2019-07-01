package jdbcexample.jdbcexample.repository;

import jdbcexample.jdbcexample.model.Order;
import jdbcexample.jdbcexample.model.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShipperRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Shipper> listShippers(String GET_ALL_SHIPPERS_QUERY) {
        return  jdbcTemplate.query(GET_ALL_SHIPPERS_QUERY,
                (res, rowNum)->
                        new Shipper(
                                res.getInt("shipper_id"), res.getString("name")
                        ));
    }

    public Shipper getShipperById(String GET_SHIPPER_BY_ID_QUERY, int shipper_id) {
        return jdbcTemplate.queryForObject(GET_SHIPPER_BY_ID_QUERY,
                new Object[]{shipper_id},
                new BeanPropertyRowMapper<Shipper>(Shipper.class));
    }

    public void createShipper(String CREATE_SHIPPER_QUERY, Shipper shipper){
        jdbcTemplate.update(CREATE_SHIPPER_QUERY, new Object[]{
                shipper.getShipper_id(), shipper.getName()
        });
    }

    public void updateShipper(String UPDATE_SHIPPER_QUERY, Shipper shipper, Integer shipper_id){
        jdbcTemplate.update(UPDATE_SHIPPER_QUERY, new Object[]{
                shipper.getName(), shipper_id
        });
    }

    public void deleteShipper(String DELETE_SHIPPER_QUERY, int shipper_id) {
        jdbcTemplate.update(DELETE_SHIPPER_QUERY, new Object[]{shipper_id});
    }

}
