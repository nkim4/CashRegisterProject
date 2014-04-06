/* 	This class contains the main and other helper methods to shorten the aready long main
	Name: Nicholas Kim
	Date: 2/25/2013
	Class: CMSC 202
*/
package proj1;

import java.util.*;

public class Project1 {
	/**
	 * Prints out the user interface for the user
	 * Precondition: none
	 * Postcondition: a printed UI for the user
	 */
	public static void userInter(){
		
		System.out.println("A - Add money\nR - Remove money\nT - Transfer money\nL - Lock register\nU - Unlock register\nS - Display register state\nC - Close the store and quit");
	}
	/**
	 * Checks the integer. if 1 or 2 returns true, if not, returns false
	 * Precondition: none
	 * Postcondition: returns true of false
	 * @param regNum: the integer that is checked
	 * @return
	 */
	public static boolean validRegInt(int regNum){
		
		if (regNum == 1 || regNum == 2){
			
			return true;
		}
		
		else{
		
			System.out.print("Please enter a valid choice! (1 or 2) ");
			return false;
		}
	}
	/**
	 * Checks if the input is a valid choice of the UI
	 * Precondition: none
	 * Postcondition: return true or false
	 * @param choice: the String that is to be checked
	 * @return true or false depending if choice is a valid input
	 */
	public static boolean validChoice(String choice){
		
		if (choice.equals("A") || choice.equals("R") || choice.equals("T") || choice.equals("L") || choice.equals("U") || choice.equals("S") || choice.equals("C")){
			
			return true;
		}
		
		else{
			
			System.out.print("Please enter a valid choice from above! ");
			return false;
		}
	}
	/**
	 * checks to see if the register is lock and returns a boolean
	 * Precondition: none
	 * Postcondition: returns true of false
	 * @param reg: the object of the class CashRegister
	 * @return true if it is lock, false otherwise
	 */
	public static boolean lockChecker(CashRegister reg){
		
		if (reg.getStatus().equals("Locked")){
			
			return true;
		}
		else{
			
			return false;
		}
	}
	
	static Scanner input = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//Ask the user to input the amount into each register
		
		System.out.print("Please enter the amount of ones you wish to enter in both registers: ");
		int ones = input.nextInt();
		System.out.print("Please enter the amount of fives you wish to enter in both registers: ");
		int fives = input.nextInt();
		System.out.print("Please enter the amount of tens you wish to enter in both registers: ");
		int tens = input.nextInt();
		System.out.print("Please enter the amount of twenties you wish to enter in both registers: ");
		int twenties = input.nextInt();
		
