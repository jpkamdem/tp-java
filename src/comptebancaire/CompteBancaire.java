package comptebancaire;

public class CompteBancaire {

  private double solde;

  public double getSolde() {
    return solde;
  }

  public void deposer(double montant) {
    if (montant == 0) {
      System.out.println("Montant invalide");
      return;
    }

    solde += montant;
  }
}