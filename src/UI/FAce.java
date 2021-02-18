package UI;
import java.io.*;
import java.util.*;

import Main.*;

public class FAce {
	
	public static void main(String [] args) throws IOException {
		
		try {
		File boy = new File("b.txt");
		File girl = new File("Last.txt");
		File out = new File("CombinedList.txt");
		
		Scanner readB = new Scanner(boy);
		Scanner readG = new Scanner(girl);
		
		while(readB.hasNextLine() && readG.hasNextLine()) {
			String b = readB.nextLine();
			String g = readG.nextLine();
			
			System.out.println(b);
			System.out.println(g);
		}
		readB.close();
		readG.close();
		}catch(FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
//		try {
//			boy = new FileInputStream("First.txt");
//			girl = new FileInputStream("Last.txt");
//		}finally {
//			if (boy != null) boy.close(); 
//			if(girl != null) girl.close();
//			if(out != null) out.close();
//		}
	}
}
