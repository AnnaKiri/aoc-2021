package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		try {
			Scanner scan = new Scanner(file);
			List<String> course = new ArrayList<>();
			
			while (scan.hasNextLine()) {
				course.add(scan.nextLine());
			}
			
			scan.close();
			
			int horizontal = 0;
			int depth = 0;
			int aim = 0;
			for (int i = 0; i < course.size(); i++) {
				String[] coord = course.get(i).split(" ");
				int value = Integer.parseInt(coord[1]);
				switch (coord[0]) {
					case "forward":
						horizontal = horizontal + value;
						depth = depth + aim * value;
						break;
					case "down":
						aim = aim + value;
						break;
					case "up":
						aim = aim - value;
						break;
					default:
						System.out.println("Error1!");
						return;
				}
			}
			
			System.out.println(horizontal * depth);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
}
