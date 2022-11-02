package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		String path = ".\\src\\Day1\\data.txt";
		File file = new File(path);
		
		try {
			Scanner scan = new Scanner(file);
			List<Integer> measurements = new ArrayList <>();
			
			while (scan.hasNextInt()) {
				measurements.add(scan.nextInt());
			}
			
			scan.close();
			
			int sum = 0;
			for (int i = 0; i < measurements.size() - 1; i++) {
				int index1 = measurements.get(i);
				int index2 = measurements.get(i+1);
				
				if (index2 > index1) {
					sum++;
				}
			}
			
			System.out.println("Measurements are larger than the previous measurement: " + sum);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}	
}
