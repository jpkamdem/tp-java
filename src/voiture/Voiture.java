package voiture;

public class Voiture {

  String marque;
  String couleur;
  int vitesse;

  public Voiture(String marque, String couleur) {
    this.marque = marque;
    this.couleur = couleur;
    this.vitesse = 0;
  }

  public void afficher() {
    System.out.println("Le véhicule " + marque + " est de couleur " + couleur + ".");
  }

  public void accelerer(int delta) {
    vitesse += delta;
  }
}