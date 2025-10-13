package jdbc;

public class BankAccount {
  private String branchCode, accountNumber, custName, custAddress;
  private double balance;

  public BankAccount() {}

  public BankAccount(
      String branchCode,
      String accountNumber,
      String custName,
      String custAddress,
      double balance) {
    this.branchCode = branchCode;
    this.accountNumber = accountNumber;
    this.custName = custName;
    this.custAddress = custAddress;
    this.balance = balance;
  }

  public String getBranchCode() {
    return branchCode;
  }

  public void setBranchCode(String branchCode) {
    this.branchCode = branchCode;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public String getCustAddress() {
    return custAddress;
  }

  public void setCustAddress(String custAddress) {
    this.custAddress = custAddress;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "BankAccount{"
        + "branchCode='"
        + branchCode
        + '\''
        + ", accountNumber='"
        + accountNumber
        + '\''
        + ", custName='"
        + custName
        + '\''
        + ", custAddress='"
        + custAddress
        + '\''
        + ", balance="
        + balance
        + '}';
  }
}
