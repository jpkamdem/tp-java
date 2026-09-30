package combattant;

public class Guerrier extends Combattant {
  private Integer rage = 0;

  public Guerrier(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    super(name, pvMax, pv, attack, defence);
  }

  public Guerrier createGuerrier(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    return new Guerrier(name, pvMax, pv, attack, defence);
  }

  @Override
  public Integer strike(Combattant target) {
    rage += 20;
    Integer damage = attack();
    if (rage == 100) {
      damage = attack() * 2;
      target.damage(attack());
      rage = 0;
    }

    return damage;
  }
}