
public class GumballMachine {
	final static int SOLD_OUT = 0; 
    final static int NO_QUARTER = 1; 
    final static int HAS_QUARTER = 2; 
    final static int SOLD = 3;
	 
    int state = SOLD_OUT; // mặc định ban đầu là bán hết
    int count = 0;  //biến đếm để đếm số lượng gumballs trong máy
    
    //Kiểm tra số lượng gumballs 
    public GumballMachine(int count) {  
    	this.count = count;   
    	if (count > 0) {   
    		state = NO_QUARTER;  
    		}  
    	}  
    
    //Thêm quarter
    public void insertQuarter() {  
    	if (state == HAS_QUARTER) {  //nếu trong máy đã có quarter  
    		System.out.println("You can’t insert another quarter");//in thông tin bạn không thể thêm quarter 
    		}
    	else if (state == NO_QUARTER) {   //nếu không có quarter
    		state = HAS_QUARTER;       //chuyển qua trạng thái has_quarter
    		System.out.println("You inserted a quarter"); //in bạn thêm 1 quarter
    		} 
    	else if (state == SOLD_OUT) {   //nếu đã bán hết, in không thể thêm vì đã bán hết
    		System.out.println("You can’t insert a quarter, the machine is sold out"); 
    		} else if (state == SOLD) {  //nếu khách hàng cần mua 1 gumballs, cần đợi giao dịch hoàn tất trước khi chèn 1 quarter khác
    			System.out.println("Please wait, we’re already giving you a gumball");   
    			}   
    }
    
    //đẩy 1/4
    public void ejectQuarter() {  
    	if (state == HAS_QUARTER) { //nếu có quarter
    		System.out.println("Quarter returned");   //quay trở lại 
    		state = NO_QUARTER;  //trở về trạng thái no_quarter
    		}
    	else if (state == NO_QUARTER) {  //nếu không thì ko thể trả lại
    		System.out.println("You haven’t inserted a quarter"); 
    		} 
    	else if (state == SOLD) {   //nếu khách vừa quay tay quay thì ko thể trả lại tiền
    		System.out.println("Sorry, you already turned the crank");    
    		} else if (state == SOLD_OUT) {    //máy bán hết, nếu chưa quay quarter thì chưa thể đẩy ra 
    			System.out.println("You can’t eject, you haven’t inserted a quarter yet");
    			}  
    	}
    
    //quay tay quay
    public void turnCrank() {  
    	if (state == SOLD) {     //quay 2 lần không có gumball khác
    		System.out.println("Turning twice doesn’t get you another gumball!"); 
    		} 
    	else if (state == NO_QUARTER) {   //cần quay quarter đầu tiên
    		System.out.println("You turned but there’s no quarter");  
    		} else if (state == SOLD_OUT) {    //gumball bán hết thì ko thể cung cấp gumball
    			System.out.println("You turned, but there are no gumballs");   
    			} else if (state == HAS_QUARTER) {    //gọi thành công, thay đổi phương thức dispense của máy 
    				System.out.println("You turned...");   
    				state = SOLD;     
    				dispense();   
    				}   
    	}
 
    
    //Phân phối gumball
    public void dispense() {  
    	if (state == SOLD) {     //Đây là nơi chúng tôi xử lý tình trạng “ngoài gumballs”:
    		//Nếu đây là điều cuối cùng, chúng tôi đặt trạng thái của máy thành SOLD_OUT; 
    		//nếu không, chúng tôi sẽ trở lại không có một phần tư.
    		System.out.println("A gumball comes rolling out the slot");  
    		count = count - 1;    
    		if (count == 0) {      
    			System.out.println("Oops, out of gumballs!");  
    			state = SOLD_OUT;        
    			} else {   
    				state = NO_QUARTER;    
    				}    
    		} else if (state == NO_QUARTER) {    
    			System.out.println("You need to pay ﬁrst");   
    			} else if (state == SOLD_OUT) {     
    				System.out.println("No gumball dispensed");    
    				} else if (state == HAS_QUARTER) {  
    					System.out.println("No gumball dispensed");    
    					}    
    	}
 
    public void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = NO_QUARTER;
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
		if (state == SOLD_OUT) {
			result.append("sold out");
		} else if (state == NO_QUARTER) {
			result.append("waiting for quarter");
		} else if (state == HAS_QUARTER) {
			result.append("waiting for turn of crank");
		} else if (state == SOLD) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}
}
