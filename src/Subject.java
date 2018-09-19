public interface Subject 
{
	public void registerObserver(Observer o);
        public void notifyObservers();
	public void removeObserver(Observer o);
	
}