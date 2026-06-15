// Time complexity : O(m+n)
// Space Complexity : O(1) (since the map has at most 26 entries, constant-size alphabet).
// used freq map to solve it - 
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int t = map.get(c);
                for(int k =0;k<t;k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(char c: map.keySet())
        {
            int t = map.get(c);
            for(int k =0;k<t;k++){
                sb.append(c);
            }
            // map.remove(c);
        }
        return sb.toString();
    }
}

// Time complexity : O(nlogn)
// Space Complexity : O(n) 
// used custom sorting - 
/*
class Solution {
    public String customSortString(String order, String s) {
        int[] so = new int[26];
        for(int i=0; i<order.length();i++){
            so[order.charAt(i)-'a']=i;
        }

// cant use toCharArray() -> For a char[], Java only provides the natural sort - Arrays.sort(arr), no custom comparator 

        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr,(a,b)->so[a-'a']-so[b-'a']);

        StringBuilder sb = new StringBuilder(arr.length);
        for (Character c : arr) {
            sb.append(c.charValue());
        }

        return sb.toString();
    }
}*/