package Main;
import java.util.Comparator;
import java.util.Scanner;
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
		Comparator<String> c = null;
		Scanner input = new Scanner(System.in);
		
		Person_Info first = new Person_Info("Joe" , "Brown", "45519726" ,"362-414-5641" , "4851-WestBend" );
		Person_Info b = new Person_Info("Luis" , "Yue", "17819292" ,"964-585-5521" , "East Grand Ave. 45621" );
		
		TreeMap<String, Person_Info> cur = new TreeMap<String, Person_Info>();
		
		AutoGenPeople generator = new AutoGenPeople();
		generator.create();
			
		
//		cur.put("Joe Brown7", first);
//		cur.remove("Joe Brown7");
//		cur.put("Luis Yue7", b);
//		cur.put("Big Mike7", first);
//		cur.put("Bobby Wright7", b);
//		cur.put("Louis Vale7", first);
//		
//		cur.put("Joe Brown", first);
//		cur.put("Luis Yue", b);
//		cur.put("Big Mike", first);
//		cur.put("Bobby Wright", b);
//		cur.put("Louis Vale", first);
//		
//		cur.put("Joe Brown4", first);
//		cur.put("Luis Yue4", b);
//		cur.put("Big Mike4", first);
//		cur.put("Bobby Wright4", b);
//		cur.put("Louis Vale4", first);
//
//		cur.put("Joe Brown1", first);
//		cur.put("Luis Yue1", b);
//		cur.put("Big Mike1", first);
//		cur.put("Bobby Wright1", b);
//		cur.put("Louis Vale1", first);
//		
//		cur.put("Joe Brown6", first);
//		cur.put("Luis Yue6", b);
//		cur.put("Big Mike6", first);
//		cur.put("Bobby Wright6", b);
//		cur.put("Louis Vale6", first);
//
//		
//		cur.put("Joe Brown2", first);
//		cur.put("Luis Yue2", b);
//		cur.put("Big Mike2", first);
//		cur.put("Bobby Wright2", b);
//		cur.put("Louis Vale2", first);
//		
//		cur.put("Joe Brown3", first);
//		cur.put("Luis Yue3", b);
//		cur.put("Big Mike3", first);
//		cur.put("Bobby Wright3", b);
//		cur.put("Louis Vale3", first);
//		
//		cur.put("Joe Brown8", first);
//		cur.put("Luis Yue8", b);
//		cur.put("Big Mike8", first);
//		cur.put("Bobby Wright8", b);
//		cur.put("Louis Vale8", first);
//
//		cur.put("Joe Brown5", first);
//		cur.put("Luis Yue5", b);
//		cur.put("Big Mike5", first);
//		cur.put("Bobby Wright5", b);
//		cur.put("Louis Vale5", first);


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
**/	
		System.out.println("\n\n");
		
		cur.print(null,null);
		//cur.printFrom("Luis Yue");
		System.out.println("\n\n");
		cur.print("Louis Vale", null);
		System.out.println("\n\n");
		cur.print("Bobby Wright", "Bobby Wright8");
		
		
	}
	
}
