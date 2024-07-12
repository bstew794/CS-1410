package braedenStewartAssn3;

import java.lang.Math;

/**This class determines if a set of given points fit within the area of a provided rectangle or circle.
 * once it has done this, the class prints the results to the user for each point.
 * @author  Braeden Stewart <bstewart794@gmail.com>
 * @version 0.5
 * @since 0.0 */

public class Inside {
    static void reportPoint(double x, double y) {// prints point info according to cartesian coordinates.
        System.out.print(" Point(" + x + ", " + y + ")");
    }
    static void reportCircle(double x, double y, double r) {// prints circle info according to cartesian coordinates.
        System.out.print(" Circle(" + x + ", " + y + ") " + "Radius; " + r);
    }
    static void reportRectangle(double left, double top, double width, double height) {
        double right = left + width; // calculates right and bottom sides of rectangle and thus its area.
        double bottom = top - height;
        /** the next line prints the rectangle info according to cartesian coordinates*/
        System.out.print(" Rectangle(" + left + ", " + top + ", " + right + ", " + bottom + ")");
    }
    static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        double powOfTwo = 2; // assigns a variable for power of two so the variable is in one spot.
        /** the net line uses the distance formula to calculate point's distance from circle center*/
        double pointDistance = Math.sqrt(Math.pow((ptX - circleX), powOfTwo) + Math.pow((ptY - circleY), powOfTwo));

        /** if the point's distance from the enter of the circle is less than the length of the radius then it must
         * be inside the circle's area, and I use this to determine whether the method returns true or false*/
        if (pointDistance <= circleRadius){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth,
                                          double rHeight) {
        double rRight = rLeft + rWidth; // calculates rectangle right and bottom sides
        double rBottom = rTop - rHeight;
        boolean resultX = false; // initializes boolean variables
        boolean resultY = false;

        if ((ptX >= rLeft) && (ptX <= rRight)){ // determines if ptX is within range of rLeft to rRight
            resultX = true;
        }
        if ((ptY >= rBottom) && (ptY <= rTop)){ // determines if ptY is withing range of rBottom to rTop
            resultY = true;
        }
        if ((resultX == true) && (resultY == true)){ // returns true only if resultX and resultY are both true
            return true;
        }
        else{
            return false;
        }
    }
    static void isDisplay(boolean result) { // this method prints the correct result string for the final statement.
        String resultStr; // initializes string

        if (result == true){
            resultStr = " inside"; // if result variable is true then the string will be "inside".
        }
        else{
            resultStr = " outside"; // if not then the string will be "outside"
        }
        System.out.print(" is" + resultStr); // prints statement for reporting if point is in or out of shape
    }
    public static void main(String[] args) {
        /** These next arrays are initialized with predetermined values to prepare for rest of main method. */
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };

        int rangeFlr = 0; // range floor for the for loops based on array minimum index
        int shapeRangeCeil = circleRadius.length; // range ceiling for the for loops based on maximum index
        int pointRangeCeil = ptX.length;

        System.out.println("--- Report of Points and Circles ---\n"); // prints header

        /** this for loop iterates through the circle arrays and point arrays whilst calling the isPointInsideCircle
         * method to determine if the points are inside the two given circles. The total number of iterations should be
         * 8*/
        for (int i = rangeFlr; i < shapeRangeCeil; i++){
            for (int j = rangeFlr; j < pointRangeCeil; j++){
                boolean result = isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i]);

                /** the next few lines print the results in an orderly manner with a new line being created for each
                 * statement; this is why it is inside the nested loop*/
                reportPoint(ptX[j], ptY[j]);
                isDisplay(result);
                reportCircle(circleX[i], circleY[i], circleRadius[i]);
                System.out.println();
            }
        }
        System.out.print("\n"); // separates the rectangle results from the circle results and prints the header
        System.out.println("--- Report of Points and Rectangles ---\n");

        /** this for loop iterates through the rectangle and point arrays whilst calling the isPointInsideRectangle
         * method to determine if the points are inside the areas of the two given rectangles. The total number of
         * iterations should be 8*/
        for (int i = rangeFlr; i < shapeRangeCeil; i++){
            for (int j = rangeFlr; j < pointRangeCeil; j++){
                boolean result = isPointInsideRectangle(ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i],
                        rectHeight[i]);

                /** the next few lines prints the results as a new line each time the nested loop iterates*/
                reportPoint(ptX[j], ptY[j]);
                isDisplay(result);
                reportRectangle(rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                System.out.println();
            }
        }
    }
}