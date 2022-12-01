class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
for(int i=0; i<order.length(); ++i) {
map.put(order.charAt(i), i);
}
Character[] sArr = new Character[s.length()];
for(int i=0; i<s.length(); ++i) {
    sArr[i] = s.charAt(i);
}
Arrays. sort(sArr, (c1, c2) -> {
return map.getOrDefault(c1, order.length()) - map.getOrDefault(c2, order.length());});
StringBuilder ans = new StringBuilder();
for(int i=0; i<s.length(); ++i) {
ans.append(sArr[i]);}

return ans.toString();
    }
}



//tc=O(m+n)
//sc=O(m+n)
