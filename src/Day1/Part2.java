package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {

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
			for (int i = 0; i < measurements.size() - 3; i++) {
				int sum1 = measurements.get(i) + measurements.get(i + 1) + measurements.get(i + 2);
				int sum2 = measurements.get(i + 1) + measurements.get(i + 2) + measurements.get(i + 3);
				
				if (sum2 > sum1) {
					sum++;
				}
			}
			
			System.out.println(sum);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}	
}
