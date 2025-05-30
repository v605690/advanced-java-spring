package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByAddress_city(String city);
    List<Employee> findByAddress_street(String street);
    List<Employee> findByRole(String role);
    List<Employee> findByAddress_state(String state);
    List<Employee> findByAddress_id(long addressId);
    List<Employee> findByDepartment_idAndLastName(long departmentId, String lastName);
    List<Employee> findByDepartment_employees_idAndLastName(long employeeId, String lastName);
    List<Employee> findByDepartment_employees_department_idAndLastName(long departmentId, String lastName);
    List<Employee> findByDepartment_employees_department_employees_idAndLastName(long employeeId, String lastName);
    List<Employee> findByDepartment_id(long departmentId);
    List<Employee> findByDepartment_employees_id(long employeeId);
    List<Employee> findByDepartment_employees_department_id(long departmentId);
    List<Employee> findByDepartment_employees_department_employees_id(long employeeId);
    List<Employee> findByDepartment_employees_department_employees_department_id(long departmentId);
    List<Employee> findByDepartment_employees_department_employees_department_employees_id(long employeeId);
    List<Employee> findByDepartment_employees_department_employees_department_employees_department_id(long departmentId);
    List<Employee> findByDepartment_employees_department_employees_department_employees_department_employees_id(long employeeId);
    List<Employee> findByDepartment_name(String departmentName);
    List<Employee> findByDepartment_employees_firstName(String firstName);
    List<Employee> findByDepartment_employees_lastName(String lastName);
    List<Employee> findByDepartment_employees_department_name(String departmentName);
    List<Employee> findByDepartment_employees_department_employees_firstName(String firstName);
    List<Employee> findByDepartment_employees_department_employees_lastName(String lastName);
    List<Employee> findByDepartment_employees_department_employees_department_name(String departmentName);
    List<Employee> findByDepartment_employees_department_employees_department_employees_firstName(String firstName);
    List<Employee> findByDepartment_employees_department_employees_department_employees_lastName(String lastName);
    List<Employee> findByDepartment_employees_department_employees_department_employees_department_name(String departmentName);
    List<Employee> findByDepartment_employees_department_employees_department_employees_department_employees_firstName(String firstName);
    List<Employee> findByDepartment_employees_department_employees_department_employees_department_employees_lastName(String lastName);
    List<Employee> findByDepartment_employees_department_employees_department_employees_department_employees_department_name(String departmentName);
}
