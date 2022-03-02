package com.school.service;

import com.school.dto.StaffDto;
import com.school.entity.Staff;
import com.school.repository.StaffRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(StaffService.class);

    public StaffDto addStaff(StaffDto staffDto) {
        logger.info("Add staff request received for staff name: {}", staffDto.getName());
        Staff staff = staffRepository.save(convertToEntity(staffDto));
        return convertToDto(staff);
    }

    public List<StaffDto> getAllStaff() {
        logger.info("Get all staff request received");
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public StaffDto getStaff(Long id) {
        logger.info("Get staff request received for staff id: {}", id);
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isPresent()) {
            return convertToDto(staff.get());
        }
        logger.warn("Staff record not present for id {}", id);
        return null;
    }

    public void deleteStaff(Long id) {
        logger.info("Delete staff request received for staff id: {}", id);
        staffRepository.deleteById(id);
    }

    private StaffDto convertToDto(Staff staff) {
        StaffDto staffDto = modelMapper.map(staff, StaffDto.class);
        return staffDto;
    }

    private Staff convertToEntity(StaffDto staffDto) {
        Staff staff = modelMapper.map(staffDto, Staff.class);
        return staff;
    }

}
