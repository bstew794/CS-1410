package braedenStewartAssn1;

import java.util.Scanner; // allows me to use Scanner modules

/**This class calculates the tenth digit of an ISBN using a checksum equation. The user types in the first 9 digits
 * which are then used to determine the tenth number. The program also gives the completed ISBN number as an output.
 * @author  Braeden Stewart <bstewart794@gmail.com>
 * @version 2.0
 * @since 1.5 */

public class Part2 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // declares the variable UserInput using a Scanner method

        /**The next few lines prompt the user to enter the first nine digits to calculate the tenth digit.*/

        System.out.print("Enter the first nine digits of an ISBN: ");
        int isbnNine = userInput.nextInt();

        int comparatorTen = 10;
        int mostRightList = 9;
        int mod1 = 10;
        int mod2 = 11;
        int ISBN[] = new int[mostRightList + 1]; // declares an array and its range
        int isbnOperand = 0; // declares and initializes the isbnOperand variable
        int repeat; // declares repeat variable for use in for loops.

        for (repeat = 9; repeat > 0; repeat--) {
            ISBN[repeat - 1] = isbnNine % mod1;
            isbnNine = isbnNine / mod1;
        }
        for (repeat = 1; repeat < 10; repeat++) { // calculates the operand (first part of the check sum)
            isbnOperand += repeat * ISBN[repeat - 1];
        }
        int tenthNumber = isbnOperand % mod2; // finishes checksum calculation for tenth digit

        System.out.print("The ISBN-10 number is: "); // begins output

        /**The next few lines determines if tenthNumber == 0 and prints an X instead of a 10.
         * Otherwise, it just assigns tenthNumber to ISBN[].*/

        if (tenthNumber == comparatorTen) {
            for (repeat = 0; repeat < 9; repeat++) {
                System.out.print(ISBN[repeat]);
            }
            System.out.print("X"); // displays completed ISBN number
        } else {
            ISBN[mostRightList] = tenthNumber; // assigns tenthNumber to 10th spot in ISBN[]

            for (repeat = 0; repeat < 10; repeat++) {
                System.out.print(ISBN[repeat]); // displays completed ISBN number.
            }
        }
    }
/**This is the end of the class.*/}
