import java.util.Arrays;

public class MedianOfMedian {


    //define the getMedian function for small arrays (usually n<=5)
    //sorts the array with insertion sort, returns the (approximate) median, 
    //i.e. returns an element of the array even when n is even.
    interface IntArrayFunction {
        int apply(int[] array);
    }
    public static IntArrayFunction getMedian = (subArr)->{
        Insertion.sort(subArr);
        return subArr[(subArr.length)/2];
    };


    public static int select(int[] arr, int n, int j ){
        
        //if array small, just use insertion sort and return the jth smallest number
        if(n<=5){
            Insertion.sort(arr);
            return arr[j-1];        //j: jth smallest number. if j were 1, we'd have to send the first one, and if j were n
                                    //we'd return n-1st int. (in the array)
        }

        //holds the medians of the subarrays of arr, each subarray being of length <=5
        int[] medians = new int[(n+4)/5];
        for(int i=0;i<(n+4)/5;i++){
            
            //copy ith subarray, if i==n-1 the subarray may have length <=5
            int[] subArr = Arrays.copyOfRange(arr, i*5, n< (i+1)*5 ? n:(i+1)*5);
            //compute median for the ith subarray
            medians[i] = getMedian.apply(subArr);       //
        }

        //compute the median of medians, which makes a good pivot.
        int pivot = select(medians, medians.length, medians.length/2); 
        
        //partition arr into three: greater than pivot, lesser than pivot, eq. to pivot 
        int[][] partitionedArrays = new int[3][];
        int index = 0;
        int[] arrCopy = Arrays.copyOf(arr, n);
        for (int[] partition : Helper.partition(arrCopy, pivot))
            partitionedArrays[index++] = partition;
        
        int[] arrLess = partitionedArrays[0];
        int[] arrGreater= partitionedArrays[2];
        int[] arrEqual = partitionedArrays[1];


        //if pivot is the jth smallest number, return pivot
        //if jth smallest smaller than the pivot, search the array of smaller numbers
        //if jth smallest number greater than the pivot, search the array of greater numbers
        if(j<=len(arrLess) + len(arrEqual) && j>len(arrLess))
            return pivot;
        else if(j<=len(arrLess))
            return select(arrLess, len(arrLess), j);
        else {
            return select(arrGreater, arrGreater.length, j-len(arrEqual) - len(arrLess));
        }
    }

    private static int len(int[] arr){
        return (arr==null)? 0:arr.length;
    }
}
