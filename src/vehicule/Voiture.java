package vehicule;

public class Voiture extends Vehicule {
  public Voiture(String marque) {
    super(marque);
  }

  @Override
  public void demarrer() {
    System.out.println("Vroum ! " + marque);
  }

  public void klaxonner() {
    System.out.println("Beeeeep !");
  }
}