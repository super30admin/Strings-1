// Time complexity - O(n)
// Space complexity - O(1)
// solved on leetcode - yes
// faced any issues - no
// Create a HashMap to store teh frequency of elements then iterate through the order and get the elements in the hashmap based on the order of elements and append it to the result and then finally add all the remaining elements in the hashamp
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(char c:s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c,0);
            }
            map.put(c, map.get(c)+1);
        }

        for(char c: order.toCharArray()) {
            int occurances = map.containsKey(c) ? map.get(c) : 0;
            for(int k=0;k<occurances;k++) {
                result.append(c);
            }
            map.remove(c);
        }

        for(char c: map.keySet()){
            int occurances = map.get(c);
            for(int k=0;k<occurances;k++) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
