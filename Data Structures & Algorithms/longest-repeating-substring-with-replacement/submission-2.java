class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int n=s.length();
        int max=0;
        int maxf=0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxf=Math.max(maxf,map.get(s.charAt(r)));
            while((r-l+1)-maxf>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}
