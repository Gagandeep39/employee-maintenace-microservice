/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-05 18:18:30
 * @modify date 2020-05-05 18:18:30
 * @desc Grade Details
 */
package com.cg.employeeleaveservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "grade_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Grade {

    @Id
    @SequenceGenerator(name = "grade_code_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "grade_code_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "grade_code", length = 2)
    private String gradeCode;

    @Column(name = "grade_min_sal", length = 6)
    private Double minSalary;

    @Column(name = "grade_max_sal", length = 6)
    private Double maxSalary;

    @Column(name = "grade_desc", length = 100)
    private String description;

}
