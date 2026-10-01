package combattant;

abstract public class Combattant {
  private String nom;
  private Integer pvMax;
  private Integer pv;
  private Integer attaque;
  private Integer defense;
  private Integer[] historiqueDegats = new Integer[5];
  private static Integer nbCombattant = 0;
  private Integer nbVictoires = 0;

  public Combattant(String nom, Integer pvMax, Integer pv, Integer attaque, Integer defense) {
    Combattant.nbCombattant++;
    this.nom = nom;
    this.pvMax = pvMax;
    this.pv = pv;
    this.attaque = attaque;
    this.defense = defense;

    if (!valeurAttaqueValide()) {
      throw new IllegalArgumentException("attaque doit être entre 5 et 50, reçu : " + attaque);
    }

    if (!valeurPvValide()) {
      throw new IllegalArgumentException("PvMax Entre 50 et 300, pv toujours entre 0 et pvMax");
    }
  }

  protected Boolean valeurPvValide() {
    Boolean pvMaxValide = this.pvMax >= 50 && pvMax <= 300;
    Boolean pvValide = pv >= 0 && pv <= pvMax;
    return pvValide && pvMaxValide;
  }

  protected Boolean valeurAttaqueValide() {
    Boolean valeurAttaqueValide = attaque >= 5 && attaque <= 50;
    return valeurAttaqueValide;
  }

  protected String getNnom() {
    return nom;
  }

  protected void setNom(String valeur) {
    nom = valeur;
  }

  protected Integer getPv() {
    return pv;
  }

  public Boolean aUnMeilleurEtatDeSante(Combattant autre) {
    return pv > autre.pv;
  }

  protected Integer getPvMax() {
    return pvMax;
  }

  protected void setPvMax(Integer valeur) {
    pvMax = valeur;
  }

  protected Integer getAttaque() {
    return attaque;
  }

  public Boolean aUneAttaqueSuperieureA(Combattant autre) {
    return attaque > autre.getAttaque();
  }

  protected void setAttaque(Integer valeur) {
    attaque = valeur;
  }

  protected Integer getDefense() {
    return defense;
  }

  protected void setDefense(Integer valeur) {
    defense = valeur;
  }

  protected Integer[] getHistoriqueDegats() {
    return historiqueDegats;
  }

  protected void infligerDegats(Integer valeur) {
    if (pv == 0) {
      System.out.println("Combattant déjà hors combat, dégats supplémentaires impossible");
      return;
    }

    Integer degats = valeur - defense;
    if (degats < 1) {
      degats = 1;
    }

    majHistoriqueDegats(degats);

    if (pv <= degats) {
      pv = 0;
      System.out.println("Combattant hors combat");
    }

    pv -= degats;
    return;
  }

  protected void infligerDegatsIgnoreDefense(Integer valeur, Integer pourcentage) {
    Double defenseIgnoree = defense * (pourcentage / 100.0);
    Double defenseReelle = defense - defenseIgnoree;

    Integer degats = (int) (valeur - defenseReelle);

    if (degats < 1) {
      degats = 1;
    }

    majHistoriqueDegats(degats);

    pv -= degats;
    return;
  }

  protected void soin(Double valeur) {
    if (pv == 0) {
      System.out.println("Combattant déjà hors combat, soin impossible");
      return;
    }

    if ((pv + valeur) > pvMax) {
      pv = pvMax;
    }

    pv = (int) (pv + valeur);
    return;

  }

  public Boolean estKo() {
    return pv <= 0;
  }

  @Override
  public String toString() {
    return getClass() + "  " + nom + " [" + pv + "/" + pvMax + "] ATK " + attaque + " DEF " + defense;
  }

  protected void majHistoriqueDegats(Integer damage) {
    for (int i = historiqueDegats.length - 1; i > 0; i--) {
      historiqueDegats[i] = historiqueDegats[i - 1];
    }

    historiqueDegats[0] = damage;
  }

  public void ajoutervictoire() {
    nbVictoires++;
  }

  public Integer getVictoire() {
    return nbVictoires;
  }

  abstract public Integer attaquer(Combattant target);
}