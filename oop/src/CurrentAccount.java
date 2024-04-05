public class CurrentAccount extends Account {

  private int debitCardNumber;
  private String accountCode;

  public CurrentAccount(String holderId) {
    super(holderId);
  }

  public int getDebitCardNumber() {
    return debitCardNumber;
  }

  public void setDebitCardNumber(int debitCardNumber) {
    this.debitCardNumber = debitCardNumber;
  }

  public String getAccountCode() {
    return accountCode;
  }

  public void setAccountCode(String accountCode) {
    this.accountCode = accountCode;
  }

  @Override
  public String toString() {
    return "CurrentAccount{"
        + "debitCardNumber="
        + debitCardNumber
        + ", accountCode='"
        + accountCode
        + '\''
        + "} "
        + super.toString();
  }
}
