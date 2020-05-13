/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 18:16:52
 * @modify date 2020-05-05 18:16:52
 * @desc Department Details
 */
package com.cg.employeemanagementservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "department_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Department {

    @Id
    @SequenceGenerator(name = "dept_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "dept_id_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "dept_id", length = 6)
    private Integer departmentId;

    @Column(name = "dept_name", length = 25)
    private String departmentName;

}