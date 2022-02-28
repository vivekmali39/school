package com.school.controller;

import com.school.entity.Staff;
import com.school.service.StaffService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/staff")
    @ApiOperation(value = "Add new staff in school system",
            notes = "Add new staff in school system, this api will create new staff record in school system.",
            response = Staff.class)
    public Staff addStaff(Staff staff) {
        return staffService.addStaff(staff);
    }

    @GetMapping("/staff")
    @ApiOperation(value = "Fetch details of all staff members",
            notes = "Fetch details of all staff members in school system.")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/staff/{id}")
    @ApiOperation(value = "Fetch staff details based on id",
            notes = "Fetch staff details from school system based on id.",
            response = Staff.class)
    public Staff getStaff(@ApiParam(value = "ID value for the staff", required = true)
                          @PathVariable("id") Long id) {
        return staffService.getStaff(id);
    }

    @DeleteMapping("/staff/{id}")
    @ApiOperation(value = "Delete staff from school system",
            notes = "Delete staff from school system based on id.")
    public void deleteStaff(@ApiParam(value = "ID value for the staff you want to delete from school system.", required = true)
                            @PathVariable("id") Long id) {
        staffService.deleteStaff(id);
    }

}
