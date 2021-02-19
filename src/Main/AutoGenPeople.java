package Main;
import java.io.*;
import java.util.*;

public class AutoGenPeople {
	//Auto gen a person from a given list
	//per person auto gen a phone#, SS, Address
	final int lastMAX = 50;
	String[] lastNames = new String[lastMAX];
	
	final int firstMAX = 2000;
	String[] firstNames = new String[firstMAX];
	
	final int addressMAX = 152;
	String[] address = new String[addressMAX];
	
	public Person_Info create() {
		Person_Info person = new Person_Info(" "," "," "," "," ");
		person.setPhone_Number(phoneNumber());
		person.setFirst_Name(firstName());
		person.setLast_Name(lastName());
		person.setSocial_Number(SocialSec());
		person.setAddress(getAddress());
		return person;
	}
	
	public void init() {
		int index = 0;
		try {
			File last = new File("Last.txt");
			File first = new File("CombinedList.txt");
			File  addressList = new File("Address.txt");
			
			Scanner getFirst= new Scanner(first);	
			Scanner getLast = new Scanner(last);	
			Scanner getAddress = new Scanner(addressList);	
			
			while( (getFirst.hasNextLine() || getLast.hasNextLine() || getAddress.hasNextLine() ) && index < max(firstMAX, lastMAX, addressMAX) ) {
				if(getLast.hasNextLine() && lastMAX > index) {
					lastNames[index] = getFirst.nextLine();
				//	System.out.print(" | " + lastNames[index]);
				}
				if(getFirst.hasNextLine() && firstMAX > index) {
					firstNames[index] = getFirst.nextLine();
				//	System.out.print(" | " + firstNames[index]);
				}
				if(getAddress.hasNextLine() && addressMAX > index) {
					String x = getAddress.nextLine().trim();
					int nums = (int)(Math.random() * 6) + 1;
					x +=" ";
					for(int i = 0; i < nums; i++ ) { x += Integer.toString((int)(Math.random() * 9));}
					address[index] = x;
				//	System.out.print(" | " + address[index]);
				}
				//System.out.println();
				index++;
			}
			getFirst.close();
			getLast.close();
			getAddress.close();
		}catch(FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}

	private int max(int x, int y, int z) {
		return Math.max(x, Math.max(y, z) );
	}

	
	private String phoneNumber() {
		String number = "";
		while(number.length() != 12) {
			if(number.length() == 3 || number.length() == 7) number += "-";
			number += Integer.toString( (int)(Math.random() * 9) );
		}
		//System.out.println(number);
		return number;
	}
	
	private String lastName() {
		return lastNames[(int)(Math.random() * lastMAX - 1) ];
	}
	
	private String firstName() {
		return firstNames[(int)(Math.random() * firstMAX -1)];
	}
	
	private String SocialSec() {
		String number = "";
		for(int i = 0; i <9 ; i++) { number += Integer.toString((int)(Math.random() * 9)); }
		return number;
	}
	
	private String getAddress() {
		return address[(int) (Math.random() * addressMAX)];
	}
}
