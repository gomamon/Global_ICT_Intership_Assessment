
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



class Result3 {

    /*
     * Complete the 'findRange' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER num as parameter.
     */

    public static long findRange(int num) {
        String n = Integer.toString(num);
        String max_num = n;
        String min_num = n;


        /* get maximum value */

        char target_max = '9';
        for(int i=0 ; i<n.length() ; i++){
            target_max = n.charAt(i);
            if(target_max != '9')
                break;
        }
        max_num = max_num.replace(target_max, '9');


        /* get minimum value */
        char target_min = '0';

        if(n.charAt(0)=='1' && n.length() > 1) {
            boolean flag = false;

            for (int i = 0; i < n.length(); i++) {
                target_min = n.charAt(i);
                if (target_min != '0' && target_min != '1') {
                    flag = true;
                    break;
                }
            }
            if(flag==true)
                min_num = min_num.replace(target_min, '0');
        }
        else{
            target_min = n.charAt(0);
            min_num = min_num.replace(target_min, '1');
        }

        return Long.parseLong(max_num) - Long.parseLong(min_num);
    }

}


public class ErrorDigitRange{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int num = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result3.findRange(num);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}