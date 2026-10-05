package combattant;

import java.util.Random;

public class Voleur extends Combattant {
  private Integer tauxDoubleCoup = 20;
  private Integer tauxEsquive = 15;
  public static Integer nbVictoiresClasse = 0;

  public Voleur(String nom, Integer pvMax, Integer pv, Integer attaque, Integer deefnse) {
    super(nom, pvMax, pv, attaque, deefnse);
  }

  public Voleur nouveauVoleur(String nom, Integer pvMax, Integer pv, Integer attaque, Integer deefnse) {
    return new Voleur(nom, pvMax, pv, attaque, deefnse);
  }

  @Override
  public Integer attaquer(Combattant cible) {
    Integer degats = getAttaque();
    Boolean doubleCoup = new Random().nextInt(100) + 1 < tauxDoubleCoup;
    if (doubleCoup) {
      System.out.println("Double frappe du Voleur " + getNom() + " !");
      cible.infligerDegats(degats);
    }

    cible.infligerDegats(degats);
    return degats;
  }

  @Override
  protected void infligerDegats(Integer valeur) {
    Integer evasionReussie = new Random().nextInt(100) + 1;
    if (evasionReussie < tauxEsquive) {
      System.out.println("dedededeeeeeeeee".repeat(22));
      System.out.println("L'attaque a été esquivée par le Voleur " + getNom() + " !");
      return;
    }

    super.infligerDegats(valeur);
    return;
  }
}