import vehicule.Moto;
import vehicule.Voiture;

public class App {

  public static void main(String[] args) {
    Voiture lambo = new Voiture("Lamborghini");
    lambo.demarrer();
    lambo.klaxonner();
    lambo.marque("Peugeot");
    lambo.afficher();

    Moto yamaha = new Moto("Yamaha", true);
    yamaha.demarrer();
    System.out.println(yamaha.sideCar());
    yamaha.marque("suzuki");
    yamaha.afficher();
  }
}