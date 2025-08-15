import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    public static boolean isStrobogrammatic(String num) {
        // Define valid strobogrammatic pairs
        Map<Character, Character> strobPairs = new HashMap<>();
        strobPairs.put('0', '0');
        strobPairs.put('1', '1');
        strobPairs.put('6', '9');
        strobPairs.put('8', '8');
        strobPairs.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            // Check if the pair is invalid
            if (!strobPairs.containsKey(leftChar)) {
                return false;
            }
            if (strobPairs.get(leftChar) != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String num = "69";
        System.out.println(num + " is strobogrammatic? " + isStrobogrammatic(num)); // true

        num = "818";
        System.out.println(num + " is strobogrammatic? " + isStrobogrammatic(num)); // true

        num = "123";
        System.out.println(num + " is strobogrammatic? " + isStrobogrammatic(num)); // false
    }
}