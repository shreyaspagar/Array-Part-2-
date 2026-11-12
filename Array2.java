//Printing A Subarrays with maximum sum , BRUTE FORCE (BASIC)
// public class Array2 {
//     public static void maxSubarraysSum(int numbers[]) {
//         int currsum = 0;
//         int maxSum = Integer.MIN_VALUE;
//         for(int i=0; i<numbers.length; i++) {
//             int start = i;
//             for(int j=i; j<numbers.length; j++) {
//                 int end = j;
//                 currsum = 0;
//                 for(int k=start; k<=end; k++) { //print
//                     //subarray sum
//                     currsum += numbers[k];
//                 }
//                 System.out.println(currsum);
//                 if(maxSum < currsum) {
//                    maxSum = currsum;
//                 }
//             }
            
//         }

//         System.out.println("max sum = " + maxSum);
//     }

//     public static void main(String[] args) {
//         int numbers[] = {1, -2, 6, -1, 3};
//         maxSubarraysSum(numbers);
//     }
// }    

//Printing A Subarrays with maximum sum , (PREFIX ARRAY)
// public class Array2 {
//     public static void maxSubarraysSum(int numbers[]) {
//         int currsum = 0;
//         int maxSum = Integer.MIN_VALUE;
//         int prefix[] = new int[numbers.length];

//         prefix[0] = numbers[0]; //0th index = 0 elements
//         //calculate prefix array
//         for(int i=1; i<prefix.length; i++) {
//             prefix[i] = prefix[i-1] + numbers[i];
//         }

//         for(int i=0; i<numbers.length; i++) {
//             int start = i;
//             for(int j=i; j<numbers.length; j++) {
//                 int end = j;
                
//                 currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                
//                 if(maxSum < currsum) {
//                    maxSum = currsum;
//                 }
//             }
            
//         }

//         System.out.println("max sum = " + maxSum);
//     }

//     public static void main(String[] args) {
//         int numbers[] = {1, -2, 6, -1, 3};
//         maxSubarraysSum(numbers);
//     }
// }    

//Printing A Subarrays with maximum sum , (Kadane's Algorithm)
// public class Array2 {
//     public static void maxSubarraysSum(int numbers[]) {
//         int currsum = 0;
//         int maxSum = Integer.MIN_VALUE;
//         int prefix[] = new int[numbers.length];

//         prefix[0] = numbers[0]; //0th index = 0 elements
//         //calculate prefix array
//         for(int i=1; i<prefix.length; i++) {
//             prefix[i] = prefix[i-1] + numbers[i];
//         }

//         for(int i=0; i<numbers.length; i++) {
//             int start = i;
//             for(int j=i; j<numbers.length; j++) {
//                 int end = j;
                
//                 currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                
//                 if(maxSum < currsum) {
//                    maxSum = currsum;
//                 }
//             }
            
//         }

//         System.out.println("max sum = " + maxSum);
//     }

//     public static void kadanes(int numbers[]) {
//         int ms = Integer.MIN_VALUE;
//         int cs = 0;

//         for(int i=0; i<numbers.length; i++) {
//             cs = cs + numbers[i];
//             if(cs < 0) {
//                 cs = 0;
//             }
//             ms = Math.max(cs, ms);
//         }

//         System.out.println("our max subarray sum is : " + ms);
//     }

//     public static void main(String[] args) {
//         int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};
//         maxSubarraysSum(numbers);
//     }
// }

//Water Trapping (INTERVIEW PRESPECTIVE)
// import java.util.*;
// public class Array2 {
//      public static int trappedRainWater(int height[]) {
//         int n = height.length;
        //calculate left max boundary = array
        // int leftMax[] = new int[n]; //left height ke barabar
        // leftMax[0] = height[0]; //left la height kaich nhi height sudha 0
        // for(int i=1; i<n; i++) {
        //     leftMax[i] = Math.max(height[i], leftMax[i-1]);
        // }

        //calculate right max boundary = array
        // int rightMax[] = new int[n];
        // rightMax[n-1] = height[n-1]; //n-1 ke liya already calculate value
        // for(int i=n-2; i>=0; i--) {
        //     rightMax[i] = Math.max(height[i], rightMax[i+1]);
        // }
        
        // int trappedWater = 0;
        //loop
        // for(int i=0; i<n; i++) {
            //waterLevel = min(leftmax bound, rightmax bound)
            // int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //trapped water = water level - height[i]
//             trappedWater += waterLevel - height[i];
//         }
//             return trappedWater;
// } 

// public static void main(String[] args) {
//     int height[] = {4, 2, 0, 6, 3, 2, 5};
//     System.out.println(trappedRainWater(height));
// }

//Buy & Sell Stocks
import java.util.*;
public class Array2 {

    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if(buyPrice < prices[i]) { //profit
                int profit = prices[i] - buyPrice; //today's profit profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(buyAndSellStocks(prices));
    }
}