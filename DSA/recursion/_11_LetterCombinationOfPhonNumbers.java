package DSA.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Problem Link : https://leetcode.com/problems/subsets-ii/description/
 * Video  : https://www.youtube.com/watch?v=0snEunUacZY
 *
 * Topic : TRecursion, TBacktracking
 * (Revisit) - Need Revision
 *
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *

 * Constraints:
 *     0 <= digits.length <= 4
 *     digits[i] is a digit in the range ['2', '9'].
 *
 */
public class _11_LetterCombinationOfPhonNumbers {

    HashMap<Character,String> charsMap = new HashMap<>();
    _11_LetterCombinationOfPhonNumbers(){
        charsMap.put('2',"abc");
        charsMap.put('3',"def");
        charsMap.put('4',"ghi");
        charsMap.put('5',"jkl");
        charsMap.put('6',"mno");
        charsMap.put('7',"pqrs");
        charsMap.put('8',"tuv");
        charsMap.put('9',"wxyz");
    }
    public void backtrackLetterCombinations(
            List<String> answer,
            StringBuilder currentString,
            String digits,
            int level
    ){

        // base case
        if(digits.length()==currentString.toString().length()){
            answer.add(currentString.toString());
            return;
        }

        String charItems = charsMap.get((digits.charAt(level)));
        for (int i=0;i<charItems.length();i++){
            Character c = charItems.charAt(i);
            currentString.append(c);
            backtrackLetterCombinations(answer, currentString, digits, level+1);
            currentString.deleteCharAt(currentString.length()-1);
        }
    }

    /**
     * Time Complexity: O(4^n × n)
     *  - Each digit maps to 3-4 letters
     *  - At each level, we make up to 4 recursive calls at worst case
     *  - Total combinations = 4^n (worst case)
     *  - O(n) work per combination
     *
     *  Space Complexity: O(n)
     *   - Recursion Stack: O(n)
     *   - StringBuilder (currentString): O(n)
     *   - HashMap (charsMap): O(1)
     *   - Result Storage: Not counted in auxiliary space
    * */
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        ArrayList<String> answer = new ArrayList<>();
        backtrackLetterCombinations(answer,new StringBuilder(),digits,0);
        return answer;
    }

    public static void main(String[] args) {

        _11_LetterCombinationOfPhonNumbers solution = new _11_LetterCombinationOfPhonNumbers();;
        solution.letterCombinations("23").forEach(integers -> {
            System.out.println(" - " + integers);
        });
        System.out.println();
    }

}
