import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.nextLine();

        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
