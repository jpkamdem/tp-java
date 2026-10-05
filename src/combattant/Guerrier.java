package combattant;

public class Guerrier extends Combattant {
  private Integer rage = 0;
  public static Integer nbVictoiresClasse = 0;

  public Guerrier(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    super(nom, pvMax, pv, attaque, defense);
  }

  public Guerrier nouveauGuerrier(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    return new Guerrier(nom, pvMax, pv, attaque, defense);
  }

  @Override
  public Integer attaquer(Combattant cible) {
    rage += 20;
    Integer degats = getAttaque();
    if (rage >= 100) {
      System.out.println("La rage du Guerrier " + getNom() + " s'active !");
      degats *= 2;
      rage = 0;
    }

    cible.infligerDegats(degats);
    return degats;
  }
}