package com.school.service;

import com.school.entity.Staff;
import com.school.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    Logger logger = LoggerFactory.getLogger(StaffService.class);

    public Staff addStaff(Staff staff) {
        logger.info("Add staff request received for staff name: {}", staff.getName());
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaff() {
        logger.info("Get all staff request received");
        return staffRepository.findAll();
    }

    public Staff getStaff(Long id) {
        logger.info("Get staff request received for staff id: {}", id);
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isPresent()) {
            return staff.get();
        }
        logger.warn("Staff record not present for id {}", id);
        return null;
    }

    public void deleteStaff(Long id) {
        logger.info("Delete staff request received for staff id: {}", id);
        staffRepository.deleteById(id);
    }

}
