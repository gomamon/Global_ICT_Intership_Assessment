import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'winner' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY andrea
     *  2. INTEGER_ARRAY maria
     *  3. STRING s
     */

    public static String winner(List<Integer> andrea, List<Integer> maria, String s) {
        Integer andrea_score = 0;
        Integer maria_score = 0;


        if(s.equals("Even")) {
            for (Integer i = 0; i < andrea.size(); i += 2) {
                maria_score += (maria.get(i) - andrea.get(i));
                andrea_score += (andrea.get(i) - maria.get(i));
            }
        }
        else{
            for (Integer i = 1; i < andrea.size() ; i +=2){
                maria_score += (maria.get(i) - andrea.get(i));
                andrea_score += (andrea.get(i) - maria.get(i));
            }
        }

        if(andrea_score - maria_score == 0)
            return "Tie";

        if(andrea_score - maria_score > 0)
            return "Andrea";
        else
            return "Maria";

    }

}

public class FindTheWinner {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int andreaCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> andrea = IntStream.range(0, andreaCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int mariaCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> maria = IntStream.range(0, mariaCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        String s = bufferedReader.readLine();

        String result = Result1.winner(andrea, maria, s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
