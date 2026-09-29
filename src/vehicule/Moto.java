package vehicule;

public class Moto extends Vehicule {
  private boolean sideCar;

  public Moto(String marque, boolean sideCar) {
    super(marque);
    this.sideCar = sideCar;
  }

  // @Override
  public void demarrer() {
    System.out.println("Brbrbrrrrr ! " + marque);
  }

  public boolean sideCar() {
    return sideCar;
  }

  public void sideCar(boolean value) {
    sideCar = value;
  }
}