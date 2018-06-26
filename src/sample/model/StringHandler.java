package sample.model;

import java.util.ArrayList;
import java.util.List;

public class StringHandler {

    /** Returns the first word of a String */
    public static String getFirstWord(String s){
        int firstIndexOfSpace = StringHandler.getFirstIndexOfChar(' ', s);

        if (firstIndexOfSpace == -1)
            return s;
        else
            return s.substring(0, firstIndexOfSpace);
    }

    /** Returns the index of first occurring character equal to argument c */
    public static int getFirstIndexOfChar(char c, String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c)
                return i;
        }
        return -1;
    }

    public static List<String> getStringsBetweenChar(char c, String s){
        List<String> strings = new ArrayList<>();
        String temp;
        boolean done = false; // When true all strings have been found

        while(!done) {
            try {
                temp = s; // Get remaining string
                temp = temp.substring(getFirstIndexOfChar(c, temp) + 1); // Find first occurrence of char c
                s = temp.substring(getFirstIndexOfChar(c, temp) + 1); // Store remaining string after second occurrence of char c
                temp = temp.substring(0, getFirstIndexOfChar(c, temp)); // Find second occurrence of char c
                strings.add(temp);
            }
            catch (Exception e){
                done = true;
            }
        }

        return strings;
    }
}
