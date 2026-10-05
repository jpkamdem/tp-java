package combattant;

public class Paladin extends Guerrier {
  public static Integer nbVictoiresClasse = 0;

  public Paladin(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    super(nom, pvMax, pv, attaque, defense);
  }

  public Paladin nouveauPaladin(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    return new Paladin(nom, pvMax, pv, attaque, defense);
  }

  @Override
  protected void infligerDegats(Integer valeur) {
    Double valeurSoin = valeur * 0.1;
    System.out.println("Le Paladin " + getNom() + " se soigne !");
    soin(valeurSoin);
    super.infligerDegats(valeur);
    return;
  }
}