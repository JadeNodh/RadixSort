public class RadixSort {
    
    // Function to do counting sort based on a significant digit (exp)
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // Output array
        int count[] = new int[10]; // Count array for digits (0-9)

        // Initialize count array
        for (int i = 0; i < 10; i++) 
            count[i] = 0;

        // Count occurrences of digits at the current place value (exp)
        for (int i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++;

        // Update count[i] to store actual positions in output[]
        for (int i = 1; i < 10; i++) 
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the sorted output array back to arr[]
        for (int i = 0; i < n; i++) 
            arr[i] = output[i];
    }

    // Function to get the maximum value in arr[]
    static int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) 
            if (arr[i] > max) 
                max = arr[i];
        return max;
    }

    // The main function to implement Radix Sort
    static void radixSort(int arr[], int n) {
        int m = getMax(arr, n); // Get the maximum number to know the number of digits

        // Apply countSort for every digit place (exp = 1, 10, 100, ...)
        for (int exp = 1; m / exp > 0; exp *= 10)  
            countSort(arr, n, exp);  
    }

    // Utility function to print an array
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        
        System.out.println("Original array:");
        printArray(arr, n);

        radixSort(arr, n);

        System.out.println("Sorted array:");
        printArray(arr, n);
    }
}
