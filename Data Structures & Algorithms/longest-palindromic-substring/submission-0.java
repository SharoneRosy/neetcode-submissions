class Solution {
    public String longestPalindrome(String s) {
        if(s=="" || s.length()<1) return "";
        int reslen=0,residx=0;
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int first=pali(s,i,i);
            int second=pali(s,i,i+1);
            reslen=Math.max(first,second);
            if(reslen>end-start+1){
                start=i-(reslen-1)/2;
                end=i+reslen/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int pali(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
