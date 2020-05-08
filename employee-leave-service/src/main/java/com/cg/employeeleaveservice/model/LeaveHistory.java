package com.cg.employeeleaveservice.model;

import com.cg.employeeleaveservice.enums.LeaveStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 19:54
 */

@Entity
@Table(name = "leave_history")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "employeeDetails")
public class LeaveHistory {

    @Id
    @Column(name = "leave_id")
    @SequenceGenerator(name = "leave_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "leave_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer leaveId;

    @Column(name = "leave_balance")
    private Integer leaveBalance;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "leave_status", columnDefinition = "varchar(20) check (leave_status in ('Applied','Approved','Rejected'))")
    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    @Column(name = "no_of_days_applied")
    private Integer numberOfDays;

    @ManyToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_LEAVE_ID"))
//    @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empDetailsId")
    @JsonIdentityReference(alwaysAsId = true)
    private EmployeeDetails employeeDetails;

}
