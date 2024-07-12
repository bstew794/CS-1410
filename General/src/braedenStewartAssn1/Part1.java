package braedenStewartAssn1;

import java.util.Scanner; //These were imported to allow me to receive user input and do complex equations.
import java.lang.Math;

/**This class calculates the quadratic roots of a formula after the coefficients of a, b, and c have been typed in
 * by the user. The class also tells the user whether there are two, one, or zero real roots for the equation.
 * @author  Braeden Stewart <bstewart794@gmail.com>
 * @version 1.0
 * @since 0.8 */
public class Part1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // creates scanner input so there can be user input

        /**The following lines of code deal with asking the user to type in the coefficients a, b, and c. Additionally,
         * the values are paired with the variables a, b, and c.*/
        System.out.print("Enter a, b, c: ");
        String coefficients = input.nextLine(); // gets the input from the user as a line
        String coList[] = coefficients.split("\\s+"); // splits the coefficients string into 3 entries in coList

        /**The next few lines assign a value to a, b, c by converting entries in coList from string to double.*/

        double a = Double.parseDouble(coList[0]);
        double b = Double.parseDouble(coList[1]);
        double c = Double.parseDouble(coList[2]);

        double discriminant = (b * b) - (4 * (a * c)); // The discriminant is calculated here.

        /**The else if statements determine whether the determinant is less than, greater than or equal to zero.*/
        if (discriminant < 0) {
            System.out.println("There are no roots for these coefficients."); // displays this if it is negative.

        } else if (discriminant == 0) {
            double r1 = (-b) / (2 * a); // This calculates single quadratic root
            System.out.println("There is one root for these coefficients.");
            System.out.println("r1 = " + r1); //  It displays the message and result if it is equal to zero.

        }else if (discriminant > 0) {
            double r1 = ((-b) + Math.sqrt(discriminant)) / (2 * a);
            double r2 = ((-b) - Math.sqrt(discriminant)) / (2 * a); // This calculates both quadratic roots.
            System.out.println("There are two roots for these coefficients.");
            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2); // It displays the message and these results if it is positive.
        }
    }
/**This is the end of the class.*/}
