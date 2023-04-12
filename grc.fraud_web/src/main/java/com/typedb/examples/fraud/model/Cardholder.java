package com.typedb.examples.fraud.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;
import java.util.Objects;

public class Cardholder {

  @CsvBindByName(column = "first")
  private String firstName;
  @CsvBindByName(column = "last")
  private String lastName;
  @CsvBindByName(column = "gender")
  private String gender;
  @CsvBindByName(column = "job")
  private String job;
  @CsvBindByName(column = "dob")
  private String birthDate;

  @CsvRecurse
  private Address address;
  @CsvRecurse
  private CardholderCoordinates coords;
  @CsvRecurse
  private CreditCard cc;

  public Cardholder() {}

  public Cardholder(String firstName, String lastName, String gender, String job, String birthDate,
      Address address, CardholderCoordinates coords, CreditCard cc) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.job = job;
    this.birthDate = birthDate;
    this.address = address;
    this.coords = coords;
    this.cc = cc;
  }

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

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public CardholderCoordinates getCoords() {
    return coords;
  }

  public void setCoords(CardholderCoordinates coords) {
    this.coords = coords;
  }

  public CreditCard getCc() {
    return cc;
  }

  public void setCc(CreditCard cc) {
    this.cc = cc;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
        return true;
    }
    if (!(o instanceof Cardholder that)) {
        return false;
    }

    return firstName.equals(that.firstName) && lastName.equals(that.lastName) &&
        gender.equals(that.gender) && job.equals(that.job) && birthDate.equals(that.birthDate) &&
        address.equals(that.address) && coords.equals(that.coords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {

    return
        "cardholder {" +
        "  firstName = '" + firstName + "', " +
        "  lastName = '" + lastName + "', " +
        "  gender = '" + gender + "', " +
        "  job = '" + job + "', " +
        "  birthDate = '" + birthDate + "', " +
        "  address = " + address + ", " +
        "  coords = " + coords +
        "}";
  }
}
