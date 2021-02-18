package Main;

public class AutoGenPeople {
	//Auto gen a person from a given list
	//per person auto gen a phone#, SS, Address
	
	public String create() {
		return phoneNumber();
	}
	
	private String phoneNumber() {
		String number = "";
		
		while(number.length() != 12) {
			if(number.length() == 3 || number.length() == 7) number += "-";
			number += Integer.toString( (int)(Math.random() * 9) + 1);
		}
		System.out.print(number);
		return number;
	}
}
