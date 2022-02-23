package com.example.cassandrademo;

import com.example.cassandrademo.domain.Book;
import com.example.cassandrademo.domain.Employee;
import com.example.cassandrademo.domain.EmployeeRepository;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CassandraDemoApplication implements ApplicationRunner {

  EmployeeRepository employeeRepository;

  public static void main(String[] args) {
    SpringApplication.run(CassandraDemoApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Employee employee1 = new Employee("neki uuid", "Antonija", "Samaržija");
    Employee employee2 = new Employee(UUID.randomUUID().toString(), "name", "lastname");
    Employee employee3 = new Employee(UUID.randomUUID().toString(), "name2", "lastname2");
    Book b = new Book("design patterns");
    employee1.setBook(b);

    employeeRepository.saveAll(Set.of(employee1, employee2, employee3));
    List<Employee> allEmployees = employeeRepository.findAll();
    for (Employee e : allEmployees) {
      System.out.println(e.getFirstName());
    }
  }
}
