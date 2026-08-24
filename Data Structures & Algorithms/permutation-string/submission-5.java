class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int []s1count=new int[26];
        int []s2count=new int[26];

        for(int i=0;i<s1.length();i++){
            s1count[s1.charAt(i)-'a']++;
        }

        int l=0,r=0;
        while(r<s2.length()){
            s2count[s2.charAt(r)-'a']++;
            if(r-l+1==s1.length()){
                if(matches(s1count,s2count)){
                    return true;
                }
                s2count[s2.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return false;
    }

    private boolean matches(int[] s1, int[] s2){
        for(int i=0;i<26;i++){
            if(s1[i]!=s2[i]){
                return false;
            }
        }
        return true;
    }
}
