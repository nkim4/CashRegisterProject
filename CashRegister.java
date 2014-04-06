/**
 * This class contains the class CashRegister and the methods that run it
 * Class invariants: 
 */
package proj1;


public class CashRegister {

	private int ones;
	private int fives;
	private int tens;
	private int twenties;
	private String status;
	/**
	 * Constructor of the CashRegister class
	 * Precondition: None
	 * Postcondition: creates a instance of the class CashRegister
	 * @param ones: the number of ones in the register
	 * @param fives: the number of fives in the register
	 * @param tens: the number of tens in the register
	 * @param twenties: the number of twenties in the register
	 */
	public CashRegister(int ones, int fives, int tens, int twenties){
		
		this.ones = ones;
		this.fives = fives;
		this.tens = tens;
		this.twenties = twenties;
		this.status = "Unlocked";
	}
	
	/**
	 * A integer validator, check if values are > or = to 0. Returns true or false
	 * Precondition: None
	 * Postcondition: returns true of false depending on the value of value 
	 * @param value: a integer to be tested
	 * @return true or false depending on the value
	 */
	private boolean validInt(int value){
		
		if (value >= 0){
			
			return true;
		}
		
		else{
			
			return false;
		}
	}
	/**
	 * A simple getter for the value twenties
	 * Precondition: an object of CashRegister
	 * Postcondition: returns the attribute twenties  
	 * @return the int attribute twenties
	 */
	public int getTwenties(){
		
		return twenties;
	}
	/**
	 * A simple getter for the value tens
	 * Precondition: an object of CashRegister
	 * Postcondition: returns the attribute tens  
	 * @return the int value tens
	 */
	public int getTens(){
		
		return tens;
	}
	/**
	 * A simple getter for the value fives
	 * Precondition: an object of CashRegister
	 * Postcondition: returns the attribute fives  
	 * @return the int value fives
	 */
	public int getFives(){
		
		return fives;
	}
	/**
	 * A simple getter for the value ones
	 * Precondition: an object of CashRegister
	 * Postcondition: returns the attribute ones  
	 * @return the int value ones
	 */
	public int getOnes(){
		
		return ones;
	}
	/**
	 * A simple getter for the String status
	 * Precondition: an object of CashRegister
	 * Postcondition: returns the String status  
	 * @return the String value status
	 */
	public String getStatus(){
		
		String retStatus = this.status;
		return retStatus;
	}
	/**
	 * a setter that changes the value of status
	 * Precondition: an object of CashRegister
	 * Postcondition: changed the value of status to Locked
	 */
	public void lock(){
		
		this.status = "Locked";
	}
	/**
	 * a setter that changes the value of status
	 * Precondition: an object of CashRegister
	 * Postcondition: changed the value of status to Unlocked
	 */
	public void unlock(){
		
		this.status = "Unlocked";
	}
	/**
	 * a method that checks of the register if its locked a returns a boolean
	 * Precondition: a object of CashRegister
	 * Postcondition: returns a boolean
	 * @return true of false depending on whether the register is locked or not
	 */
	private boolean lockChecker(){
		
		if (this.status.equals("Unlocked")){
			
			return true;
		}
		else{
			
			return false;
		}
	}
	/**
	 * Adds money to one register 
	 * Precondition: in object of CashRegister
	 * Postcondition: the money added to the register
	 * @param ones: number of 1s to add
	 * @param fives: number of fives to add
	 * @param tens: number of tens to add
	 * @param twenties: number of twenties to add
	 * @return true of false depending on if the money added was succesful
	 */
	public boolean addMoney(int ones, int fives, int tens, int twenties){
		if (this.lockChecker()){
			
			if (validInt(ones) && validInt(fives) && validInt(tens) && validInt(twenties)){
				
				this.ones += ones;
				this.fives += fives;
				this.tens += tens;
				this.twenties += twenties;
				return true;
			}
			else {
			
				System.out.println("Negative number, invalid input!\n");
				return false;
			}
		}
		else{
			System.out.println("This register is Locked!");
			return false;
		}
	}
	/**
	 * Takes money from one register
	 * Precondition: an object of the class CashRegister
	 * Postcondition: the register will have less money depending on the method's parameter
	 * @param ones: how many ones to take
	 * @param fives: how many fives to take
	 * @param tens: how many tens to take
	 * @param twenties: how many twenties to take
	 */
	public void takeMoney(int ones, int fives, int tens, int twenties){
		
		if (this.lockChecker()){
			
			if (validInt(ones) && validInt(fives) && validInt(tens) && validInt(twenties)){
			
				this.ones -= ones;
				this.fives -= fives;
				this.tens -= tens;
				this.twenties -= twenties;
				
				if (this.ones < 0 || this.fives < 0 || this.tens < 0 || this.twenties < 0){
					
					this.addMoney(ones, fives, tens, twenties);
					System.out.println("Not enough money in register\n");
				}
			
			}
			else {
			
				System.out.println("Negative number, invalid input!\n");
				
			}
		}
		else{
			
			System.out.println("This register is Locked\n");
			
		}
	}
	/**
	 * Transfers money from one register to another
	 * Precondition: an object of the class CashRegister
	 * Postcondition: money transfered from one register to the next
	 * @param reg: an object of CashRegister that you want to take the money out of
	 * @param ones: how many ones you want to transfer
	 * @param fives: how many fives you want to transfer
	 * @param tens: how many tens you want to transfer
	 * @param twenties: how many twenties you want to transfer 
	 */
	public void tranMoneyTo(CashRegister reg, int ones, int fives, int tens, int twenties){
		
		if (reg.addMoney(ones, fives, tens, twenties)){
			
			this.takeMoney(ones, fives, tens, twenties);
		}
		
	}
	/**
	 * return the total value of the bills in the register
	 * Precondition: an object of the class CashRegister
	 * Postcondition: returns the total value of the cash in register
	 * @return total which is the total value in the register
	 */
	public int getTotal(){
		
		int total = this.ones + this.fives * 5 + this.tens * 10 + this.twenties * 20;
		return total;
	}
	/**
	 * Closes the register and takes out all the money and locks the specified register
	 * Precondition: an object of the class CashRegister
	 * Postcondition: closes the registers and empty them too
	 */
	public void close(){
		
		this.ones = 0;
		this.fives = 0;
		this.tens = 0;
		this.twenties = 0;
		this.status = "Locked";
	}



















}
