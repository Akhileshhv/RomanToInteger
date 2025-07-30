package Leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Not public — because only ONE public class is allowed per file
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = romanMap.get(s.charAt(i));
            if (current < prevValue) {
                total -= current;
            } else {
                total += current;
            }
            prevValue = current;
        }

        return total;
    }
}

// This is the public class because the file is named Main.java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("=== Roman Numeral Converter ===");
        while (true) {
            System.out.print("Enter a Roman numeral (or type 'exit' to quit): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Goodbye!");
                break;
            }

            if (!input.matches("[IVXLCDM]+")) {
                System.out.println("Invalid input. Please enter a valid Roman numeral.");
                continue;
            }

            int result = sol.romanToInt(input);
            System.out.println("Integer value: " + result);
        }

        scanner.close();
    }
}



