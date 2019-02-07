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



class Result4 {

    /*
     * Complete the 'budgetShopping' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY bundleQuantities
     *  3. INTEGER_ARRAY bundleCosts
     */

    public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {

        int m = bundleQuantities.size();
        List<Integer> maxQ = new ArrayList<Integer>();
        for(int i=0; i<n+1 ; i++)
            maxQ.add(0);

        for(int cost=0; cost<n+1; cost++){
            for(int j=0; j<m; j++){
                if( cost == 0 )
                    maxQ.set(cost, 0);
                else if(cost < bundleCosts.get(j))
                    maxQ.set(cost, (maxQ.get(cost-1) > maxQ.get(cost)) ? maxQ.get(cost-1) : maxQ.get(cost) );
                else
                    maxQ.set(cost,  maxQ.get(cost-1) > bundleQuantities.get(j)+maxQ.get(cost-bundleCosts.get(j))
                            ? ( maxQ.get(cost-1) > maxQ.get(cost) ? maxQ.get(cost-1) : maxQ.get(cost) )
                            : ( bundleQuantities.get(j)+maxQ.get(cost-bundleCosts.get(j)) > maxQ.get(cost) ? bundleQuantities.get(j)+maxQ.get(cost-bundleCosts.get(j)) : maxQ.get(cost) ));
            }
        }
        return maxQ.get(n);

    }

}

public class BudgetShopping {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int bundleQuantitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> bundleQuantities = IntStream.range(0, bundleQuantitiesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int bundleCostsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> bundleCosts = IntStream.range(0, bundleCostsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result4.budgetShopping(n, bundleQuantities, bundleCosts);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
