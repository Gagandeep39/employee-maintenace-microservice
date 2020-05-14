/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 17:32:19
 * @modify date 2020-05-05 17:32:19
 * @desc Storing User details
 */
package com.cg.employeemanagementservice.entity;

import com.cg.employeemanagementservice.enums.Gender;
import com.cg.employeemanagementservice.enums.Grade;
import com.cg.employeemanagementservice.enums.MaritalStatus;
import com.fasterxml.jackson.annotation.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "emp_details")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"user", "address", "manager", "subEmployees"})
@ApiModel("Employee details : Stores the employee details after registering by admin")
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class EmployeeDetails {

    @Id
    @Column(name = "emp_details_id")
    @ApiModelProperty("Employee ID")
    private Integer empDetailsId;

    @Column(name = "first_name", length = 20)
    @ApiModelProperty("First name")
    private String firstName;

    @Column(name = "last_name", length = 20)
    @ApiModelProperty("Last name")
    private String lastName;

    @Column(name = "date_of_birth")
    @ApiModelProperty("Date of birth")
    private LocalDate dateOfBirth;

    @Column(name = "date_of_joining")
    @ApiModelProperty("Date of joining")
    private LocalDate dateOfJoining;

    @Column(name = "email", length = 50)
    @ApiModelProperty("Email id")
    private String email;

    @Column(name = "phoneno", length = 10)
    @ApiModelProperty("Phone number")
    private String phoneNumber;

    @Column(name = "marital_status", length = 10)
    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Marital status")
    private MaritalStatus maritalStatus;
    
    @Column(name = "gender", length = 1)
    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Gender")
    private Gender gender;

    @Column(name = "emp_grade", length = 2)
    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Grade")
    private Grade grade;

    @Column(name = "emp_basic")
    @ApiModelProperty("Basic salary")
    private Double basic;

    @Column(name = "designation", length = 25)
    @ApiModelProperty("Designation")
    private String designation;

    @ManyToOne
    @JoinColumn(name = "dept_id", foreignKey = @ForeignKey(name = "FK_DEPT_ID"))
    @ApiModelProperty("Department object")
    private Department department;

    @OneToOne(mappedBy = "employeeDetails", cascade = CascadeType.ALL)
    @ApiModelProperty("Address object")
    private Address address;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    @JsonBackReference
    @MapsId
    @ApiModelProperty("User object")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "FK_MANAGER_EMP_ID"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empDetailsId")
    @JsonIdentityReference(alwaysAsId = true)
    @ApiModelProperty("Manager object")
    private EmployeeDetails manager;

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    @ApiModelProperty("List of sub employees")
    private List<EmployeeDetails> subEmployees = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "employeeDetails")
    @ApiModelProperty("Set of leave histories")
    private Set<LeaveHistory> leaveHistories = new HashSet<>();

    public void addLeave(LeaveHistory leaveHistory){
        leaveHistories.add(leaveHistory);
    }

    public void removeLeave(Integer leaveId){
        leaveHistories.removeIf(leaveHistory -> leaveHistory.getLeaveId().equals(leaveId));
    }

}
