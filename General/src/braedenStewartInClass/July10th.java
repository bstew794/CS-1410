package braedenStewartInClass;

public class July10th {
    public static void main(String[] args) {
        double[][] twoD = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int rows = 4;
        int cols = 4;
        double sum = 0.0;

        for (int i=0; i<cols; i++){
            for (int j=0; j<rows; j++){
                sum += twoD[j][i];
            }
            System.out.println("Sum of Column " + i + ": " + sum);
            sum = 0.0;
        }
    }
}
