package practice.coding.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/decode-the-message/
 */
public class MessageMasking {

    @Test
    public void testMethod(){
        System.out.println(MessageMasking.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));;
    }

    /**
     * Constraints:
     *
     *     - 26 <= key.length <= 2000
     *     - 1 <= message.length <= 2000
     *     - key consists of lowercase English letters and ' '.
     *     - key contains every letter in the English alphabet ('a' to 'z') at least once.
     *     - message consists of lowercase English letters and ' '.
     */


    public static String decodeMessage(String key, String message) {
        String result = "";

        //char[] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] keyMapping = new char[26];
        int alphaIndex = 0;
        for(char c : key.toCharArray()){
            if (c != ' ' && keyMapping[c - 'a'] == 0){
                keyMapping[c - 'a'] = (char) ('a' + alphaIndex++);
            }
        }

        for (char c : message.toCharArray()){
            result += ( c != ' ' ? keyMapping[c - 'a'] : c );
        }
        return result;
    }


    public static String decodeMessage1(String key, String message) {
        String result = "";
        if( !(26 <= key.length() && key.length() <= 2000) || !(1 <= message.length() && message.length() <= 2000)){
            return result;
        }

        // Create keyList
        ArrayList<Character> alphabets = new ArrayList<Character>();

        for(char c : new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}){
            alphabets.add(c);
        }

        Hashtable<Character, Character> keyMap = new Hashtable<Character, Character>();

        for(int i = 0 ; alphabets.size() != 0 ; i++){
            if (!keyMap.containsKey(key.charAt(i))){
                System.out.println("Loading " + key.charAt(i));
                if (((int)'a' <= (int)key.charAt(i)) && ((int)key.charAt(i) <= (int)'z')) {
                    System.out.println(key.charAt(i) + " => " + alphabets.get(0));
                    keyMap.put(key.charAt(i), alphabets.remove(0));
                } else {
                    System.out.println(key.charAt(i) + " => " + key.charAt(i));
                    keyMap.put(key.charAt(i), key.charAt(i));
                }
            } else {
                System.out.println("Exists " + key.charAt(i) + " - " + keyMap.containsKey(key.charAt(i)));
            }
            Stream.of(alphabets).forEach( System.out::println);
        }

        for (char c : message.toCharArray()){
            result += (keyMap.containsKey(c) ? keyMap.get(c) : c);
        }
        return result;
    }
}
