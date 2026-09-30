package combattant;

public class Paladin extends Guerrier {
  public Paladin(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    super(name, pvMax, pv, attack, defence);
  }

  @Override
  protected void damage(Integer value) {
    Double healValue = value * 0.1;
    heal(healValue);
    super.damage(value);
    return;
  }
}