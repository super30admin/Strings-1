//time o(n)
//space o(1) since max 26 characters are present in the map
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<T.length();i++) {
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        //iterate over S
        for(int i=0;i<S.length();i++) {
            char ch = S.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                while(count>0)
                {
                    sb.append(ch);
                    count--;
                }
            }
            map.remove(ch);
        }
        
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            char ch = entry.getKey();
            int count = entry.getValue();
            while(count>0)
                {
                    sb.append(ch);
                    count--;
                }
        }
        return sb.toString();
    }
}