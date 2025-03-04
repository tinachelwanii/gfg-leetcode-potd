import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        backtrack(res, digitToChar, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, Map<Character, String> digitToChar, 
        String digits, int index, StringBuilder curStr) {
        if (curStr.length() == digits.length()) {
            res.add(curStr.toString());
            return;
        }

        String possibleChars = digitToChar.get(digits.charAt(index));
        for (char c : possibleChars.toCharArray()) {
            curStr.append(c);
            backtrack(res, digitToChar, digits, index + 1, curStr);
            curStr.deleteCharAt(curStr.length() - 1); // Backtracking step
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}
