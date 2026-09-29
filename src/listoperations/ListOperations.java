package listoperations;

import java.util.Arrays;
import java.util.Scanner;

public class ListOperations {

  static Scanner sc = new Scanner(System.in);
  public static int[][] notes = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

  public static void matrice() {
    for (int i = 0; i < notes.length; i++) {
      for (int j = 0; j < notes.length; j++) {
        System.out.println("Tableau N°" + (i + 1));
        System.out.println(notes[i][j]);
      }
    }
  }

  public static void diagonalSum() {
    int[][] matrice = new int[3][3];
    for (int i = 0; i < matrice.length; i++) {
      for (int j = 0; j < matrice[i].length; j++) {
        System.out.println("Tableau N°" + (i + 1) + ", donne 3 valeurs :");
        int input = sc.nextInt();
        matrice[i][j] = input;
      }
    }

    System.out.println(matrice[0][0] + " + " + matrice[1][1] + " + " + matrice[2][2]);
    int sum = matrice[0][0] + matrice[1][1] + matrice[2][2];
    System.out.println("Valeur de la somme : " + sum);
  }

  public static int[] createArray() {
    int limit = 10;
    int[] list = new int[limit];
    for (int i = 0; i < limit; i++) {
      System.out.println("Valeur N°" + (i + 1) + " :");
      int input = sc.nextInt();
      list[i] = input;
    }

    return list;
  }

  public static int[] sortArray(int[] array) {
    int[] copyArray = array;
    Arrays.sort(copyArray);
    return copyArray;
  }

  public static void printArray(int[] array) {
    System.out.println("Array : " + Arrays.toString(array));
  }
}