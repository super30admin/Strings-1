//T.C: O(N*N)
//S.C:O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        int length=needle.length();
        int result=-1;
        if(needle.isEmpty()){
            return 0;
        }
        for(int i=0;i<=haystack.length()-length;i++){
            if((haystack.substring(i,i+length)).equals(needle)){
                result= i;
                break;
            }else{
                result= -1;
            }

        }
        return result;
    }
}