class Solution{
  public String customSortString(String order, String s){
    if(order == null || order.length() == 0) return s;
    if(s == null || s.length() == 0) return null;

    HashMap<Character, Integer> map = new HashMap<>();
    char[] cArr = s.toCharArray();
    for(char c : cArr){
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < order.length(); i++){
      char o = order.charAt(i);
      if(map.containsKey(o)){
        int count = map.get(o);
        while(count > 0){
          sb.append(o);
          count--;
        }
        map.remove(o);
      }
    }
    if(!map.isEmpty()){
      for(char key : map.keySet()){
        int count = map.get(key);
        while(count > 0){
          sb.append(key);
          count--;
        }
      }
    }
    return sb.toString();
  }
}
