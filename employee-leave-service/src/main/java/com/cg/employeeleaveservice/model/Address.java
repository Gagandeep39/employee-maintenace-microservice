/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 18:33:35
 * @modify date 2020-05-06 18:33:35
 * @desc Employees adress details
 */
package com.cg.employeeleaveservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Address - Stores address of the employee")
public class Address {

    @Id
    @Column(name = "address_id")
    @JsonIgnore
    @ApiModelProperty("Address ID")
    private Integer addressId;

    @ApiModelProperty("City")
    @Column(length = 25)
    private String city;

    @ApiModelProperty("State")
    @Column(length = 25)
    private String state;

    @ApiModelProperty("Area")
    @Column(length = 25)
    private String area;

    @ApiModelProperty("Pin code")
    @Column(length = 6)
    private String pincode;

    @MapsId
    @OneToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_Address_EMP_ID"))
    @JsonBackReference
    @ApiModelProperty("Back link to employee details")
    private EmployeeDetails employeeDetails;

}
