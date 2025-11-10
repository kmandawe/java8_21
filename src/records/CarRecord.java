package records;

public record CarRecord(String regNumber, String owner) implements I {
  //  private final int age; // instance field not allowed in records
  public static final String currentYear = "25";

  public CarRecord() {
    this("     ", ""); // calling the canonical constructor
  }

  // custom compact constructor
  public CarRecord {
    if (regNumber.length() <= 4) {
      throw new IllegalArgumentException("regNumber must be longer than 4 characters");
    }
  }

  public boolean isNewCar() {
    return this.regNumber.startsWith(currentYear);
  }

  public static CarRecord createBlankCarRecord() {
    return new CarRecord("     ", "");
  }

  @Override
  public String owner() {
    return owner.toUpperCase();
  }
}

//class X extends CarRecord {} // not allowed, records are implicitly final

interface I {}