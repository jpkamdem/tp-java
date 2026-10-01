package combattant;

public class Paladin extends Guerrier {
  public Paladin(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    super(nom, pvMax, pv, attaque, defense);
  }

  @Override
  protected void infligerDegats(Integer valeur) {
    Double valeurSoing = valeur * 0.1;
    soin(valeurSoing);
    super.infligerDegats(valeur);
    return;
  }
}