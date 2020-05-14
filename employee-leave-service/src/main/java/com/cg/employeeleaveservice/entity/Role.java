package com.cg.employeeleaveservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Gagandeep
 * @date 06-05-2020
 * @time 20:11
 */

@Entity
@Table(name = "role_table")
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel("Role : Stores the roles of user")
public class Role {

    @Id
    @Column(name = "role_id")
    @ApiModelProperty("Role ID")
    private Integer roleId;

    @Column(name = "role_name")
    @ApiModelProperty("Role name")
    private String role;

}
