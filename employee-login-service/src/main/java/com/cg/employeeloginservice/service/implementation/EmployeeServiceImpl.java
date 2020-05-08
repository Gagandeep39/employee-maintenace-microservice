/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 03:07:45
 * @modify date 2020-05-06 03:07:45
 * @desc EmployeeService business logic
 */

package com.cg.employeeloginservice.service.implementation;

import com.cg.employeeloginservice.exception.UserNotFoundException;
import com.cg.employeeloginservice.model.User;
import com.cg.employeeloginservice.repository.EmployeeRepository;
import com.cg.employeeloginservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public User performLogin(User user) {
        Optional<User> loggedInEmployee = employeeRepository.findByUsername(user.getUsername());
        loggedInEmployee.orElseThrow(()->new UserNotFoundException("Invalid Username"));
        if (loggedInEmployee.get().getPassword().equals(user.getPassword()))
            return loggedInEmployee.get();
        else
            throw new UserNotFoundException("Invalid Password");
    }

    @Override
    public User changePassword(User user) {
        Optional<User> databaseUser = employeeRepository.findById(user.getEmpId());
        databaseUser.orElseThrow(()->new UserNotFoundException("User does not exist"));
        User newUser = databaseUser.get();
        newUser.setPassword(user.getPassword());
        return employeeRepository.save(newUser);
    }

    @Override
    public User addUser(User user) {
        employeeRepository.save(user);
        return employeeRepository.findById(user.getEmpId()).get();
    }
}
