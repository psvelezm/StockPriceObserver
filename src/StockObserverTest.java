import java.util.Map;
import java.util.HashMap;

public class StockObserverTest {

	private static Map<String,Double> priceMap = new HashMap<String,Double>();
	private static PriceData priceD = new PriceData();
	public static void main(String[] args) 
        {		
		PricesDisplay firstPortfolio = new PricesDisplay("00001", priceD);
		PricesDisplay secondPortfolio = new PricesDisplay("00002", priceD);
                generateInitialPrices();
		updatePrices(.02);
		updatePrices(-.05);
		updatePrices(.06);
	}
        
	static void generateInitialPrices()
	{
		priceMap.put("ASD", 42.50);
		priceMap.put("BDM", 52.50);
		priceMap.put("CAC", 22.20);
		priceMap.put("DFAS", 45.00);		
		priceD.setPrices(priceMap);
	}
        
	static void updatePrices(double changePercent)
	{
		for( String key : priceMap.keySet())
		{
			double v = priceMap.get(key) * (1.0 + changePercent);
			priceMap.put(key, v);
		}
		priceD.setPrices(priceMap);
	}
}