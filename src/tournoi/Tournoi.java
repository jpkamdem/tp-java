package tournoi;

import java.util.ArrayList;

import combattant.Combattant;

public class Tournoi {
  ArrayList<Combattant> participants = new ArrayList<>();

  public ArrayList<Combattant> participants() {
    return participants;
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
    
  }
}