public class RecursiveSearch {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;
        
        System.out.println("Searching for target: " + target);
        System.out.println("----------------------------------------");
        
        int result = binarySearchTrace(numbers, target, 0, numbers.length - 1);
        
        System.out.println("----------------------------------------");
        if (result != -1) {
            System.out.println("Result: Element found at index " + result);
        } else {
            System.out.println("Result: Element not found.");
        }
    }

    public static int binarySearchTrace(int[] arr, int target, int low, int high) {
        if (arr == null || low < 0 || low > arr.length || high < -1 || high >= arr.length) {
            System.out.println("   Invalid array or search range.");
            return -1;
        }

        System.out.println("-> Recursive Call: searching range [" + low + " to " + high + "]");
        
        if (low > high) {
            System.out.println("   Base case reached: low > high. Element not here.");
            return -1;
        }
        
        int mid = low + (high - low) / 2;
        System.out.println("   Checking middle index " + mid + " (Value: " + arr[mid] + ")");
        
        if (arr[mid] == target) {
            System.out.println("   Match found!");
            return mid;
        } 
        else if (arr[mid] > target) {
            System.out.println("   Target is smaller. Searching left half...");
            return binarySearchTrace(arr, target, low, mid - 1);
        } 
        else {
            System.out.println("   Target is larger. Searching right half...");
            return binarySearchTrace(arr, target, mid + 1, high);
        }
    }
}