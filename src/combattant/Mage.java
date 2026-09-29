package combattant;

public class Mage extends Combattant {
  private Integer mana = 100;

  public Mage(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    super(name, pvMax, pv, attack, defence);
  }

  @Override
  public Integer strike(Combattant target) {
    return 0;
  }
}