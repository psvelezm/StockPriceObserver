
import java.util.Map;

public class PricesDisplay implements Observer, DisplayElement 
{
    private Subject priceData;
    private String var;
    private Map<String,Double> priceMap;
    public PricesDisplay(String string, PriceData priceData) 
    {
        this.priceData = priceData;
        this.var = string;
        priceData.registerObserver(this);
    }
    @Override
    public void display() 
    {
            System.out.printf("Portfolio #%s, ASD = %.2f, DFAS = %.2f, CAC = %.2f, BDM = %.2f %n", var, priceMap.get("ASD"), priceMap.get("DFAS"), priceMap.get("CAC"), priceMap.get("BDM"));
    }
    @Override
    public void update(Map priceMap) {
        this.priceMap = priceMap;
        display();
    }
}
