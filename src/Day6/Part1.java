import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String path = ".\\src\\Day6\\data.txt";
        final String [] initialNumberOfFish = Files.readString(Path.of(path)).split(",");

        List<Lanternfish> fishes = new ArrayList<>();

        for (int i = 0; i < initialNumberOfFish.length; i++){
            fishes.add(new Lanternfish(Byte.parseByte(initialNumberOfFish[i])));
        }

        for (int i = 0; i < 80; i++) {
            List<Lanternfish> fishesTemp = new ArrayList<>(fishes);
            for (Lanternfish fish : fishes) {
                if (fish.newDay()) {
                    fishesTemp.add(new Lanternfish());
                }
            }
            fishes = fishesTemp;
        }

        System.out.println(fishes.size());
    }
}
