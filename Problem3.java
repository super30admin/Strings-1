public class Problem3 {
    //TC=O(n)
    //SC=O(1)
    public int lengthOfLongestSubstringMap(String s) {
        int addIndex=0, slow=0, maxSize=0;
        HashMap<Character,Integer> stringMap=new HashMap<>();
        while(addIndex<s.length()){
            char c=s.charAt(addIndex);
            if(stringMap.containsKey(c)){
                slow=Math.max(slow, stringMap.get(c)+1);
            }
            stringMap.put(c,addIndex);
            maxSize=Math.max(maxSize, addIndex-slow+1);
            addIndex++;
        }
        return maxSize;
    }

    //TC=O(2n)
    //SC=O(1)
    public int lengthOfLongestSubstringSet(String s) {
        int addIndex=0, slow=0, maxSize=0;
        HashSet<Character> stringSet=new HashSet<>();
        while(addIndex<s.length()){
            char c=s.charAt(addIndex);
            if(stringSet.contains(c)){
                while(s.charAt(slow)!=c){
                    stringSet.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            stringSet.add(c);
            maxSize=Math.max(maxSize, addIndex-slow+1);
            addIndex++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        Problem3 problem=new Problem3();
        System.out.println(problem.lengthOfLongestSubstringMap("abcabcbb"));
        System.out.println(problem.lengthOfLongestSubstringSet("abcabcbb"));
    }
}
