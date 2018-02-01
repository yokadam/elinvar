package exercise;

public class Producer extends Thread {

    private LoadHandler loadHandler;

    public Producer(LoadHandler loadHandler) {
        this.loadHandler = loadHandler;
    }

    @Override
    public void run() {
    	generateUpdates();
    }

    public void generateUpdates() {
    	// used while loop by purpose to keep continuous generation of updates
        //for (int i = 1; i < 100; i++) { 
    	while(true) {
        	
            loadHandler.receive(new PriceUpdate("Apple", 97.85));
            loadHandler.receive(new PriceUpdate("Google", 160.71));
            loadHandler.receive(new PriceUpdate("Facebook", 91.66));
            loadHandler.receive(new PriceUpdate("Google", 160.73));
            loadHandler.receive(new PriceUpdate("Facebook", 91.71));
            loadHandler.receive(new PriceUpdate("Google", 160.76));
            loadHandler.receive(new PriceUpdate("Apple", 97.85));
            loadHandler.receive(new PriceUpdate("Google", 160.71));
            loadHandler.receive(new PriceUpdate("Facebook", 91.63));
        }  
    }
}
