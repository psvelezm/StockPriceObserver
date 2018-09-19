import java.util.*;

public class PriceData implements Subject 
{
    private ArrayList observers;
    private Map<String,Double> priceData;
   
    public PriceData() 
    {
        observers = new ArrayList();
        priceData = new HashMap<>();
    }
   
    @Override
    public void removeObserver(Observer o) 
    {
            int i = observers.indexOf(o);
            if (i >= 0) 
                observers.remove(i);

    }
    
    @Override
    public void registerObserver(Observer obs) 
    {
            observers.add(obs);
    }
    

    
    @Override
    public void notifyObservers() 
    {
        for (int i = 0; i < observers.size(); i++) 
        {
            Observer observer = (Observer)observers.get(i);
            observer.update(priceData);
        }
    }
	
    public void pricesChanged() 
    {
            notifyObservers();
    }
        
    public void setPrices(Map<String,Double> priceData) 
    {
            this.priceData = priceData;
            pricesChanged();
    }
	

}
