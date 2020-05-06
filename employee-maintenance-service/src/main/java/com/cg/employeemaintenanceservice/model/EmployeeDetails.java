/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 17:32:19
 * @modify date 2020-05-05 17:32:19
 * @desc Storing User details
 */
package com.cg.employeemaintenanceservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emp_details")
@Getter
@Setter
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class EmployeeDetails {

    @Id
    @Column(name = "emp_details_id")
    @JsonIgnore
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

    @Column(name = "manager_id", length = 6)
    private Integer managerId;
    
    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "designation", length = 25)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "dept_id", foreignKey = @ForeignKey(name = "FK_DEPT_ID"))
    private Department department;

    @OneToOne(mappedBy = "employeeDetails")
    private Address address;

    @OneToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_EMP_ID"))
    @MapsId
    @JsonBackReference
    private User user;

}