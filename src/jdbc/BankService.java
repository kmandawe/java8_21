package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankService {

  private static Connection connection;
  private static BankService bank = new BankService();

  public BankService() {
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
      System.out.println("DB connection OK!");
    } catch (SQLException ex) {
      System.err.println("DB connection failed!");
      ex.printStackTrace();
    }
  }

  public static void main(String[] args){

  }
}
