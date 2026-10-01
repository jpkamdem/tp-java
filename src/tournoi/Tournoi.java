package tournoi;

import java.util.ArrayList;

import combattant.Combattant;

public class Tournoi {
  ArrayList<Combattant> participants = new ArrayList<>();

  public ArrayList<Combattant> getParticipants() {
    return participants;
  }

  public ArrayList<Combattant> classement() {
    ArrayList<Combattant> combattantsClasses = new ArrayList<>();
    for (int i = 0; i < combattantsClasses.size() - 1; i++) {
      for (int j = 0; j < combattantsClasses.size() - 1 - i; j++) {

        if (combattantsClasses.get(j).getVictoire() < combattantsClasses.get(j + 1).getVictoire()) {

          Combattant temp = combattantsClasses.get(j);
          combattantsClasses.set(j, combattantsClasses.get(j + 1));
          combattantsClasses.set(j + 1, temp);
        }
      }
    }

    return combattantsClasses;
  }

  public Boolean inscrire(Combattant participant) {
    if (participants.size() >= 8) {
      return false;
    }

    Boolean dejaInscrit = participants.contains(participant);
    if (dejaInscrit) {
      return false;
    }

    participants.add(participant);
    return true;
  }

  public void desinscrire(Combattant participant) {
    Boolean dejaInscrit = participants.contains(participant);
    if (!dejaInscrit) {
      return;
    }

    participants.remove(participant);
    return;
  }

  public void duel(Combattant premierCombattant, Combattant secondCombattant) {
    Boolean premierCommence = premierCombattant.aUneAttaqueSuperieureA(secondCombattant);
    Integer nbTours = 1;
    if (premierCommence) {
      System.out.println("Tour N°" + nbTours);
      premierCombattant.attaquer(secondCombattant);
      System.out.println(secondCombattant.toString());
      nbTours++;
    } else if (!premierCommence) {
      System.out.println("Tour N°" + nbTours);
      secondCombattant.attaquer(premierCombattant);
      System.out.println(premierCombattant.toString());
      nbTours++;
    } else {
      System.out.println("Tour N°" + nbTours);
      premierCombattant.attaquer(secondCombattant);
      System.out.println(secondCombattant.toString());
      nbTours++;
    }

    Boolean combattantsEnVie = !premierCombattant.estKo() && !secondCombattant.estKo();
    while (combattantsEnVie) {
      System.out.println("Tour N°" + nbTours);
      premierCombattant.attaquer(secondCombattant);
      System.out.println(secondCombattant.toString());
      secondCombattant.attaquer(premierCombattant);
      System.out.println(premierCombattant.toString());
      nbTours++;

      if (nbTours == 50) {
        System.out.println("Tour N°" + nbTours);
        System.out.println(secondCombattant.toString());
        System.out.println(premierCombattant.toString());
        if (premierCombattant.aUnMeilleurEtatDeSante(secondCombattant)) {
          System.out.println("Nombre de tours écoulés, vainqueur = " + premierCombattant.toString());
          premierCombattant.ajoutervictoire();
          desinscrire(secondCombattant);
        } else {
          System.out.println("Nombre de tours écoulés, vainqueur = " + secondCombattant.toString());
          secondCombattant.ajoutervictoire();
          desinscrire(premierCombattant);
        }
      }
    }

    System.out.println(premierCombattant.toString());
    System.out.println(secondCombattant.toString());
    if (premierCombattant.aUnMeilleurEtatDeSante(secondCombattant)) {
      System.out.println(nbTours + "Vainqueur = " + premierCombattant.toString());
      premierCombattant.ajoutervictoire();
      desinscrire(secondCombattant);
    } else {
      System.out.println(nbTours + "Vainqueur = " + secondCombattant.toString());
      secondCombattant.ajoutervictoire();
      desinscrire(premierCombattant);
    }
  }

  public void lancer() {
  }
}