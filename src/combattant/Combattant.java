package combattant;

abstract public class Combattant {
  private String name;
  private Integer pvMax;
  private Integer pv;
  private Integer attack;
  private Integer defence;
  private Integer[] dmgHistory = new Integer[5];
  private static Integer count = 0;

  public Combattant(String name, Integer pvMax, Integer pv, Integer attack, Integer defence) {
    Combattant.count++;
    this.name = name;
    this.pvMax = pvMax;
    this.pv = pv;
    this.attack = attack;
    this.defence = defence;

    if (!validAttack()) {
      throw new IllegalArgumentException("attaque doit être entre 5 et 50, reçu : " + attack);
    }

    if (!validPvs()) {
      throw new IllegalArgumentException("PvMax Entre 50 et 300, pv toujours entre 0 et pvMax");
    }
  }

  protected Boolean validPvs() {
    Boolean validPvMax = this.pvMax >= 50 && pvMax <= 300;
    Boolean validPv = pv >= 0 && pv <= pvMax;
    return validPv && validPvMax;
  }

  protected Boolean validAttack() {
    Boolean validAttack = attack >= 5 && attack <= 50;
    return validAttack;
  }

  protected String name() {
    return name;
  }

  protected void name(String value) {
    name = value;
  }

  protected Integer pv() {
    return pv;
  }

  protected Integer pvMax() {
    return pvMax;
  }

  protected void pvMax(Integer value) {
    pvMax = value;
  }

  protected Integer attack() {
    return attack;
  }

  protected void attack(Integer value) {
    attack = value;
  }

  protected Integer defence() {
    return defence;
  }

  protected void defence(Integer value) {
    defence = value;
  }

  protected Integer[] dmgHistory() {
    return dmgHistory;
  }

  protected void damage(Integer value) {
    if (pv == 0) {
      System.out.println("Combattant déjà hors combat, dégats supplémentaires impossible");
      return;
    }

    Integer damage = value - defence;
    if (damage < 1) {
      damage = 1;
    }

    updateDmgHistory(damage);

    if (pv <= damage) {
      pv = 0;
      System.out.println("Combattant hors combat");
    }

    pv -= damage;
    return;
  }

  protected void defIgnore(Integer value, Integer percentage) {
    Double ignoredDefence = defence * (percentage / 100.0);
    Double effectiveDefence = defence - ignoredDefence;

    Integer damage = (int) (value - effectiveDefence);

    if (damage < 1) {
      damage = 1;
    }

    updateDmgHistory(damage);

    pv -= damage;
    return;
  }

  protected void heal(Double value) {
    if (pv == 0) {
      System.out.println("Combattant déjà hors combat, soin impossible");
      return;
    }

    if ((pv + value) > pvMax) {
      pv = pvMax;
    }

    pv = (int) (pv + value);
    return;

  }

  protected Boolean isKo() {
    return pv > 1;
  }

  @Override
  public String toString() {
    return getClass() + "  " + name + " [" + pv + "/" + pvMax + "] ATK " + attack + " DEF " + defence;
  }

  protected void updateDmgHistory(Integer damage) {
    for (int i = dmgHistory.length - 1; i > 0; i--) {
      dmgHistory[i] = dmgHistory[i - 1];
    }

    dmgHistory[0] = damage;
  }

  abstract protected Integer strike(Combattant target);
}