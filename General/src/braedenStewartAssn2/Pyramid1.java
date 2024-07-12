package braedenStewartaAssn2;

import java.util.Scanner;

public class Pyramid1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");

        int numberOfRows = sc.nextInt();
        int numberOfRowsMin = 0;

        int oneSpace = 1;

        int rowCount = 1;
        int firstHalfMin = 1;
        int secondHalfMin = 2;

        int spaceCount = numberOfRows - 1;
        int spaceCountMin = 0;

        String numberOfRowsStr = "" + numberOfRows;

        int integerCount = numberOfRowsStr.length() + oneSpace;

        String integerFormat = "%" + integerCount + "d";


        for (int i = numberOfRows; i > numberOfRowsMin; i--) {

            if (spaceCount > spaceCountMin) {
                String spaceFormat = "%" + (spaceCount * integerCount) + "s";
                System.out.printf(spaceFormat, "");
            }
            for (int j = rowCount; j >= firstHalfMin; j--) {
                System.out.printf(integerFormat, j);
            }
            for (int j = secondHalfMin; j <= rowCount; j++) {
                System.out.printf(integerFormat, j);
            }
            System.out.println();

            rowCount++;
            spaceCount--;
        }
    }
}