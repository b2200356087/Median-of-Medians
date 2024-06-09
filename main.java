import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.function.Supplier;

public class main {
    static Random rand = new Random();
    private static final int N = 300;
    
    public static void main(String[] args) throws Exception {
        int[] random_arr = new int[N];
        Set<Integer> numSoFar = new HashSet<>();
        for (int i=0;i<N;i++){
            random_arr[i] = rand.nextInt(N*N*N);
            //random_arr[i] = generateUniqueRandom(numSoFar);
       }
        
        System.out.println(MedianOfMedian.select(random_arr, N, N/2));
        Insertion.sort(random_arr);
        System.out.println(random_arr[(N)/2 -1]);
    }


    public static int generateUniqueRandom(Set<Integer> numSoFar) {
        int nextInt;
        do {
            nextInt = rand.nextInt(N*N*N);
        } while (numSoFar.contains(nextInt));
        numSoFar.add(nextInt);
        return nextInt;
    };
}


