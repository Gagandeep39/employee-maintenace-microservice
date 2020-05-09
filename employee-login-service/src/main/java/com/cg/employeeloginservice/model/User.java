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
//@ToString(exclude = {"employeeDetails"})
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @SequenceGenerator(name = "user_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer empId;

    @Column(name = "username", length = 20, unique = true)
    private String username;

    @Column(name = "password", length = 20)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_role_id"))
    private Role role;

    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.MERGE)
    private EmployeeDetails employeeDetails;

}