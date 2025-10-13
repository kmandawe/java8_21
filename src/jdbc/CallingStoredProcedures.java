package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallingStoredProcedures {

  private static Connection connection;
  public static void main(String[] args){
    noParams();
  }

  public static void noParams() {
    String noParamsSql = "{ call read_dublin_addresses() }";
    try (CallableStatement cs = connection.prepareCall(noParamsSql);
      ResultSet rs = cs.executeQuery()) {
      while (rs.next()) {
        System.out.println(rs.getString("CUST_ADDRESS"));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public static void inParam() {
    String inParamSql = "{ call read_addresses(?) }";

    try (CallableStatement cs = connection.prepareCall(inParamSql)) {
      cs.setString(1, "Dublin");

      try (ResultSet rs = cs.executeQuery()) {
        while (rs.next()) {
          System.out.println(rs.getString("CUST_ADDRESS"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public static void outParam() {
    String outParamSql = "{ ? = call count_customers(?) }";

    try (CallableStatement cs = connection.prepareCall(outParamSql)) {
      cs.registerOutParameter(1, Types.INTEGER);
      cs.execute();
      System.out.println(cs.getInt("count"));
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public static void inOutParam() {
    String inOutParamSql = "{ ? = call square_number(?) }";

    try (CallableStatement cs = connection.prepareCall(inOutParamSql)) {

      cs.setInt(1, 5);
      cs.registerOutParameter(1, Types.INTEGER);
      cs.execute();
      System.out.println(cs.getInt("number"));
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
