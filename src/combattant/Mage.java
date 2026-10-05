package combattant;

public class Mage extends Combattant {
  private Integer mana = 100;
  public static Integer nbVictoiresClasse = 0;

  public Mage(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    super(nom, pvMax, pv, attaque, defense);
  }

  public Mage nouveauMage(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    return new Mage(nom, pvMax, pv, attaque, defense);
  }

  @Override
  public Integer attaquer(Combattant cible) {
    if (mana < 30) {
      Integer degats = getAttaque() / 2;
      System.out.println("Manque de mana du Mage " + getNom() + ", dégâts amoindri !");
      cible.infligerDegats(degats);
      mana += 15;
      return degats;
    }

    Integer degats = getAttaque() * 2;
    System.out.println("Dégâts énormes du Mage " + getNom() + " !");
    cible.infligerDegatsIgnoreDefense(degats, 100);
    mana -= 30;
    return degats;
  }
}