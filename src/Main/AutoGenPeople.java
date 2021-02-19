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
		person.setAddress(address());
		return person;
	}
	
	public void init() {
		last();
		first();
		
	}
	
	private void first() {
		
	}
	
	private void last() {
		String last = "";
		int index = 0;
		try {
			File last = new File("Last.txt");
			File first = new File("CombinedList.txt");
			
			Scanner getFirst= new Scanner(first);	
			Scanner getLast = new Scanner(last);	
			
			while(toGet.hasNextLine()) {
				lastNames[index++] = toGet.nextLine();
				System.out.println(" " + lastNames[index-1]);
				//index++;
			}
			System.out.print(" " + last);
			toGet.close();
		}catch(FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
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
		String last = "";
		int line = 0;
		int random= (int)(Math.random() * 50) + 1;
		try {
			File name = new File("Last.txt");
			Scanner toGet = new Scanner(name);		
			while(toGet.hasNextLine()) {
				if(++line == random) {
					last = toGet.nextLine();
					break;
				}
				toGet.nextLine();
			}
			//System.out.print(" " + last);
			toGet.close();
			return last;
		}catch(FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		return null;
	}
	
	private String firstName() {
		String first = "";
		int line = 0;
		int random= (int)(Math.random() * 2000) + 1;
		try {
			File name = new File("CombinedList.txt");
			Scanner toGet = new Scanner(name);		
			while(toGet.hasNextLine()) {
				if(++line == random) {
					first = toGet.nextLine();
					break;
				}
				toGet.nextLine();
			}
			//System.out.print(first);
			toGet.close();
			return first;
		}catch(FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		return null;
	}
	
	private String SocialSec() {
		String number = "";
		for(int i = 0; i <9 ; i++) { number += Integer.toString((int)(Math.random() * 9)); }
		//System.out.println("\n" + number);
		return number;
	}
	
	private String address() {
		String address = "";
		int line = 0;
		int random= (int)(Math.random() * 152) + 1;
		try {
			File name = new File("Address.txt");
			Scanner toGet = new Scanner(name);		
			while(toGet.hasNextLine()) {
				if(++line == random) {
					address = toGet.nextLine();
					break;
				}
				toGet.nextLine();
			}
			address = address.trim();
			int nums = (int)(Math.random() * 6) + 1;
			address +=" ";
			for(int i = 0; i < nums; i++ ) { address += Integer.toString((int)(Math.random() * 9));}
			//System.out.print(address);
			toGet.close();
			return address;
		}catch(FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		return null;
	}
}
