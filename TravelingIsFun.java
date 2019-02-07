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



class Result {

    /*
     * Complete the 'connectedCities' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER g
     *  3. INTEGER_ARRAY originCities
     *  4. INTEGER_ARRAY destinationCities
     */
    public static int findRoot(List<Integer> sets, int i){
        if(sets.get(i) == i)
            return i;
        sets.set(i,findRoot(sets,sets.get(i)));
        return sets.get(i);
    }

    public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {
        List<Integer> sets = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0; i<n+1 ;i++)
            sets.add(i);
        for(int i=0; i<originCities.size();i++)
            ans.add(0);

        /* Union connected cities*/
        for(int i=g+1 ; i<n+1 ; i++){
            int mul = i;
            /* Union i and i's multiples(mul) less than n */
            while (mul <= n) {
                int root_mul = findRoot(sets, mul);
                int root_i = findRoot(sets, i);
                if (root_mul != root_i)
                    sets.set(root_mul, root_i);
                mul += i;
            }
        }

        /* Compare origin's root and destination's root */
        for(int i=0; i<originCities.size(); i++)
            ans.set(i, findRoot(sets,originCities.get(i))==findRoot(sets,destinationCities.get(i)) ? 1 : 0);

        return ans;


    }

}

public class TravelingIsFun {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        int originCitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> originCities = IntStream.range(0, originCitiesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int destinationCitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> destinationCities = IntStream.range(0, destinationCitiesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.connectedCities(n, g, originCities, destinationCities);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
