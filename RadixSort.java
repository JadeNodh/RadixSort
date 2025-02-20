
package radixsort;


public class RadixSort {
    
    static void countSort(int arr[], int n, int exp){
        //output array
        int output[] = new int[n];
        // Count array for digits (0-9)
        int count[] = new int[10];
        
        for(int i = 0; i < 10; i++)
            count[i] = 0;
        
        // Count occurrences of digits at the current place value(exp)
        for(int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        
        // update count[i] to store actual positons in output[]
        for(int i = 1; i < 10; i++)
            count[i] += count[i-1];
        
        // Build the output array
         for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
         
        // copy the sorted output array back to arr[]
        for(int i = 0; i < n; i++)
            arr[i] = output[i];
    }

   
    public static void main(String[] args) {
        
    }
    
}
