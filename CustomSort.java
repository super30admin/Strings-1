class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb= new StringBuilder();
        HashSet<Character> set= new HashSet<>();
        int arr[]=new int[26];
        for(char i: order.toCharArray()){
            set.add(i);
        }
        for(char j: s.toCharArray()){
            if(!set.contains(j)){
                sb.append(j);
            }
            else{
                arr[j-'a']++;
            }
        }
        for(char c: order.toCharArray()){
            int i=arr[c-'a'];
            while(i>0){
                sb.append(c);
                i--;
            }
        }
        return sb.toString();
    }
}