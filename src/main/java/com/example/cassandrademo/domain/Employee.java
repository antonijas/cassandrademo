package com.example.cassandrademo.domain;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Employee {

  public Employee(String id, String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }

  protected Employee() {
  }

  @PrimaryKey
  @Column
  private String id;

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  @Frozen
  @Column
  @CassandraType(type = Name.UDT, userTypeName = "book_type")
  private Book book;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @NotNull
  @Column
  private String firstName;

  @NotNull
  @Column
  private String lastName;
}