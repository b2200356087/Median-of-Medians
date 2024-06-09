import java.util.Arrays;

public class MedianOfMedian {
    interface IntArrayFunction {
        int apply(int[] array);
    }
    public static IntArrayFunction getMedian = (subArr)->{
        Insertion.sort(subArr);
        return subArr[(subArr.length)/2];
    };



    public static int select(int[] arr, int n, int j ){

        if(n<=5){
            Insertion.sort(arr);
            return arr[j-1];        //j: jth smallest number. if j were 1, we'd have to send the first one, and if j were n
                                    //we'd return n-1st int.
        }

        int[] medians = new int[(n+4)/5];
        for(int i=0;i<(n+4)/5;i++){
            int[] subArr = Arrays.copyOfRange(arr, i*5, n< (i+1)*5 ? n:(i+1)*5);
            medians[i] = getMedian.apply(subArr);
        }

        int pivot = select(medians, medians.length, medians.length/2); 
        
        int[] arrCopy = Arrays.copyOf(arr, n);

        int[][] partitionedArrays = new int[3][];
        int index = 0;
        for (int[] partition : Helper.partition(arrCopy, pivot)){
            partitionedArrays[index++] = partition;

        }
        int[] arrLess = partitionedArrays[0];
        int[] arrGreater= partitionedArrays[2];
        int[] arrEqual= partitionedArrays[1];

        if(j<=len(arrLess) + len(arrEqual) && j>len(arrLess))
            return pivot;
        else if(j<=len(arrLess))
            return select(arrLess, len(arrLess), j);
        else {
            return select(arrGreater, arrGreater.length, j-len(arrEqual) - len(arrLess));
        }
        /*
        else if (partitionIndex>j)
            return select(Arrays.copyOf(arrCopy, partitionIndex), partitionIndex, j);
        else if (partitionIndex<j)
            return select(Arrays.copyOfRange(arrCopy, partitionIndex, n), n-partitionIndex, j-partitionIndex);
        else
            return -1; */
    }

    private static int len(int[] arr){
        return (arr==null)? 0:arr.length;
    }
}
