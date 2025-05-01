import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        // code here
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}

/*
 * class Solution {
 * public List<Integer> findDuplicates(int[] arr) {
 * 
 * // code here
 * Set<Integer> seen=new HashSet<>();
 * Set<Integer> duplicates=new HashSet<>();
 * 
 * for (int num :arr){
 * if(!seen.add(num)){
 * duplicates.add(num);
 * }
 * }
 * 
 * return new ArrayList<>(duplicates);
 * }
 * }
 * 
 * 
 */
/*
 * Time Complexity: O(n) where n is the number of elements in the array.
 * Space Complexity: O(n) for the frequency map and the result list.
 * 
 * 
 * Given an array arr of integers, find all the elements that occur more than
 * once in the array. If no element repeats, return an empty array.
 * 
 * Examples:
 * 
 * Input: arr[] = [2, 3, 1, 2, 3]
 * Output: [2, 3]
 * Explanation: 2 and 3 occur more than once in the given array.
 * Input: arr[] = [0, 3, 1, 2]
 * Output: []
 * Explanation: There is no repeating element in the array, so the output is
 * empty.
 * Input: arr[] = [2]
 * Output: []
 * Explanation: There is single element in the array. Therefore output is empty.
 * Constraints:
 * 1 <= arr.size() <= 106
 * 0 <= arr[i] <= 106
 */