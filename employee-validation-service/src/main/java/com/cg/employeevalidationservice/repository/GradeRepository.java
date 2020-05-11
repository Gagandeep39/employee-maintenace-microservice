/* 
@author Pranav Karmarkar
*/

package com.cg.employeevalidationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.employeevalidationservice.model.Grade;


@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
