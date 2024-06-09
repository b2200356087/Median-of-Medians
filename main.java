import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class main {
    static Random rand = new Random();
    private static final int N = 2000;
    
    public static void main(String[] args) throws Exception {
        
        
        //Set<Integer> numSoFar = new HashSet<>();      //Set: contains numbers so far generated, to prevent duplicates.
        for(int k=0;k<1000;k++){
            //generate the input array
            int[] random_arr = new int[N];
            for (int i=0;i<N;i++){
                random_arr[i] = rand.nextInt(N);
                //random_arr[i] = generateUniqueRandom(numSoFar); //generates random numbers not contained in input the set
            }
            //Return the (N/2)th smallest number (the median) in the random_arr
            int median = MedianOfMedian.select(random_arr, N, N/2);
            //sort the array, and check the (N/2)th smallest number 
            Insertion.sort(random_arr);
            if(median != random_arr[(N)/2 -1])
                throw new Exception();
    }
        /* 
        //Return the (N/2)th smallest number in the random_arr
        System.out.println(MedianOfMedian.select(random_arr, N, N/2));

        //sort the array, and check the (N/2)th smallest number 
        Insertion.sort(random_arr);
        System.out.println(random_arr[(N)/2 -1]);*/
    }


    public static int generateUniqueRandom(Set<Integer> numSoFar) {
        int nextInt;
        do {
            nextInt = rand.nextInt(N);
        } while (numSoFar.contains(nextInt));
        numSoFar.add(nextInt);
        return nextInt;
    };
}


