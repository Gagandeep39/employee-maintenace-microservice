/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 17:18:24
 * @modify date 2020-05-05 17:18:24
 * @desc Basic user Credential
 */
package com.cg.employeeloginservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user_master")
@Getter
@Setter
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @SequenceGenerator(name = "user_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer empId;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "role", length = 20)
    private String role;

    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;

}