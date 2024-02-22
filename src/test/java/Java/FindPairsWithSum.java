package Java;

public class FindPairsWithSum {

    public static void main(String[] args) {
        // Initialize the array
        int[] numbers = {1, 2, 3, 4, 1};
        int targetSum = 5; // Target sum for the pairs
        int count = findPairsCount(numbers, targetSum);

        // Print the result
        System.out.println("There are " + count + " pairs that sum to " + targetSum + ".");
    }

    public static int findPairsCount(int[] nums, int target) {
        int pairsCount = 0; // Initialize counter for pairs

        // Iterate through each element, compare it with every other element
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // Start from i+1 to avoid counting the same pair twice
                if (nums[i] + nums[j] == target) { // Check if the pair sums up to target
                    pairsCount++; // Increment counter
                }
            }
        }
        return pairsCount; // Return the count of pairs
    }



}
