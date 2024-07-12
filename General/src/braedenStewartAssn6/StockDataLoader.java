package braedenStewartAssn6;

import java.util.Scanner;

public class StockDataLoader {
    private int numStocks = 250;
    private double[] prices = new double [this.numStocks];
    private String fileName;

    StockDataLoader(String fileName) throws Exception{
        this.setFileName(fileName);
        this.loadData();
        this.setNumStocks(250);
    }
    public int getNumStocks(){
        return this.numStocks;
    }
    public double getPrices(int i){
        return this.prices[i];
    }
    public String getFileName(){
        return this.fileName;
    }
    public void setPrices() throws Exception{
        java.io.File file = new java.io.File(this.getFileName());
        Scanner input = new Scanner(file);
        int i = 0;

        while(input.hasNextDouble()){
            this.prices[i] = input.nextDouble();
            i++;
        }
    }
    public void setNumStocks(int input){
        this.numStocks = input;
    }
    public void setFileName(String input){
        this.fileName = input;
    }
    public void loadData() throws Exception{
        this.setPrices();

    }
    public void printPrices(int num) throws Exception{
        this.loadData();
        System.out.print("price: " + this.prices[num]);

    }
}
