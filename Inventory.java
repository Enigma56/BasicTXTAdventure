package game;

public class Inventory {
	 private int numHPots;
	 private int healthPotHeal;
	 
	 private int numDPots;
	 private int damAdd;
	    
	 public Inventory(){
		 
		 numHPots = 3;
	     healthPotHeal = 25;
	     
	     numDPots = 1;
	     damAdd = 10;
		 
	 }   

	    public int getHPotAmount() {
	        return numHPots;
	    }
	    
	    public void subtractHPot(){
	    	--numHPots;
	    }

	    public int getPotHeal() {
	        return healthPotHeal;
	    }

	    public void addHPot() {
	        ++numHPots;
	    }
	    
	    public void addDPot(){
	    	++numDPots;
	    }
	    
	    public int getDPotAmount(){
	    	return numDPots;
	    }
	    
	    public int getDamAdd(){
	    	return damAdd;
	    }
	    
	    public void subractDPotAmount(){
	    	--numDPots;
	    }

}
