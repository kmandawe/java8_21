package security;

import java.util.ArrayList;

final class Department {
  private final String name, address;
  private final int numEmployees;
  private final ArrayList<String> employees; // mutable

  private Department(String name, String address, int numEmployees, ArrayList<String> employees) {
    this.name = name;
    this.address = address;
    this.numEmployees = numEmployees;
    this.employees = new ArrayList<>(employees); // defensive copy
//    this.employees = employees; // breaking encapsulation!
  }

  public static Department createNewInstance(
      String name, String address, int numEmployees, ArrayList<String> employees) {
    return new Department(name, address, numEmployees, employees);
  }

  // no 'set' methods, only 'get' methods
  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public int getNumEmployees() {
    return numEmployees;
  }

  public ArrayList<String> getEmployees() {
    return new ArrayList<>(employees); // defensive copy
//    return employees; // breaking encapsulation, returning reference to mutable object
  }

  @Override
  public String toString() {
    return "Department{name='"
        + name
        + "', address='"
        + address
        + "', numEmployees="
        + numEmployees
        + ", employees="
        + employees
        + "}";
  }
}

// final class cannot be extended
// class SportsDepartment extends Department {
//  public SportsDepartment(String name, String address, int numEmployees, ArrayList<String>
// employees) {
//    super(name, address, numEmployees, employees); // cannot call super private constructor
//  }
// }

public class TestImmutable {
  public static void main(String[] args){
    ArrayList<String> employees = new ArrayList<>();
    employees.add("Ann");
    employees.add("Liam");

    Department dept = Department.createNewInstance("Argos", "Athlone", 2, employees);

    System.out.println("Created: " + dept);

    String name = dept.getName();
    String address = dept.getAddress();
    int numEmployees = dept.getNumEmployees();
    employees = dept.getEmployees();

    System.out.println("Retrieved: " + name + ", " + address + ", " + numEmployees + ", " + employees);

    name = "Boots";
    address = "Galway";
    numEmployees = 3;
    employees.add("Tom");

    System.out.println("Any change?: "  + dept);
  }
}
