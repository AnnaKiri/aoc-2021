import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String path = ".\\src\\Day6\\data.txt";
        final String[] initialNumberOfFish = Files.readString(Path.of(path)).split(",");

        long [] fishesDays = new long [9];
        for(int i = 0; i < initialNumberOfFish.length; i++){
            int days = Integer.parseInt(initialNumberOfFish[i]);
            fishesDays[days]++;
        }

        for (int l = 0; l < 256; l++) {
            long[] fishesDaysTemp = new long[9];
            for (int i = 0; i < fishesDays.length - 1; i++) {
                if (i == 0) {
                    fishesDaysTemp[6] = fishesDays[i];
                    fishesDaysTemp[8] = fishesDays[i];
                }

                fishesDaysTemp[i] += fishesDays[i + 1];
            }
            fishesDays = fishesDaysTemp;
        }

        System.out.println(Arrays.stream(fishesDays).sum());
    }
}
