// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder inter=new StringBuilder();
        char[] arr=T.toCharArray();
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        inter.append(new String(arr));
        //System.out.println(inter);
        StringBuilder result=new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(inter.indexOf(String.valueOf(S.charAt(i)))!=-1){
                while(inter.indexOf(String.valueOf(S.charAt(i)))!=-1){
                    result.append(S.charAt(i));
                    inter.deleteCharAt(inter.indexOf(String.valueOf(S.charAt(i))));
                }
            }
        }
        
        if(inter.length()==0){
           // System.out.println(result);
        }else{
            //System.out.println(result+","+inter);
            result.append(inter);
           // System.out.println(result);
        }
        
        return result.toString();
    }
}