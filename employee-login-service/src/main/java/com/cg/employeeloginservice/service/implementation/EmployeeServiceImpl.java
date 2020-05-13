/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 03:07:45
 * @modify date 2020-05-06 03:07:45
 * @desc EmployeeService business logic
 */

package com.cg.employeeloginservice.service.implementation;

import com.cg.employeeloginservice.exception.UserNotFoundException;
import com.cg.employeeloginservice.model.ChangePassword;
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
    public User changePassword(ChangePassword changePassword) {
        Optional<User> container = employeeRepository.findById(changePassword.getUserId());
        container.orElseThrow(()-> new UserNotFoundException("Wrong Username"));
        User user = container.get();
        if (!user.getPassword().equals(changePassword.getOldPassword()))
            throw new UserNotFoundException("Entered password is wrong");
        user.setPassword(changePassword.getNewPassword());
        return employeeRepository.save(user);
    }

    @Override
    public User addUser(User user) {
        return employeeRepository.save(user);
        // return employeeRepository.findById(user.getEmpId()).get();
    }

    @Override
    public User updateRole(User user) {
        User dummyUser = employeeRepository.getOne(user.getEmpId());
        dummyUser.setRole(user.getRole());
        return employeeRepository.save(dummyUser);
    }

    @Override
    public User findUserById(Integer id) {
        Optional<User> container = employeeRepository.findById(id);
        container.orElseThrow(()->new UserNotFoundException("User not found with guven ID"));
        User user = container.get();
        user.setEmployeeDetails(null);
        return user;
    }
}
