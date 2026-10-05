package tournoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import combattant.Combattant;
import combattant.Guerrier;
import combattant.Mage;
import combattant.Paladin;
import combattant.Voleur;

public class Tournoi {
  ArrayList<Combattant> participants = new ArrayList<>();
  ArrayList<Combattant> tousLesInscrits = new ArrayList<>();

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

    tousLesInscrits.add(participant);
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

  public Tournoi creerTournoi() {
    Tournoi t = new Tournoi();
    t.inscrire(new Guerrier("Conan", 150, 150, 25, 10));
    t.inscrire(new Guerrier("Brienne", 150, 150, 25, 10));
    t.inscrire(new Mage("Gandalf", 150, 150, 25, 10));
    t.inscrire(new Mage("Merlin", 150, 150, 25, 10));
    t.inscrire(new Voleur("Garrett", 150, 150, 25, 10));
    t.inscrire(new Voleur("Arsène", 150, 150, 25, 10));
    t.inscrire(new Paladin("Arthur", 150, 150, 25, 10));
    t.inscrire(new Paladin("Lancelot", 150, 150, 25, 10));
    return t;
  }

  public void duel(Combattant premierCombattant, Combattant secondCombattant) {
    final int nbToursMax = 50;

    Combattant premier = premierCombattant.aUneAttaqueSuperieureA(secondCombattant) ? premierCombattant
        : secondCombattant;
    Combattant second = (premier == premierCombattant) ? secondCombattant : premierCombattant;

    int nbTours = 1;
    while (!premierCombattant.estKo() && !secondCombattant.estKo() && nbTours <= nbToursMax) {
      System.out.println("--- Tour N°" + nbTours + " ---");

      premier.attaquer(second);
      if (!second.estKo()) {
        second.attaquer(premier);
      }

      System.out.println(premier.toString());
      System.out.println(second.toString());
      nbTours++;
    }

    if (!premierCombattant.estKo() && !secondCombattant.estKo()) {
      System.out.println("Nombre de tours écoulés (" + nbToursMax + ")");
    }

    Combattant vainqueur = premierCombattant.aUnMeilleurEtatDeSante(secondCombattant) ? premierCombattant
        : secondCombattant;
    Combattant perdant = (vainqueur == premierCombattant) ? secondCombattant : premierCombattant;
    System.out.println("Vainqueur = " + vainqueur);
    terminerDuel(vainqueur, perdant);
  }

  private final Map<Class<? extends Combattant>, Integer> victoiresParClasse = new HashMap<>();

  private void terminerDuel(Combattant vainqueur, Combattant perdant) {
    vainqueur.ajoutervictoire();
    victoiresParClasse.merge(vainqueur.getClass(), 1, Integer::sum);
    desinscrire(perdant);
  }

  public void statsParClasse() {
    System.out.println("Guerrier : " + victoiresParClasse.getOrDefault(Guerrier.class, 0));
    System.out.println("Mage : " + victoiresParClasse.getOrDefault(Mage.class, 0));
    System.out.println("Voleur : " + victoiresParClasse.getOrDefault(Voleur.class, 0));
    System.out.println("Paladin : " + victoiresParClasse.getOrDefault(Paladin.class, 0));
  }

  public Combattant lancer() {
    Integer round = 1;
    for (Combattant combattant : tousLesInscrits) {
      System.out.println(combattant);
    }

    while (participants.size() > 1) {
      System.out.println("=== Round " + round + " ===");
      ArrayList<Combattant> tirage = new ArrayList<>(participants);
      Collections.shuffle(tirage);
      for (Integer i = 0; i + 1 < tirage.size(); i += 2) {
        Combattant premiCombattant = tirage.get(i);
        Combattant secondCombattant = tirage.get(i + 1);
        System.out.println("--- " + premiCombattant.toString() + " vs " + secondCombattant.toString());
        duel(premiCombattant, secondCombattant);
      }
      round++;
    }

    return participants.get(0);
  }
}