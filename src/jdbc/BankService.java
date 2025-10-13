package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

  public static void main(String[] args) {
    bank.retrieveOne();
  }

  public void retrieveOne() {
    System.out.println(bank.getAccountDetails("123456", "12345678"));
  }

  public BankAccount getAccountDetails(String branchCode, String accountNumber) {
    String selectSql =
        "SELECT * FROM demo.bank_table WHERE (branch_code = ? AND account_number = ?)";
    BankAccount bankAccount = null;

    try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
      ps.setString(1, branchCode);
      ps.setString(2, accountNumber);

      ResultSet rs = ps.executeQuery();

      if (!rs.next()) {
        return bankAccount;
      }

      bankAccount =
          new BankAccount(
              rs.getString("branch_code"),
              rs.getString(2),
              rs.getString("cust_name"),
              rs.getString("cust_address"),
              rs.getDouble("balance"));
    } catch (SQLException sqle) {
      System.err.println("SQLException in getAccountDetails()");
      sqle.printStackTrace();
    }
    return bankAccount;
  }
}
