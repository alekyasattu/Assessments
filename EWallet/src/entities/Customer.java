package entities;


public class Customer {

	private String mobileNo;
	private String name;
	private double balance;

	public Customer() {
		this("", "", 0);

	}

	public Customer(String mobileNo, String name, double balance) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.balance = balance;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	public int hashcode() {		
		return mobileNo.hashCode();
	}
	
	public String toString() {
		 String display = mobileNo +" "+name+" "+balance;
		 return display;
	}
	
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj==null || !(obj instanceof Customer)) {
			return false;
		}
		Customer c = (Customer)obj;
		return c.mobileNo.equals(this.mobileNo);
		
	}
}
