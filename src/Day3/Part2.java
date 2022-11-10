package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

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
		
		findLifeSupportRating(inputData);

	}
	
	public static void findLifeSupportRating(List<String> inputData) {
		
		List<String> forO2 = new ArrayList<>(inputData);
		
		for (int j = 0; j < forO2.get(0).length(); j++) {
			int one = 0;
			int zero = 0;
			for (int i = 0; i < forO2.size(); i++) {
				String str = forO2.get(i);
				String FirstValue = String.valueOf(str.charAt(j));
				if (FirstValue.equals("1")) {
					one++;
				} else {
					zero++;
				}
			}
			
			List<Integer> index = new ArrayList<>();

			if (one >= zero) {
				for (int l = 0; l < forO2.size(); l++) {
					String str = forO2.get(l);
					String value = String.valueOf(str.charAt(j));
					if (value.equals("0")) {
						index.add(l);
					}
				}
			} else {
				for (int l = 0; l < forO2.size(); l++) {
					String str = forO2.get(l);
					String value = String.valueOf(str.charAt(j));
					if (value.equals("1")) {
						index.add(l);
					}
				}
			}
			
			for (int r = index.size() - 1; r >= 0; r--) {
				int index2 = index.get(r);
				forO2.remove(index2);
			}
			
			if (forO2.size() == 1) {
				break;
			}
		}	
		
		
		List<String> forCO2 = new ArrayList<>(inputData);

		for (int j = 0; j < forCO2.get(0).length(); j++) {
			int one = 0;
			int zero = 0;
			for (int i = 0; i < forCO2.size(); i++) {
				String str = forCO2.get(i);
				String FirstValue = String.valueOf(str.charAt(j));
				if (FirstValue.equals("0")) {
					zero++;
				} else {
					one++;
				}
			}
			
			List<Integer> index = new ArrayList<>();

			if (one >= zero) {
				for (int l = 0; l < forCO2.size(); l++) {
					String str = forCO2.get(l);
					String value = String.valueOf(str.charAt(j));
					if (value.equals("1")) {
						index.add(l);
					}
				}
			} else {
				for (int l = 0; l < forCO2.size(); l++) {
					String str = forCO2.get(l);
					String value = String.valueOf(str.charAt(j));
					if (value.equals("0")) {
						index.add(l);
					}
				}
			}
			
			for (int r = index.size() - 1; r >= 0; r--) {
				int index2 = index.get(r);
				forCO2.remove(index2);
			}
			
			if (forCO2.size() == 1) {
				break;
			}
		}
		
		int o2 = Integer.parseInt(forO2.get(0), 2);
		int co2 = Integer.parseInt(forCO2.get(0), 2);
		
		System.out.println(o2);
		System.out.println(co2);
		
		System.out.println("The life support rating of the submarine " + o2 * co2);

	}

}
