/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 03:08:33
 * @modify date 2020-05-06 03:08:33
 * @desc Employee Service operations
 */
package com.cg.employeeloginservice.service;


import com.cg.employeeloginservice.model.User;

public interface EmployeeService {

    User performLogin(User user);
    User changePassword(User user);

}