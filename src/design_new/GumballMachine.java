package design_new;

public class GumballMachine{
	 State soldOutState;  
	 State noQuarterState;  
	 State hasQuarterState;   
	 State soldState;
	 State winnerState;
	 
	 State state =soldOutState ; 
	 int count = 0;
	 
	    public GumballMachine(int numberGumballs) {  
	    	soldOutState = new SoldOutState(this);   
	    	noQuarterState = new NoQuarterState(this); 
	    	hasQuarterState = new HasQuarterState(this);  
	    	soldState = new SoldState(this);   
	    	winnerState = new WinnerState(this);
	    	this.count = numberGumballs;   
	    	if (numberGumballs > 0) {      
	    		state = noQuarterState;    
	    		}   
	    	}
	 
	    public void insertQuarter() {  
	    	state.insertQuarter();  
	    	}
	 
	    public void ejectQuarter() {  
	    	state.ejectQuarter(); 
	    	}
	 
	    public void turnCrank() {   
	    	state.turnCrank();    
	    	state.dispense();  
	    	}
	    void setState(State state) {  
	    	this.state = state;  
	    	}
	 
	    void releaseBall() {     
	    	System.out.println("A gumball comes rolling out the slot...");      
	    	if (count != 0) {      
	    		count = count - 1;  
	    		}  
	    	}

		public State getHasQuarterState() {
			
			return hasQuarterState;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return count;
		}
		
		public State getNoQuarterState() {
			// TODO Auto-generated method stub
			return noQuarterState;
		}
		public State getSoldOutState() {
			// TODO Auto-generated method stub
			return soldOutState;
		}
		
		public State getSoldState() {
			// TODO Auto-generated method stub
			return soldState;
		}

		public State getWinnerState() {
			// TODO Auto-generated method stub
			return winnerState;
		}
		public void refill(int numGumBalls) {
			this.count = numGumBalls;
			state = noQuarterState;
		}
		public String toString() {
			StringBuffer result = new StringBuffer();
			result.append("\nMighty Gumball, Inc.");
			result.append("\nJava-enabled Standing Gumball Model #2004\n");
			result.append("Inventory: " + count + " gumball");
			if (count != 1) {
				result.append("s");
			}
			result.append("\nMachine is ");
			if (state == soldOutState) {
				result.append("sold out");
			} else if (state == noQuarterState) {
				result.append("waiting for quarter");
			} else if (state == hasQuarterState) {
				result.append("waiting for turn of crank");
			} else if (state == soldState) {
				result.append("delivering a gumball");
			}
			result.append("\n");
			return result.toString();
		}
		

		 
}
