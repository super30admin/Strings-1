// 791.
// time - O(m + n) -> m is length of S and n is length of T
// space - O(n) -> for the frequency map
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for(int i = 0; i < T.length(); i++)
        {
            //populate the counts map with frequency of each character in string T
            counts.put(T.charAt(i), counts.getOrDefault(T.charAt(i), 0) + 1);
        }
        
        StringBuilder result = new StringBuilder();
        //iterate through S, get the counts of each char, append that char into result for count times
        //remove that char from map
        for(int i = 0; i < S.length(); i++)
        {
            Integer frequency = counts.get(S.charAt(i));
            while(frequency != null && frequency > 0)
            {
                result.append(S.charAt(i));
                frequency--;
            }
            counts.remove(S.charAt(i));
        }
        //iterate through remaining keys in map and append each key into result for count times
        for(Character ch : counts.keySet())
        {
            int frequency = counts.get(ch);
            while(frequency > 0)
            {
                result.append(ch);
                frequency--;
            }
        }
        return result.toString();
    }
}
