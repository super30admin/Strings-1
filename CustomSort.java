//Time complexity is O(m+n+k) m is length of given string s, n is length of order, k is length of unique characters that are not in order and present string s
//Space complexity is O(m)
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, String> map =new HashMap<Character, String>();
        for(Character ch: s.toCharArray()){
            String str = map.getOrDefault(ch, "");
            map.put(ch, str+ch);
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch: order.toCharArray()){
            sb.append(map.getOrDefault(ch, ""));
            map.remove(ch);
        }
        for(Character ch : map.keySet()){
            sb.append(map.getOrDefault(ch, ""));
        }
        return new String(sb);
    }
}