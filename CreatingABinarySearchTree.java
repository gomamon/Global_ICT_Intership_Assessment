
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




class Result2 {

    /*
     * Complete the 'createBST' function below.
     *
     * The function accepts INTEGER_ARRAY keys as parameter.
     */

    public static void createBST(List<Integer> keys) {

        Integer counter = 0;
        List<Integer> nodes = new ArrayList<Integer>();
        List<Integer> leftChilds = new ArrayList<Integer>();
        List<Integer> rightChilds = new ArrayList<Integer>();

        Integer idx = -1;

        for(Integer i =0; i<keys.size(); i++){
            Integer key = keys.get(i);
            Integer current = 0;
            idx += 1;

            if (nodes.size() != 0){
                while(true){
                    counter++;
                    if(key < nodes.get(current)){
                        if(leftChilds.get(current)==-1){
                            nodes.add(key);
                            leftChilds.add(-1);
                            rightChilds.add(-1);

                            leftChilds.set(current,nodes.size()-1);
                            break;
                        }
                        else
                            current = leftChilds.get(current);
                    }
                    else{
                        if(rightChilds.get(current)==-1){
                            nodes.add(key);
                            leftChilds.add(-1);
                            rightChilds.add(-1);

                            rightChilds.set(current,nodes.size()-1);
                            break;
                        }
                        else
                            current = rightChilds.get(current);
                    }

                }
            }
            else{
                nodes.add(key);
                leftChilds.add(-1);
                rightChilds.add(-1);
            }

            System.out.println(counter);
        }


    }

}

public class CreatingABinarySearchTree{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int keysCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> keys = IntStream.range(0, keysCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        Result2.createBST(keys);

        bufferedReader.close();
    }
}