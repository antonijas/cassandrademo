package com.example.cassandrademo.domain;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface EmployeeRepository extends CassandraRepository<Employee, String> {

}
