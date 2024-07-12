package braedenStewartaAssn2;

import java.util.Scanner;

public class Pyramid2 {public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of lines: ");

    int numberOfRows = sc.nextInt();
    int numberOfRowsMin = 0;

    int oneSpace = 1;
    int twoBase = 2;
    int oneIncrement = 1;

    int rowCount = 1;
    int firstHalfMin = 1;
    int secondHalfMin = 1;

    int spaceCount = numberOfRows - 1;
    int spaceCountMin = 0;

    long greatestValue = (long) Math.pow(twoBase, numberOfRows - oneIncrement);

    String greatestValueStr = "" + greatestValue;

    int integerCount = greatestValueStr.length() + oneSpace;

    String integerFormat = "%" + integerCount + "d";


    for (int i = numberOfRows; i > numberOfRowsMin; i--) {

        if (spaceCount > spaceCountMin) {
            String spaceFormat = "%" + (spaceCount * integerCount) + "s";
            System.out.printf(spaceFormat, "");
        }
        for (int j = firstHalfMin; j <= rowCount; j++) {
            long k = (long) Math.pow(twoBase, j - oneIncrement);

            System.out.printf(integerFormat, k);
        }
        for (int j = rowCount - oneIncrement; j >= secondHalfMin; j--) {
            long k = (long) Math.pow(twoBase, j - oneIncrement);
            System.out.printf(integerFormat, k);
        }
        System.out.println();

        rowCount++;
        spaceCount--;
    }
}
}
