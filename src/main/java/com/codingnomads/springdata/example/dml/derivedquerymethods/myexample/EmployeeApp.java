package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmployeeApp implements CommandLineRunner {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApp.class);

    }
    @Override
    public void run(String... args) throws Exception {
        Department engineering = departmentRepo.save(Department.builder().name("engineering").build());
        Department sales = departmentRepo.save(Department.builder().name("sales").build());
        Department finance = departmentRepo.save(Department.builder().name("finance").build());
        Department hr = departmentRepo.save(Department.builder().name("hr").build());

        Employee john = Employee.builder()
                .identifier("01JS")
                .firstName("john")
                .lastName("stevens")
                .email("johnstevens@gmail.com")
                .role("engineer")
                .department(engineering)
                .build();

        Employee jim = Employee.builder()
                .identifier("02JB")
                .firstName("jim")
                .lastName("burk")
                .email("jimburke@gmail.com")
                .role("engineer")
                .department(engineering)
                .build();

        Employee larry = Employee.builder()
                .identifier("03LL")
                .firstName("larry")
                .lastName("long")
                .email("larrylong@gmail.com")
                .role("sales")
                .department(sales)
                .build();

        Employee toby = Employee.builder()
                .identifier("04TM")
                .firstName("toby")
                .lastName("mcqueen")
                .email("tobymcqueen@gmail.com")
                .role("user")
                .department(finance)
                .build();

        Employee steven = Employee.builder()
                .identifier("05SA")
                .firstName("steven")
                .lastName("amalie")
                .email("stevenamalie@gmail.com")
                .role("hr")
                .department(hr)
                .build();

        employeeRepo.save(john);
        employeeRepo.save(jim);
        employeeRepo.save(larry);
        employeeRepo.save(toby);
        employeeRepo.save(steven);

        System.out.println("\n********* findAllByDepartmentName() *********");
        List<Employee> departments = employeeRepo.findByDepartment_name("engineering");
        departments.forEach(System.out::println);

        System.out.println("\n********* findAllByRole() *********");
        List<Employee> engineer = employeeRepo.findByDepartment_employees_department_employees_firstName("engineer");
        engineer.forEach(System.out::println);

        System.out.println("\n********* findAll *********");
        List<Employee> allEmployees = employeeRepo.findAll();
        allEmployees.forEach(System.out::println);

        //employeeRepo.deleteAll();
    }
}