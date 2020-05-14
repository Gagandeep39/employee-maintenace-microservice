package com.cg.employeevalidationservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cg.employeevalidationservice.enums.LeaveStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@ApiModel("Leave history : Stores the history of leaves of employee")
public class LeaveHistory {

    @Id
    @Column(name = "leave_id")
    @SequenceGenerator(name = "leave_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "leave_id_sequence", strategy = GenerationType.SEQUENCE)
    @ApiModelProperty("Leave ID")
    private Integer leaveId;

    @Column(name = "leave_balance")
    @ApiModelProperty("Leave balance")
    private Integer leaveBalance;

    @Column(name = "date_from")
    @ApiModelProperty("Leave from date")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    @ApiModelProperty("Leave to date")
    private LocalDate dateTo;

    @Column(name = "leave_status", columnDefinition = "varchar(20) check (leave_status in ('Applied','Approved','Rejected'))")
    @Enumerated(EnumType.STRING)
    @ApiModelProperty("Leave status")
    private LeaveStatus leaveStatus;

    @Column(name = "no_of_days_applied")
    @ApiModelProperty("Number of days for which leave is applied")
    private Integer numberOfDays;

    @ManyToOne
    @JoinColumn(name = "emp_id", foreignKey = @ForeignKey(name = "FK_LEAVE_ID"))
    // @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empDetailsId")
    @JsonIdentityReference(alwaysAsId = true)
    @ApiModelProperty("Link to employee details")
    private EmployeeDetails employeeDetails;

}
