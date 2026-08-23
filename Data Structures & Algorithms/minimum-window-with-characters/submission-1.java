class Solution {
    public String minWindow(String s, String t) {
        int n=s.length(),m=t.length();
        int minLen=Integer.MAX_VALUE;
        int matchedCount=0;
        int startIdx=-1;
        int l=0,r=0;

        Map<Character,Integer>map=new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        while(r<n){
            char curr=s.charAt(r);

            if(map.getOrDefault(curr,0)>0){
                matchedCount++;
            }
            map.put(curr,map.getOrDefault(curr,0)-1);

            while(matchedCount==m){
                if(r-l+1 <minLen){
                    minLen=r-l+1;
                    startIdx=l;
                }

                char leftChar=s.charAt(l);
                map.put(leftChar,map.getOrDefault(leftChar,0)+1);

                if(map.get(leftChar)>0){
                    matchedCount--;
                }
                l++;
            }
            r++;
        }
        return (startIdx==-1 )? "" : s.substring(startIdx,startIdx+minLen);
    }
}
