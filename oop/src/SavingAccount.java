import java.math.BigDecimal;

public class SavingAccount extends Account {

  private BigDecimal cycleRatio;

  public SavingAccount(String holderId) {
    super(holderId);
  }

  public BigDecimal getCycleRatio() {
    return cycleRatio;
  }

  public void setCycleRatio(BigDecimal cycleRatio) {
    this.cycleRatio = cycleRatio;
  }

  @Override
  public String toString() {
    return "SavingAccount{" + "cycleRatio=" + cycleRatio + "} " + super.toString();
  }
}
