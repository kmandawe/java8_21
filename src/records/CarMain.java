package records;


public class CarMain {
  public static void main(String[] args){

    // 1. Regular class
//    Car car = new Car("ABC123", "Sean");
//    System.out.println(car);
//    System.out.println(car.getOwner());
//    System.out.println(car.getRegNumber());

    // 2. Using a record
    CarRecord carRecord = new CarRecord("XYZ789", "Alice");
    System.out.println(carRecord);
    System.out.println(carRecord.owner());
    System.out.println(carRecord.regNumber());

    // 3. Define an instance method; cannot define an instance field
    System.out.println(carRecord.isNewCar());

    // 4. Define a static field
    System.out.println(CarRecord.currentYear);

    // 5. Define a static method
    CarRecord blankCar = CarRecord.createBlankCarRecord();
    System.out.println("blank owner: " + blankCar.owner());
    System.out.println("blank regNumber: " + blankCar.regNumber());

    // 6. Custom canonical constructor and compact constructor
//    CarRecord car1 = new CarRecord("LMN456", "Bob");
//    System.out.println(car1);
  }
}
