// Time complexity: O(nlogn) where n is the length of string str
// Space complexity: O(1)
// Run on leetcode: yes
// Issues faced: none

class Solution {
    public String customSortString(String order, String str) {
        Map<Character, Integer> map = new HashMap<>();
        Character[] res = new Character[str.length()];
        for(int i=0; i<order.length(); i++){
            Character c = order.charAt(i);
            map.put(c, i);
        }
        for(int i=0; i<str.length(); i++){
            res[i] = str.charAt(i);
        }
        Arrays.sort(res, new Comparator<Character>(){
            public int compare(Character a, Character b){
                if(map.containsKey(a) && map.containsKey(b))
                    return Integer.compare(map.get(a), map.get(b));
                else if(map.containsKey(a) && !map.containsKey(b))
                    return -1;
                else if(!map.containsKey(a) && map.containsKey(b))
                    return 1;
                else
                    return 0;
            }
        });
        StringBuilder s = new StringBuilder();
        for(int i=0; i<res.length; i++)
            s.append(res[i]);
        return s.toString();
    }
}

// Time complexity: O(m+n)
// Space complexity: O(1)
// Run on leetcode: yes
// Issues faced: None

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                for(int i=0; i<map.get(c); i++)
                    sb.append(c);
                map.remove(c);
            }
        }
        
        for(char c: map.keySet()){
            for(int i=0; i<map.get(c); i++)
                sb.append(c);
        }
        
        return sb.toString();
    }
}
