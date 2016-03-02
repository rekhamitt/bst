package com.bst;

import com.google.common.collect.ArrayListMultimap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rekhamittal on 2/29/16.
 */
public class Anagram {
    public static String[] args = {"REKHA", "ANURA", "HARKE", "RUNAA", "SENDO", "ASTOE", "BESTO", "CREED"};
    public  static ArrayListMultimap<String, String> getAnagramList() {
        Map<Node, String> dictionary = new HashMap<>();
        ArrayListMultimap<String, String> anagramList = ArrayListMultimap.create();
        int i = 0;
        while (i<args.length){
            String newWord = args[i];
            char[] strChar = newWord.toCharArray();
            Integer[] intArr = new Integer[256];
            Node node = new Node(intArr);
            for(int k=0; k<256; k++) {
                intArr[k]=0;
            }
            for(int j=0; j<strChar.length; j++ ) {
                Character ch = strChar[j];
                Integer chInt = Character.getNumericValue(ch);
                int count = intArr[chInt];
                intArr[chInt]= ++count;
            }
            if(dictionary.containsKey(node)) {
                String prevWord = dictionary.get(node);
                anagramList.put(prevWord, newWord);
            } else {
                dictionary.put(node, newWord);
            }
            i++;
        }
        return anagramList;
    }

    public static class Node {
        Integer[] intArray;

        public Node(Integer[] intArray) {
            this.intArray = intArray;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(intArray);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(intArray, node.intArray);

        }
    }

    public static void main(String [] args) {

        System.out.println(Anagram.getAnagramList().toString());
    }
}
