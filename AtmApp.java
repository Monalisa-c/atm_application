package simple_atm_application;

import java.util.Random;
import java.util.Scanner;

class Atm
{
	Scanner sc=new Scanner(System.in);
	Customer customer; //Aggregation
	static int totalAttempts= 3; 
	
	
	
	public Atm(Customer customer) {
		super();
		this.customer = customer;
	}
//	String userName=customer.userName;
//	String password=customer.password;

	int login()
	{
		int flag=-1;
		System.out.println("Enter username:");
		String username=sc.nextLine();
		System.out.println("Enter password:");
		String password=sc.nextLine();
		
		  if (totalAttempts != 0) {
			  if (customer.userName.equals(username) && customer.password.equals(password)) {
		           System.out.println("You have logged in successfully!!");
			 flag=1;
			  }
		        else {
		            System.out.println("Invalid credentials!");
		            totalAttempts--;
		            }
		  }else {
		        System.out.println("Maximum number of attempts exceeded");
		        System.exit(0);
		  }
	    return flag;
		  }
	
	
	void withdraw(float amount)
	{
		if(customer.accBal<amount)
		{
			System.out.println("Insufficient balance!! deposit first");
			return;
		}
		
		customer.accBal-=amount;
		System.out.println(amount+" withdrawn have done successfully!please collect your cash");
		
		System.out.println("do you check balance?(yes/no)");
		String confirmation=sc.nextLine();
		if(confirmation.equalsIgnoreCase("yes"))
			customer.custDetails();
		else
			return;
		
	}
	
	void deposit(float amount)
	{
		customer.accBal+=amount;
		System.out.println(amount+" deposit have done successfully!");
	}
}
public class AtmApp {
	static int accNoGeneration()
	{
		Random random=new Random();
		return random.nextInt(99999);
	}
	static Scanner sc=new Scanner(System.in);
	static Customer customer;
	static Atm atm;
	
  static void transaction()
	{
		int choice;
		while(true)
		{
			System.out.println("========================================");
			System.out.println("Press 1.for withdraw\n"
					+ "Press 2.for deposit\n"
					+ "Press 3.for Check Balance\n"
					+ "Press 4.for get back to main menu\n");
			System.out.println("========================================");
			choice=sc.nextInt();
			System.out.println("========================================");
			switch(choice)
			{
			
			case 1:
				System.out.println("Enter Amount to withdraw:");
				float _wAmount=sc.nextFloat();
				atm.withdraw(_wAmount);
				System.out.println("========================================");
				break;
			
			case 2:System.out.println("Enter Amount to deposit:");
			float _dAmount=sc.nextFloat();
			atm.deposit(_dAmount);
			System.out.println("========================================");
			break;
			
			case 3:
				customer.custDetails();
				System.out.println("========================================");
				break;
			case 4:
				mainMenu();
			}
	}
	}
	
  static void mainMenu()
  {
	  int choice;
		while(true)
		{
			
			System.out.println("Press 1.for Registration\n"
					+ "Press 2.for Login\n"
					+ "Press 3.for Exit\\n");
			System.out.println("========================================");
			choice=sc.nextInt();
			System.out.println("========================================");
			switch(choice)
			{
			case 1:
				sc.nextLine();
				System.out.println("Enter UserName:");
				String userName=sc.nextLine();
				System.out.println("Enter Password:");
			String password=sc.nextLine();
			System.out.println("Enter Customer Name:");
			String custName=sc.nextLine();
			System.out.println("Enter Account Balance:");
			float accBal=sc.nextLong();
			int accNo=accNoGeneration();
			
			customer=new Customer(userName, password, custName, accNo, accBal);
			atm=new Atm(customer);
			System.out.println("You have successfully registered");
			System.out.println("========================================");
			break;
			
			case 2:int flag=atm.login();
			if(flag==1)
				transaction();
			else
				System.out.println("Try again");
			System.out.println("========================================");
			break;
			
			case 3:System.exit(0);
			}
		}  
	  
  }
	public static void main(String[] args) {
		System.out.println("~~~Welcome to ATM Application~~~");
		mainMenu();
	}

}
