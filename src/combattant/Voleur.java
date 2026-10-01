package combattant;

import java.util.Random;

public class Voleur extends Combattant {
  Integer tauxDoubleCoup = 20;
  Integer tauxEsquive = 15;

  public Voleur(String nom, Integer pvMax, Integer pv, Integer attaque, Integer deefnse) {
    super(nom, pvMax, pv, attaque, deefnse);
  }

  public Voleur nouveauVoleur(String nom, Integer pvMax, Integer pv, Integer attaque, Integer deefnse) {
    return new Voleur(nom, pvMax, pv, attaque, deefnse);
  }

  @Override
  protected Integer attaquer(Combattant cible) {
    Integer damage = attaque();
    Boolean doubleHit = new Random().nextInt(100) + 1 < tauxDoubleCoup;
    if (doubleHit) {
      cible.infligerDegats(damage);
    }

    cible.infligerDegats(damage);
    return damage;
  }

  @Override
  protected void infligerDegats(Integer valeur) {
    Integer evasionReussie = new Random().nextInt(100) + 1;
    if (evasionReussie < tauxEsquive) {
      System.out.println("L'attaque a été esquivée");
      return;
    }

    super.infligerDegats(valeur);
    return;
  }
}