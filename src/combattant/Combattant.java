package combattant;

public class Combattant {
  protected String name;
  protected Integer pvMax;
  protected Integer pv;
  protected Integer attack;
  protected Integer defence;
  protected Integer[] dmgHistory = new Integer[5];
  protected static Integer count = 0;

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

  public String name() {
    return name;
  }

  public void name(String value) {
    name = value;
  }

  public Integer pv() {
    return pv;
  }

  public Integer pvMax() {
    return pvMax;
  }

  public void pvMax(Integer value) {
    pvMax = value;
  }

  public Integer attack() {
    return attack;
  }

  public void attack(Integer value) {
    attack = value;
  }

  public Integer defence() {
    return defence;
  }

  public void defence(Integer value) {
    defence = value;
  }

  public Integer[] dmgHistory() {
    return dmgHistory;
  }

  public void damage(Integer value) {
    if (pv == 0) {
      System.out.println("Combattant déjà hors combat, dégats supplémentaires impossible");
      return;
    }

    Integer damage = value - defence;
    if (damage < 1) {
      damage = 1;
    }

    for (int i = dmgHistory.length - 1; i > 0; i--) {
      dmgHistory[i] = dmgHistory[i - 1];
    }

    dmgHistory[0] = damage;

    if (pv <= damage) {
      pv = 0;
      System.out.println("Combattant hors combat");
    }

    pv -= damage;

    return;
  }

  public void heal(Integer value) {
    if (pv == 0) {
      System.out.println("Combattant déjà hors combat, soin impossible");
      return;
    }

    if ((pv += value) > pvMax) {
      pv = pvMax;
    }

    pv += value;

    return;
  }

  public void isKo() {
    System.out.println(name + " [" + pv + "/" + pvMax + "] ATK " + attack + " DEF " + defence);
  }
}