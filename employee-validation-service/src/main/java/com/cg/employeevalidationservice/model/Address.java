/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 18:33:35
 * @modify date 2020-05-06 18:33:35
 * @desc Employees adress details
 */
package com.cg.employeevalidationservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"employeeDetails"})
public class Address {

    @Id
    @Column(name = "address_id")
    @JsonIgnore
    private Integer addressId;
    @Column(length = 25)
    private String city;
    @Column(length = 25)
    private String state;
    @Column(length = 25)
    private String area;
    @Column(length = 6)
    private String pincode;

    @MapsId
    @OneToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_Address_EMP_ID"))
    @JsonBackReference
    private EmployeeDetails employeeDetails;

}
