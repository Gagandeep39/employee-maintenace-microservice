/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 17:32:19
 * @modify date 2020-05-05 17:32:19
 * @desc Storing User details
 */
package com.cg.employeeleaveservice.model;

import com.cg.employeeleaveservice.enums.Gender;
import com.cg.employeeleaveservice.enums.Grade;
import com.cg.employeeleaveservice.enums.MaritalStatus;
import com.fasterxml.jackson.annotation.*;
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
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class EmployeeDetails {

    @Id
    @Column(name = "emp_details_id")
    private Integer empDetailsId;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "phoneno", length = 10)
    private String phoneNumber;

    @Column(name = "marital_status", length = 10)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    
    @Column(name = "gender", length = 1)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "emp_grade", length = 2)
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column(name = "emp_basic")
    private Double basic;

    @Column(name = "designation", length = 25)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "dept_id", foreignKey = @ForeignKey(name = "FK_DEPT_ID"))
    private Department department;

    @OneToOne(mappedBy = "employeeDetails", cascade = CascadeType.ALL)
    private Address address;

    @OneToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    @JsonBackReference
    @MapsId
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "FK_MANAGER_EMP_ID"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empDetailsId")
    @JsonIdentityReference(alwaysAsId = true)
    private EmployeeDetails manager;

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private List<EmployeeDetails> subEmployees = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "employeeDetails")
    private Set<LeaveHistory> leaveHistories = new HashSet<>();

    public void addLeave(LeaveHistory leaveHistory){
        leaveHistories.add(leaveHistory);
    }

    public void removeLeave(Integer leaveId){
        leaveHistories.removeIf(leaveHistory -> leaveHistory.getLeaveId().equals(leaveId));
    }

}