package com.taxdrools.taxdrools.Controller;

import com.taxdrools.taxdrools.Model.Employee;
import com.taxdrools.taxdrools.Model.Hike;
import com.taxdrools.taxdrools.Service.HikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HikeController {

    @Autowired
    private HikeService hikeService;

    @RequestMapping(value = "/gethike")
    public Hike getHike(@RequestBody Employee employee){
        Employee emp = new Employee(employee.getDesignation() , employee.getExp() , employee.getCurrentSalary());
        Hike hike = new Hike();
        return hikeService.getHike(emp , hike);
    }


}
