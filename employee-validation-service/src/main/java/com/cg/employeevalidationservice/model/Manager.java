/* 
@author Pranav Karmarkar
*/
package com.cg.employeevalidationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "manager")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Manager {

	@Id
    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
