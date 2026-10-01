package combattant;

public class Mage extends Combattant {
  private Integer mana = 100;
  public static Integer nbVictoiresMages = 0;

  public Mage(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    super(nom, pvMax, pv, attaque, defense);
  }

  public Mage nouveauMage(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    return new Mage(nom, pvMax, pv, attaque, defense);
  }

  @Override
  public Integer attaquer(Combattant cible) {
    if (mana >= 30) {
      return 0;
    }

    Integer damage = getAttaque();
    cible.infligerDegats(damage);
    mana += 15;

    return damage;
  }

  public Integer buffedStrike(Combattant cible) {
    if (mana < 30) {
      return 0;
    }

    Integer damage = getAttaque() * 2;
    cible.infligerDegatsIgnoreDefense(damage, 100);
    mana -= 30;

    return damage;
  }
}