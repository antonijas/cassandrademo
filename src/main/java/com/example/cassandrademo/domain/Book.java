package com.example.cassandrademo.domain;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("book_type")
public class Book {

  @CassandraType(type = Name.TEXT)
  private String name;

  public Book(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
