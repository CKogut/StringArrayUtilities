package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        int last = array.length - 1;
        return array[last];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        int last = array.length - 2;
        return array[last];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean outcome = false;
        for (int i=0; i< array.length; i++) {
            outcome = array[i].equals(value);
            if (outcome == true){break;}
        }
        return outcome;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        //create new array
        String[] reverse = new String[array.length];

        //loop through original array
        for(int i = 0; i < array.length; i++){
            //get the inverse position of array[i]
            reverse[array.length-1-i] = array[i];
        }
        return reverse;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] reverse = new String[array.length];

        for (int i=0; i< array.length; i++){
            reverse[array.length-1-i] = array[i];
        }
        return Arrays.equals(array,reverse);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

    int count = 0;
    String combined = "";

        //combine array into one string
        for (int i=0; i<array.length; i++) {
            //swap to lowercase
            String word = array[i].toLowerCase();
            combined = combined + word;
        }

        //loop through the ascii values of lowercase a-z
        for (int i = 97; i<=122; i++){
            char letter = (char) i;
            //change the char to string to use the contains methods
            String str = "" + letter;
            if(combined.contains(str)){
                //increment counter if the letter is present
                count++;
            }
        }

        //if count is 26 all letters present
        return count == 26;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;

        for (int i=0; i<array.length; i++){
            String word = array[i];
            if (word.equals(value)){
                count++;
            }
        }

        return count;

    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
       String[] removed = new String[array.length-1];
       int nextIndex = 0;

       for (int i=0; i< array.length; i++){
           if (!array[i].equals(valueToRemove)){
               removed[nextIndex] = array[i];
               nextIndex++;
           }
       }

       return removed;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        //create a list to take advantage of dynamic size
        List<String> noDups = new ArrayList<>();

        //loop through input array
        for (int i=0; i< array.length-1; i++){
            //determine the two words to compare, i.e. current and next word
            String first = array[i];
            String second = array[i+1];

            //always add the first word
            if (i==0){
                noDups.add(first);
            }

            //if they don't match, add next word. Otherwise, no action needed.
            if (!first.equals(second)){
                noDups.add(second);
            }
        }

        //convert list back to array for return purposes
        String[] result = noDups.toArray(new String[0]);

        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        //create a list to take advantage of dynamic size
        List<String> dups = new ArrayList<>();
        //create new StringBuilder to gather duplicates
        StringBuilder currentChars = new StringBuilder();


        //loop through array
        for (int i=0; i < array.length-1; i++){
            //determine the two words to compare, i.e. current and next word
            String first = array[i];
            String second = array[i+1];

            //always add the first character
            if (i==0){
                currentChars.append(first);
            }

            //if first letter matches second letter, add NEXT letter to currentChars
            if (first.equals(second)){
                currentChars.append(second);
            } else {
                dups.add(currentChars.toString());
                currentChars.setLength(0);
                currentChars.append(second);
            }
        }

        //System.out.println(currentChars);
        System.out.println(dups);

        String[] result = dups.toArray(new String[0]);

        return result;
    }


}
