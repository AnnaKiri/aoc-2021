package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		File file = new File(".\\src\\Day3\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		List<String> inputData = new ArrayList<>();
		while (scan.hasNextLine()) {
			inputData.add(scan.nextLine());
		}
				
		scan.close();	
		
		findPowerConsumption(inputData);

	}
	
	public static void findPowerConsumption(List<String> inputData) {
		String gamma = "";
		String epsilon = "";
		
		
		for (int j = 0; j < inputData.get(0).length(); j++) {
			int one = 0;
			int zero = 0;
			for (int i = 0; i < inputData.size(); i++) {
				String str = inputData.get(i);
				String FirstValue = String.valueOf(str.charAt(j));
				if (FirstValue.equals("1")) {
					one++;
				} else {
					zero++;
				}
			}
			
			if (one > zero) {
				gamma = gamma + "1";
				epsilon = epsilon + "0";
			} else {
				gamma = gamma + "0";
				epsilon = epsilon + "1";
			}
		}
		
		System.out.println(Integer.parseInt(gamma, 2));
		System.out.println(Integer.parseInt(epsilon, 2));
		
		System.out.println("The power consumption of the submarine " + Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
		
	}

}
