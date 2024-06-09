import java.util.Arrays;

public class Helper {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
    public static int[][] partition(int[] arr, int pivot){ //p for pivot value 
        int n = arr.length;
        int l=-1;   //num items smaller than pivot. index l+1 will be the pivot's final location.
        int equal=n;
        for(int i=0;i<equal;i++)
            if(arr[i]<pivot)
                swap(arr, ++l,i);
            else if(arr[i]==pivot)
                swap(arr, i--, --equal);
        
        int[] arr_less = Arrays.copyOf(arr, l+1);
        int[] arr_equal = Arrays.copyOfRange(arr, equal, n);
        int[] arr_greater  = Arrays.copyOfRange(arr, l+1, equal);
        return new int[][]{arr_less, arr_equal, arr_greater};
    }

    public static boolean partitionVerifier(int[] arr, int p){
        int n=arr.length;
        int pivot = arr[p];
        for(int i=0;i<n;i++)
            if(!(i<p && arr[i]<=pivot) && !(i>=p && arr[i]>=pivot))
                return false;
        return true;
    }
}
