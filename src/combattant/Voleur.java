package combattant;

import java.util.Random;

public class Voleur extends Combattant {
  Integer doubleHitRate = 20;
  Integer evasionRate = 15;

  public Voleur(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    super(name, pvMax, pv, attack, defence);
  }

  public Voleur createVoleur(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    return new Voleur(name, pvMax, pv, attack, defence);
  }

  @Override
  protected Integer strike(Combattant target) {
    Integer damage = attack();
    Boolean doubleHit = new Random().nextInt(100) + 1 < doubleHitRate;
    if (doubleHit) {
      target.damage(damage);
    }

    target.damage(damage);
    return damage;
  }

  @Override
  protected void damage(Integer value) {
    Integer maybeEvasion = new Random().nextInt(100) + 1;
    if (maybeEvasion < evasionRate) {
      System.out.println("L'attaque a été esquivée");
      return;
    }

    super.damage(value);
    return;
  }
}