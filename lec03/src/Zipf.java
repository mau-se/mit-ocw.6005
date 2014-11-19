import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Zipf {

    /**
     * Find the most common word in a string of text.
     * @param s string of words, where a word is 
     *   a string of characters separated by spaces
     *   or punctuation.
     * @return word that occurs most often in s (at least as much
     *      as any other word); alphabetic case is ignored.
     * @throws NoWordException when s has no words
     */
    public static String mostCommonWord(String s) 
            throws NoWordsException {
        String[] checkForWords = s.split("([.,!?:;'\"-]|\\s)+");
    	
    	if(checkForWords.length == 0 || s.isEmpty()) {
    		throw new NoWordsException ();
    	}
    	
        return findMax(countOccurrences(splitIntoWords(s)));
    }
    
    // To implement mostCommonWord, we'll use three helper methods:
    //   - splitIntoWords splits the string into words
    //   - countOccurrences counts how many times each word appears
    //   - findMax finds the word with the highest count
    
    // Let's write the specs for these helper methods.
    
    // Split s into words.
    // @param s string to split into words
    // @return list of words found in s, in order of their occurrence
    //  (as defined by the spec for mostCommonWords), and converted
    //  to lowercase.  e.g.
    //   splitIntoWords("a B Cc b") returns ["a", "b", "cc", "b"].
    private static List<String> splitIntoWords(String s) {
        List<String> listOfWords = new ArrayList<String>();
        String[] ArrayOfWords = s.split("([.,!?:;'\"-]|\\s)+");
        for(String word: ArrayOfWords) {
        	String lowerCase = word.toLowerCase();
        	listOfWords.add(lowerCase);
        }
        
        return listOfWords;
    }
    
    // Count the number of occurrences of each element in a list.
    // @param l list of strings
    // @return map m such that m[s] == k if s occurs k times in l, while
    //      m[s] == null if s never occurs in l.
    private static Map<String, Integer> countOccurrences(List<String> l) {
        Map<String, Integer> mappedList = new HashMap<String, Integer>();
        
        for(String s:l) {
        	Integer count = mappedList.get(s);
        	mappedList.put(s, (count == null) ? 1: count + 1);
        }
             
        return mappedList;
    }
    
    // Find a key with maximum value.
    // @param m frequency counts for strings
    // @return s such that m[s] >= m[t] for all other keys t in the map,
    //     or null if no such s exists
    private static String findMax(Map<String,Integer> m) {
    	int maxValue = 0;
    	String maxString = null;
    	
        for(String s: m.keySet()) {
        	if(m.get(s) > maxValue) {
        		maxValue = m.get(s);
        		maxString = s;
        	}
        }

        return maxString;
    }
    
    
    /**
     * Exception thrown by mostCommonWord() when it can't find a word.
     */
    public static class NoWordsException extends Exception {
        private static final long serialVersionUID = 1L;
    }
    
    public static void main(String args[]) throws NoWordsException {
    	String s = "One, two, three, one, one, two";
    	System.out.println( "Most common word is: " + Zipf.mostCommonWord(s));
    }
}