		//Creates 2 objects of the class CashRegister reg1 and reg2
		CashRegister reg1 = new CashRegister(ones, fives, tens, twenties);
		CashRegister reg2 = new CashRegister(ones, fives, tens, twenties);
		// Initializing the string choice to start loop
		String choice = "n/a";
		//Repeats until a valid input. 
		while(!choice.equals("C")){
			userInter();
			
			System.out.print("Please enter a choice from the following above: ");
			choice = input.next();
			
			choice = choice.toUpperCase();
			
			while(!validChoice(choice)){
				
				choice = input.next();
				choice = choice.toUpperCase();
			}
			
			if (choice.equals("A")){
				// This part is repeated often to validate input 
				System.out.println("Which register would you like to add money too? (1 or 2) ");
				
				int regChoice = input.nextInt();
				
				while(!validRegInt(regChoice)){
					
					regChoice = input.nextInt();
				}
				//asks the user how much money to add
				System.out.print("Please enter the amount of ones you wish to add: ");
				int addOnes = input.nextInt();
				System.out.print("Please enter the amount of fives you wish to add: ");
				int addFives = input.nextInt();
				System.out.print("Please enter the amount of tens you wish to add: ");
				int addTens = input.nextInt();
				System.out.print("Please enter the amount of twenties you wish add: ");
				int addTwenties = input.nextInt();
				
				if (regChoice == 1){
					
					reg1.addMoney(addOnes, addFives, addTens, addTwenties);
				}
				
				else{
					reg2.addMoney(addOnes, addFives, addTens, addTwenties);
				}
			}
			
			else if (choice.equals("R")){
				
				System.out.println("Which register would you like to remove money from? (1 or 2) ");
				
				int regChoice = input.nextInt();
				
				while(!validRegInt(regChoice)){
					
					regChoice = input.nextInt();
				}
				
				System.out.print("Please enter the amount of ones you wish to remove: ");
				int rmOnes = input.nextInt();
				System.out.print("Please enter the amount of fives you wish to remove: ");
				int rmFives = input.nextInt();
				System.out.print("Please enter the amount of tens you wish to remove: ");
				int rmTens = input.nextInt();
				System.out.print("Please enter the amount of twenties you wish remove: ");
				int rmTwenties = input.nextInt();
				
				if (regChoice == 1){
					
					reg1.takeMoney(rmOnes, rmFives, rmTens, rmTwenties);
				}
				
				else{
					
					reg2.takeMoney(rmOnes, rmFives, rmTens, rmTwenties);
				}
			}
			
			else if(choice.equals("L")){
				
				System.out.println("Which register would you like to lock? (1 or 2) ");
				
				int regChoice = input.nextInt();
				
				while(!validRegInt(regChoice)){
					
					regChoice = input.nextInt();
				}
				
				if (regChoice == 1){
					
					if (!lockChecker(reg1)){
						
						reg1.lock();
						System.out.println("Register 1 is now locked");
					}
					
					else{
						
						System.out.println("The register is already Locked!");
					}
				}
				
				else{
					
					if (!lockChecker(reg2)){
						
						reg2.lock();
						System.out.println("Register 2 is now locked");
					}
					
					else{
						
						System.out.println("This register is arealdy locked");
					}
				}
		
			}
			
			if (choice.equals("U")){
				
				System.out.println("Which register would you like to lock? (1 or 2) ");
				
				int regChoice = input.nextInt();
				
				while(!validRegInt(regChoice)){
					
					regChoice = input.nextInt();
				}
				
				if (regChoice == 1){
					
					if (lockChecker(reg1)){
						
						reg1.unlock();
						System.out.println("Register 1 is now unlocked");
					}
					
					else{
						
						System.out.println("The register is already unlocked!");
					}
				}
				
				else{
					
					if (lockChecker(reg2)){
						
						reg2.unlock();
						System.out.println("Register 2 is now unlocked");
					}
					
					else{
						
						System.out.println("This register is arealdy unlocked");
					}
				}
		
			} 
			
			if (choice.equals("T")){
				
				System.out.println("Which register would you like to transfer money from? (1 or 2) ");
				
				int regChoice = input.nextInt();
				
				while(!validRegInt(regChoice)){
					
					regChoice = input.nextInt();
				}
				
				System.out.print("Please enter the amount of ones you wish to remove: ");
				int tranOnes = input.nextInt();
				System.out.print("Please enter the amount of fives you wish to remove: ");
				int tranFives = input.nextInt();
				System.out.print("Please enter the amount of tens you wish to remove: ");
				int tranTens = input.nextInt();
				System.out.print("Please enter the amount of twenties you wish remove: ");
				int tranTwenties = input.nextInt();
				
				if (regChoice == 1){
					
					reg1.tranMoneyTo(reg2, tranOnes, tranFives, tranTens, tranTwenties);
				}
				
				else{
					
					reg2.tranMoneyTo(reg1, tranOnes, tranFives, tranTens, tranTwenties);
				}
			}
			
			if (choice.equals("S")){
				
				System.out.println("Which register would you like to see the state of? (1 or 2) ");
				
				int regChoice = input.nextInt();
				
				while(!validRegInt(regChoice)){
					
					regChoice = input.nextInt();
				}
				
				if (regChoice == 1){
				
				System.out.println("Register 1\nRegister status: " + reg1.getStatus() + "\nNumber of bills in the Register:\nOnes: " + reg1.getOnes() + "\nFives: " + reg1.getFives() + "\nTens: " + reg1.getTens() + "\nTwenties: " + reg1.getTwenties() + "\nTotal: " + reg1.getTotal() + " Dollars");
				
				}
				
				else{
					
					System.out.println("Register 2\nRegister status: " + reg2.getStatus() + "\nNumber of bills in the Register:\nOnes: " + reg2.getOnes() + "\nFives: " + reg2.getFives() + "\nTens: " + reg2.getTens() + "\nTwenties: " + reg2.getTwenties() + "\nTotal: " + reg2.getTotal() + " Dollars");
				}
			}
			
			if (choice.equals("C")){
				
				reg1.close();
				reg2.close();
				System.out.println("\nRegister 1\nRegister status: " + reg1.getStatus() + "\nNumber of bills in the Register:\nOnes: " + reg1.getOnes() + "\nFives: " + reg1.getFives() + "\nTens: " + reg1.getTens() + "\nTwenties: " + reg1.getTwenties() + "\nTotal: " + reg1.getTotal() + " Dollars\n");
				System.out.println("Register 2\nRegister status: " + reg2.getStatus() + "\nNumber of bills in the Register:\nOnes: " + reg2.getOnes() + "\nFives: " + reg2.getFives() + "\nTens: " + reg2.getTens() + "\nTwenties: " + reg2.getTwenties() + "\nTotal: " + reg2.getTotal() + " Dollars");
				
			}
		}
		
		
		}
		
		
	
		
		
		
	}


