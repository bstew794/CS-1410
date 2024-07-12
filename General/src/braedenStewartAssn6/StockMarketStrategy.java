package braedenStewartAssn6;

public class StockMarketStrategy {
    private double firstBuy;
    private double buy;
    private double profit;
    private int numDays;
    private double totalProfit;
    private double returns;
    StockDataLoader file;


    StockMarketStrategy(String fileName) throws Exception{
        numDays = 7;
        firstBuy = 0.0;
        buy = 0.0;
        profit = 0.0;
        totalProfit = 0.0;
        file = new StockDataLoader(fileName);
    }
    public double getFirstBuy() {
        return this.firstBuy;
    }
    public double getBuy() {
        return this.buy;
    }
    public double getProfit() {
        return this.profit;
    }
    public int getNumDays(){
        return this.numDays;
    }
    public void setFirstBuy(double input) {
        this.firstBuy = input;
    }
    public void setBuy(double input) {
        this.buy = input;
    }
    public void setNumDays(int input) {
        this.numDays = input;
    }
    public void setProfit(double input) {
        this.profit = input;
    }
    public void setTotalProfit(double input) {
        this.totalProfit = input;
    }
    public double getTotalProfit(){
        return this.totalProfit;
    }
    public Double getReturns(){
        return this.returns;
    }
    public void setReturns(){
        this.returns = this.getTotalProfit() / this.getFirstBuy();
    }
    public void runStrategy() throws Exception{
        System.out.println("this method is meant to be run by child classes.");
    }
    public void printProfit(){
        System.out.println("this method is meant to be run by child classes.");
    }
}

class MACDStrategy extends StockMarketStrategy{
    public String strategyName;


    public MACDStrategy(String filename) throws Exception {
        super(filename);
        this.setStrategyName("MACD");
    }
    public String getStrategyName(){
        return this.strategyName;
    }
    public void setStrategyName(String input){
        this.strategyName = input;
    }
    public void runStrategy() throws Exception {
        int countBuy = 0;
        int count = this.getNumDays() + 1;
        int lastActionDay = 0;
        double totalProfit = 0.0;
        boolean isBuy = false;
        String companyName = this.file.getFileName();
        companyName = companyName.replace("AdjClose.csv", "");

        System.out.println("------MACD Strategy for " + companyName + "------");

        for (int i = this.getNumDays(); i < this.file.getNumStocks(); i++){
            double prc = this.file.getPrices(i);
            String actionString = null;
            String profitString = null;
            boolean doNothing = false;
            double denominator = this.getNumDays();
            double numerator = 0.0;

            for (int j = (i - 1); j >= (i - this.getNumDays()); j--){
                numerator += this.file.getPrices(j);
            }
            double mn_prc = numerator / denominator;

            if (prc > mn_prc && (!isBuy)) {
                isBuy = true;
                actionString = " buy at ";
                this.setBuy(this.file.getPrices(i));
                countBuy += 1;
                lastActionDay = count;
                if (countBuy == 1) {
                    this.setFirstBuy(this.getBuy());
                }
            }
            else if (prc < mn_prc && isBuy){
                isBuy = false;
                actionString = " sell at ";
                this.setProfit(this.file.getPrices(i) - this.getBuy());
                totalProfit += this.getProfit();
                profitString = " profit: " + this.getProfit();
                lastActionDay = count;
            }
            else{
                doNothing = true;
            }
            if (doNothing){
                continue;
            }
            String dayString = "Day " + (i + 1);

            System.out.print(dayString + actionString);
            this.file.printPrices(i);
            if (prc < mn_prc){
                System.out.println(profitString);
            }
            else{
                System.out.println();
            }
            count++;
            this.setNumDays(count - lastActionDay);
        }
        this.setTotalProfit(totalProfit);
    }
    public void printProfit(){
        System.out.println("-----" + this.getStrategyName() + " Profits-----");
        System.out.println("profit: " + this.getTotalProfit());

        this.setReturns();

        System.out.print("returns: " + this.getReturns());
        System.out.print("\n\n\n");
    }
}

class MRStrategy extends StockMarketStrategy{
    public String strategyName;

    public MRStrategy (String filename) throws Exception{
        super(filename);
        this.setStrategyName("Mean Revision");
    }
    public String getStrategyName(){
        return this.strategyName;
    }
    public void setStrategyName(String input){
        this.strategyName = input;
    }
    public void runStrategy() throws Exception {
        int countBuy = 0;
        int count = this.getNumDays() + 1;
        int lastActionDay = 0;
        double totalProfit = 0.0;
        boolean isBuy = false;
        String companyName = this.file.getFileName();
        companyName = companyName.replace("AdjClose.csv", "");

        System.out.println("------MACD Strategy for " + companyName + "------");

        for (int i = this.getNumDays(); i < this.file.getNumStocks(); i++){
            double prc = this.file.getPrices(i);
            String actionString = null;
            String profitString = null;
            boolean doNothing = false;
            double denominator = this.getNumDays();
            double numerator = 0.0;

            for (int j = (i - 1); j >= (i - this.getNumDays()); j--){
                numerator += this.file.getPrices(j);
            }
            double mn_prc = numerator / denominator;

            if (prc < mn_prc * 0.95 && !isBuy) {
                isBuy = true;
                actionString = " buy at ";
                this.setBuy(this.file.getPrices(i));
                countBuy += 1;
                lastActionDay = count;
                if (countBuy == 1) {
                    this.setFirstBuy(this.getBuy());
                }
            }
            else if (prc > mn_prc * 1.05 && isBuy){
                isBuy = false;
                actionString = " sell at ";
                this.setProfit(this.file.getPrices(i) - this.getBuy());
                totalProfit += this.getProfit();
                profitString = " profit: " + this.getProfit();
                lastActionDay = count;
            }
            else{
                doNothing = true;
            }
            if (doNothing){
                continue;
            }
            String dayString = "Day " + (i + 1);

            System.out.print(dayString + actionString);
            this.file.printPrices(i);
            if (prc < mn_prc){
                System.out.println(profitString);
            }
            else{
                System.out.println();
            }
            count++;
            this.setNumDays(count - lastActionDay);
        }
        this.setTotalProfit(totalProfit);

    }
    public void printProfit(){
        System.out.println("-----" + this.getStrategyName() + " Profits-----");
        System.out.println("profit: " + this.getTotalProfit());

        this.setReturns();

        System.out.print("returns: " + this.getReturns());
        System.out.print("\n\n\n");
    }
}