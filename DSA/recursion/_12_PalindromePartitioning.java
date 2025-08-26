package DSA.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Problem Link : https://leetcode.com/problems/palindrome-partitioning/
 * Video  : https://www.youtube.com/watch?v=3jvWodd7ht0&ab_channel=NeetCode
 *
 * Topic : TRecursion, TBacktracking
 * (Revisit) - Need Revision
 *
 * Palindrome Partitioning

 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 *  Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class _12_PalindromePartitioning {

    public static boolean isPalindrome(String str) {
        // Handle null or empty string
        if (str == null || str.isEmpty()) {
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public void backtrackPartition(
            List<List<String>> answer,
            List<String> currentStr,
            String inputStr,
            int index
    ){
        // Base case
        if (index>=inputStr.length()){
            answer.add(new ArrayList<>(currentStr));
            return;
        }

        for (int i=index;i<inputStr.length();i++){
            String subStr = inputStr.substring(index,i+1);
            if (isPalindrome(subStr)){
                currentStr.add(subStr);
                backtrackPartition(answer, currentStr, inputStr, i+1);
                currentStr.remove(currentStr.size()-1);
            }
        }
    }

    /**
     * Time Complexity: O(N × 2^N)
     *
     * - 2^(N-1) possible partitions of the string
     * - O(N) palindrome check per substring using two pointers
     * - Total work: Exponential partitions × linear palindrome checks = O(N × 2^N)
     *
     * Space Complexity: O(N × 2^N)
     * - Output storage: Up to 2^(N-1) partitions, each with up to N substrings
     * - Recursion stack: O(N) depth
     * - Dominated by: Output storage requirements
    * */
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        backtrackPartition(answer,new ArrayList<>(),s,0);
        return answer;
    }

    public static void main(String[] args) {

        _12_PalindromePartitioning solution = new _12_PalindromePartitioning();;
        solution.partition("cbbbcc").forEach(integers -> {
            System.out.println(" - " + integers);
        });
        System.out.println();
    }

}
