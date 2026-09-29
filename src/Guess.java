import java.util.Random;
import java.util.Scanner;

public class Guess {
    static Scanner sc = new Scanner(System.in);

    public static Integer getRandomNumber(Integer limit) {
        return new Random().nextInt(limit) + 1;
    }

    public static void guessNumberMiniGame(Integer guessNumber) {
        System.out.println("Devine le nombre généré au hasard : ");
        Integer input = sc.nextInt();
        Integer count = 0;

        while (input != guessNumber) {
            count++;
            if (input > guessNumber) {
                System.err.println("Mauvaise réponse N°" + count + ". Plus petit.");
            } else {
                System.err.println("Mauvaise réponse N°" + count + ". Plus grand.");
            }

            input = sc.nextInt();
        }

        if (count == 0) {
            System.out.println("Premier essai, chapeau : c'était bien " + input + ".");
            return;
        }

        System.out.println("Bien joué, c'était bien : " + input + ". Il t'aura fallu " + count + " essai(s).");
        return;
    }

    public static void main(String[] args) throws Exception {
        Integer guessNumber = getRandomNumber(100);

        guessNumberMiniGame(guessNumber);
    }
}
