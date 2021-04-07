//TC: O(n+m)
//SC: O(n) n--> no of chars in String T
class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        if(T.length()==0)
            return sb.toString();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<T.length();i++)
            map.put(T.charAt(i),map.getOrDefault(T.charAt(i),0)+1);
        for(int i=0;i<S.length();i++)
        {
            if(map.containsKey(S.charAt(i)))
            {
                int n = map.get(S.charAt(i));
                while(n>0)
                {
                    sb.append(S.charAt(i));	//So, given string T should be sorted so that it follows the order of non-recurring string S
                    n--;					//Storing all the unique characters of T in a hashmap with the count of occurance.
                }							//Now traversing through S and if the charcter is available in map of T, get the occurance of the character
                map.remove(S.charAt(i));	//Add the character to output string occurance times. Repeate the same untill S is completed.
            }								//Now check if any characters in string T is not covered, if so append the rest of chars to string.
        }
        for(int i=0;i<T.length();i++)
        {
            if(map.containsKey(T.charAt(i)))
            {
                int n = map.get(T.charAt(i));
                while(n>0)
                {
                    sb.append(T.charAt(i));
                    n--;
                }
            }
            map.remove(T.charAt(i));
        }
        return sb.toString();
    }   
}