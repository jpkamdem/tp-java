package combattant;

public class Paladin extends Guerrier {
  public Paladin(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    super(nom, pvMax, pv, attaque, defense);
  }

  public Paladin nouveauPaladin(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    return new Paladin(nom, pvMax, pv, attaque, defense);
  }

  @Override
  protected void infligerDegats(Integer valeur) {
    Double valeurSoing = valeur * 0.1;
    soin(valeurSoing);
    super.infligerDegats(valeur);
    return;
  }
}