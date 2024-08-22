package com.yathin.TableBookingApplication.controllers;

import com.yathin.TableBookingApplication.models.Tables;
import com.yathin.TableBookingApplication.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Tablecontroller {
    @Autowired
    TableService table_service;

    @PostMapping("/{res_id}/addtable")
    public Tables addTableToRestaurant(@RequestBody Tables t, @PathVariable int res_id)
    {
        return table_service.addTableToRestaurant(t, res_id);
    }

    @DeleteMapping("/{res_id}/{table_id}/deletetable")
    public void deletetableFromRestaurant(@PathVariable int res_id, @PathVariable int table_id)
    {
        table_service.deleteTableFromrestaurant(res_id,table_id);
    }
}