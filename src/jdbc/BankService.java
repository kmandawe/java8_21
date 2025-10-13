package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
//    bank.retrieveOne();
//    bank.retrieveAll();
//    bank.deleteOne();
    bank.deleteAll();
  }

  public void retrieveOne() {
    System.out.println(bank.getAccountDetails("123456", "12345678"));
  }

  public void retrieveAll() {
    for (BankAccount bankAccount: bank.getAllAccounts()) {
      System.out.println(bankAccount);
    }
  }

  public void deleteOne() {
    int nRows = bank.deleteBankAccount("123456", "12345678");
    if (nRows == 1) {
      System.out.println("Delete OK: " + nRows);
    } else {
      System.out.println("Delete error: " + nRows);
    }
  }

  public void deleteAll() {
    bank.deleteAllAccounts();
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

  public List<BankAccount> getAllAccounts() {
    String selectSql =
        "SELECT * FROM demo.bank_table";
    List<BankAccount> bankAccounts = new ArrayList<>();

    try (PreparedStatement ps = connection.prepareStatement(selectSql)) {
      boolean isResultSet = ps.execute();

      if (isResultSet) {
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
          bankAccounts.add(
              new BankAccount(
                  rs.getString(1),
                  rs.getString("account_number"),
                  rs.getString("cust_name"),
                  rs.getString("cust_address"),
                  rs.getDouble("balance")));
        }
      } else {
        System.out.println("Did an update!");
      }
    } catch (SQLException sqle) {
      System.err.println("SQLException in getAllAccounts()");
      sqle.printStackTrace();
    }
    return bankAccounts;
  }

  public int deleteBankAccount(String branchCode, String accountNumber) {
    int nRows = -1;
    String deleteSql =
        "DELETE FROM demo.bank_table WHERE (branch_code = ? AND account_number = ?)";

    try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
      ps.setString(1, branchCode);
      ps.setString(2, accountNumber);

      nRows = ps.executeUpdate();

    } catch (SQLException sqle) {
      System.err.println("SQLException in deleteBankAccount()");
      sqle.printStackTrace();
    }
    return nRows;
  }

  public void deleteAllAccounts() {
    String deleteSql =
        "DELETE FROM demo.bank_table";

    try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
      ps.executeUpdate();
    } catch (SQLException sqle) {
      System.err.println("SQLException in deleteAllAccounts()");
      sqle.printStackTrace();
    }
  }

}
