package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepo employeeRepoImpl;

    public Employee signUp(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    @Cacheable(value = "empId")
    public Optional<Employee> findById(int empId) {


        log.info("@@@@@@@@@@Trying to fetch data from DB");
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> findAll() {
        return employeeRepoImpl.findAll();
    }

    public List<Employee> findByName(String empName) {
        return employeeRepoImpl.findByEmpName(empName);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;

        for (Employee employee : findAll()) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {

                flag = true;
            }
        }
        return flag;
    }


    public Employee update(Employee employee) {
        return employeeRepoImpl.save(employee);
    }


    public void deleteById(int empId) {
        employeeRepoImpl.deleteById(empId);
    }

    public void deleteAll() {
        employeeRepoImpl.deleteAll();
    }
}
