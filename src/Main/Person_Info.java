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
	
	public String getName() {
		return First_Name + " " + Last_Name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * @return the social_Number
	 */
	public String getSocial_Number() {
		return Social_Number;
	}

	/**
	 * @param social_Number the social_Number to set
	 */
	public void setSocial_Number(String social_Number) {
		Social_Number = social_Number;
	}

	/**
	 * @return the phone_Number
	 */
	public String getPhone_Number() {
		return Phone_Number;
	}

	/**
	 * @param phone_Number the phone_Number to set
	 */
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	/**
	 * @return the first_Name
	 */
	public String getFirst_Name() {
		return First_Name;
	}

	/**
	 * @param first_Name the first_Name to set
	 */
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	/**
	 * @return the last_Name
	 */
	public String getLast_Name() {
		return Last_Name;
	}

	/**
	 * @param last_Name the last_Name to set
	 */
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	

}
