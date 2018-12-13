package design_new;

public class WinnerState implements State{
	GumballMachine gumballMachine;
	public WinnerState(GumballMachine gumballMachine) {  
    	 this.gumballMachine = gumballMachine;
    	}   
	 
	public void dispense() { 
		 System.out.println("YOU’RE A WINNER! You get two gumballs for your quarter"); 
				 gumballMachine.releaseBall();  
				 if (gumballMachine.getCount() == 0) { 
					 gumballMachine.setState(gumballMachine.getSoldOutState()); 
					 } else {     
						 gumballMachine.releaseBall();    
						 if (gumballMachine.getCount() > 0) {   
							 gumballMachine.setState(gumballMachine.getNoQuarterState()); 
							 } else {         
								 System.out.println("Oops, out of gumballs!"); 
								 gumballMachine.setState(gumballMachine.getSoldOutState());   
								 }   
						 }  
				 }
	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		
	}

	

}
