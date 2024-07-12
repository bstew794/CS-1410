package braedenStewartAssn6;

public class TestStockStrategies {
    public static void main(String[] args) throws Exception{
        TestStockStrategies test = new TestStockStrategies();
        test.runStrategies();
        test.printReturns();
    }
    private StockMarketStrategy[] strats = new StockMarketStrategy[8];
    private double[] returns = new double[8];
    MACDStrategy eaMACD = new MACDStrategy ("eaAdjClose.csv");
    MACDStrategy hasMACD = new MACDStrategy("hasAdjClose.csv");
    MACDStrategy nvdaMACD = new MACDStrategy("nvdaAdjClose.csv");
    MACDStrategy tslaMACD = new MACDStrategy("tslaAdjClose.csv");

    MRStrategy eaMR = new MRStrategy("eaAdjClose.csv");
    MRStrategy hasMR = new MRStrategy("hasAdjClose.csv");
    MRStrategy nvdaMR = new MRStrategy("nvdaAdjClose.csv");
    MRStrategy tslaMR = new MRStrategy("tslaAdjClose.csv");

    TestStockStrategies() throws Exception{
        strats[0] = eaMACD;
        strats[1] = hasMACD;
        strats[2] = nvdaMACD;
        strats[3] = tslaMACD;
        strats[4] = eaMR;
        strats[5] = hasMR;
        strats[6] = nvdaMR;
        strats[7] = tslaMR;

        for (int i = 0; i < 8; i++){
            returns[i] = strats[i].getReturns();
        }
    }
    public void runStrategies()throws Exception{
        for (int i = 0; i < 8; i++){
            strats[i].runStrategy();
            strats[i].printProfit();
        }

    }
    public void printReturns(){
        String companyName;
        String strategyName;
        for (int i = 0; i < 4; i++){
            strategyName = ((MACDStrategy)strats[i]).getStrategyName();
            companyName = strats[i].file.getFileName();
            companyName = companyName.replace("AdjClose.csv", "");
            System.out.println(strategyName + " for " + companyName + " returns: " + strats[i].getReturns());
        }
        for (int i = 4; i < 8; i++){
            strategyName = ((MRStrategy)strats[i]).getStrategyName();
            companyName = strats[i].file.getFileName();
            companyName = companyName.replace("AdjClose.csv", "");
            System.out.println(strategyName + " for " + companyName + " returns: " + strats[i].getReturns());
        }


    }

}
