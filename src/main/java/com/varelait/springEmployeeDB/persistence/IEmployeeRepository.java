package com.varelait.springEmployeeDB.persistence;

import com.varelait.springEmployeeDB.service.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByIdentification(String identification);

    @Query("select e from Employee e where e.fullname like %:fullname% limit :limit")
    List<Employee> findByFullname(@Param("fullname") String fullname, @Param("limit") int limit);
    List<Employee> findByFullnameContaining(String fullname);
}
