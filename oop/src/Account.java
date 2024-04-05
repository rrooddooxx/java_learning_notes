import java.math.BigDecimal;

public abstract class Account {
  private BigDecimal currentBalance;
  private boolean isBlocked;
  private final String holderId;

  public Account(String holderId) {
    this.holderId = holderId;
    this.currentBalance = BigDecimal.ZERO;
    this.isBlocked = false;
  }

  public BigDecimal getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(BigDecimal currentBalance) {
    this.currentBalance = currentBalance;
  }

  public boolean withdraw(BigDecimal amount) {
    if (currentBalance.subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
      return false;
    }
    currentBalance = currentBalance.subtract(amount);
    return true;
  }

  public boolean isBlocked() {
    return isBlocked;
  }

  public void setBlocked(boolean blocked) {
    isBlocked = blocked;
  }

  @Override
  public String toString() {
    return "Account{"
        + "currentBalance="
        + currentBalance
        + ", isBlocked="
        + isBlocked
        + ", holderId='"
        + holderId
        + '\''
        + '}';
  }
}
