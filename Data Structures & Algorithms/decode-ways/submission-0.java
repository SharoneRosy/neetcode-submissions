class Solution {
    private int solve(int i,String s){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        int res=solve(i+1,s);
        if(i<s.length()-1){
            if(s.charAt(i)=='1' ||
               (s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                res+=solve(i+2,s);
               }
        }
        return res;
    }
    public int numDecodings(String s) {
        return solve(0,s);
    }
}
