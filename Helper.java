import java.util.Arrays;

public class Helper {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 


    //returns three unordered subarrays of arr: 
    //numbers smaller than the pivot, greater than the pivot, and equal to pivot
    public static int[][] partition(int[] arr, int pivot){ //p for pivot VALUE 
        int n = arr.length;
        int l=-1;       //last index of the array which contains numbers smaller than the pivot
        int equal=n;    //equal: tracks the numbers equal to the pivot. These are swapped to the end of the array when encountered.
        
        //partition the array in-place
        for(int i=0;i<equal;i++)    //no need to check indices after equal, since those are equal to pivot. 
            if(arr[i]<pivot)
                swap(arr, ++l,i);           //[0:l] ->numbers smaller than the pivot
            else if(arr[i]==pivot)
                swap(arr, i--, --equal);    //[equal, n] ->numbers equal to pivot
        
        int[] arr_less = Arrays.copyOf(arr, l+1);
        int[] arr_equal = Arrays.copyOfRange(arr, equal, n);
        int[] arr_greater  = Arrays.copyOfRange(arr, l+1, equal);
        return new int[][]{arr_less, arr_equal, arr_greater};
    }
}
