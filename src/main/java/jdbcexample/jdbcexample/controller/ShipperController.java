package jdbcexample.jdbcexample.controller;

import jdbcexample.jdbcexample.model.Order;
import jdbcexample.jdbcexample.model.Shipper;
import jdbcexample.jdbcexample.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/shipper")
public class ShipperController {

    @Autowired
    ShipperService shipperService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> listShipper(){

        List<Shipper> shippers = shipperService.listShippers();
        return  new ResponseEntity<>(shippers, HttpStatus.OK);
    }

    @RequestMapping(path = "/get_one/{shipper_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getShipperById(
            @PathVariable int shipper_id
    ){
        Shipper shipper = shipperService.getShipperById(shipper_id);
        return new ResponseEntity<>(shipper, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createShipper(
            @RequestBody Shipper shipper
    ){
        shipperService.createShipper(shipper);
        return new ResponseEntity<>("{\"Message\": \"Created.\"}", HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/{shipper_id}")
    public ResponseEntity<?> updateShipperById(
            @RequestBody Shipper updatedShipper,
            @PathVariable Integer shipper_id
    ){
        shipperService.updateShipper(shipper_id, updatedShipper);
        return new ResponseEntity<>("{\"Message\": \"Updated.\"}", HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{shipper_id}")
    public ResponseEntity<?> deleteShipperById(
            @PathVariable int shipper_id
    ){
        shipperService.deleteShipper(shipper_id);
        return new ResponseEntity<>("{\"Message\": \"Deleted.\"}", HttpStatus.OK);

    }

}

