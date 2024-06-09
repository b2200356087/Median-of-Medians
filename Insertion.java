public class Insertion {
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key_index = i;
            for(int j=i-1;j>=0;j--){
                    if(arr[j]>arr[key_index])
                        Helper.swap(arr, j, key_index--);
                    else 
                        break;
            }
        }
    }
}
