package Main;
import java.util.Comparator;
import java.util.Scanner;
import java.lang.*;

public class Driver extends TreeMap<String, Person_Info>{

	private Comparator<Integer> first = new Comparator<Integer>() {
		public int compare(Integer arg0, Integer arg1) {
			return arg0 - arg1;
		}
	};
	private Comparator<Integer> second = new Comparator<Integer>() {
		public int compare(Integer arg0, Integer arg1) {
			return arg1 - arg0;
		}
	};
	private Comparator<Integer> third = new Comparator<Integer>() {
		public int compare(Integer arg0, Integer arg1) {
			return 0;
		}
	};
	
	public static void main(String[] args) {
		//Comparator<String> c = null;
		AutoGenPeople generator = new AutoGenPeople();
		generator.init();
		//Scanner input = new Scanner(System.in);
		long startTime = System.nanoTime();
		
		TreeMap<String, Person_Info> cur = new TreeMap<String, Person_Info>();
		
		for(int  i =0; i< 5000; i++) {
			Person_Info add = generator.create();
			cur.put(add.getName(), add);
		}
		
		

/**
	String in = "yes";
	while(in.equalsIgnoreCase("yes")) {
		
		System.out.println("Would you like to find a name?");
			String n = input.nextLine();
			
			if(n.equalsIgnoreCase("yes") ) {
				System.out.println("Enter a name to find");
					n = input.nextLine();
					if(cur.getPerson(n) == null) {
						String in2 = " ";
							while(in2.equalsIgnoreCase("yes") || in2.equalsIgnoreCase("no")) {
									System.out.println("Would you like to try again?");
										in2 = input.nextLine();
							}
								if(in2.equalsIgnoreCase("no") ){
										break;
								}
					
						}else {
							cur.getInfo(n);
						}

			}
	}
		System.out.println("\n\n");
		
		cur.print(null,null);
		//cur.printFrom("Luis Yue");
		System.out.println("\n\n");
		cur.print("Louis Vale", null);
		System.out.println("\n\n");
		cur.print("Bobby Wright", "Bobby Wright8");
		
**/
		cur.print(null,null);
		
		long estimatedTime = (System.nanoTime() - startTime);
		System.out.println("Estimated time (in nanoseconds):  "+ estimatedTime);
		System.out.println("Estimated time (in seconds):  "+ (double)estimatedTime/1000000000);
	}
	
}
