import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (charMap.containsKey(s.charAt(right))) {
                left = Math.max(left, charMap.get(s.charAt(right)) + 1);
            }
            charMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        int result = lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
        scanner.close();
    }
}
