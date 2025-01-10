package org.example;


public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String string="pwwwkew";
        int a=lengthOfLongestSubstring(string);
        System.out.println(a);
    }
    public static int lengthOfLongestSubstring(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }

        return result.toString().length();
    }
}
