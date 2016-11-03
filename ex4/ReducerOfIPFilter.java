package No4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReducerOfIPFilter {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		    String line = scanner.nextLine();
			Set<String> set = new HashSet();
			while (scanner.hasNext()){
			if(scanner.nextLine()!=null){
				set.add(scanner.nextLine());
			}
		}
			System.out.println(set.size());
	}
}
