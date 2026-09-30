package combattant;

public class Mage extends Combattant {
  private Integer mana = 100;

  public Mage(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    super(name, pvMax, pv, attack, defence);
  }

  public Mage createMage(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    return new Mage(name, pvMax, pv, attack, defence);
  }

  @Override
  public Integer strike(Combattant target) {
    if (mana >= 30) {
      return 0;
    }

    Integer damage = attack();
    target.damage(damage);
    mana += 15;

    return damage;
  }

  public Integer buffedStrike(Combattant target) {
    if (mana < 30) {
      return 0;
    }

    Integer damage = attack() * 2;
    target.defIgnore(damage, 100);
    mana -= 30;

    return damage;
  }
}