package simple_atm_application;

import java.util.Random;

public class Customer {
	String userName;
	String password;
	String custName;
	int accno;
	float accBal;
	
	public Customer(String userName, String password, String custName, int accno, float accBal) {
		super();
		this.userName = userName;
		this.password = password;
		this.custName = custName;
		this.accno = accno;
		this.accBal = accBal;
	}
//	 void Registration(String userName,String password,String custName,float accBal)
//	{
//		this.userName = userName;
//		this.password = password;
//		this.custName = custName;
//		this.accBal=accBal;
//		this.accno=accNoGeneration();
//		System.out.println("Registration successfull!!"
//				+ "\nYour account Number is: "+accno);
//	}
	 
	
	 void custDetails()
	 {
		System.out.println("Account Number:"+this.accno+"\n Account Balance:"+
	 this.accBal+" \nusername:"+this.userName+" \nCustomer Name:"+this.custName); 
	 }



 
}
