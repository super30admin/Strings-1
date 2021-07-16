class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1), actually it should be the size of 26.
    public String customSortString(String order, String str) {
        int[] arr = new int[26];
        for (int i=0; i<str.length(); i++){
            int index = str.charAt(i) - 'a';
            arr[index] += 1;
        }
        String res = "";
        for (int i=0; i<order.length(); i++){
            int index = order.charAt(i) - 'a';
            for (int j=0; j<arr[index]; j++){
                res += order.charAt(i) + "";
            }
            arr[index] = 0;
        }
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i]; j++){
                res += (char)('a' + i);
            }
        }        
        return res;
    }
}