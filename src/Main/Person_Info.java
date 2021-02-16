package Main;

class Person_Info {
	
	private String Address;
	private String Social_Number;
	private String Phone_Number;
	private String First_Name;
	private String Last_Name;
	
	Person_Info(String First, String Last, String SN, String Phone, String Address){
		this.Address = Address;
		First_Name = First;
		Last_Name = Last;
		Phone_Number = Phone;
		Social_Number = SN;
	}

	public String toString() {
		return "Current Address: "  + Address + " \nSocial Security Number: " + Social_Number  + "\nCurrent Phone Number: " + Phone_Number;
	}
	
}
