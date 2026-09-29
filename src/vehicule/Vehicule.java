package vehicule;

abstract public class Vehicule {
  protected String marque;

  public Vehicule(String marque) {
    this.marque = marque;
  }

  abstract public void demarrer();

  public String marque() {
    return marque;
  }

  public void marque(String value) {
    marque = value;
  }

  public void afficher() {
    System.out.println("Mon véhicule est de la marque " + marque);
  }
}