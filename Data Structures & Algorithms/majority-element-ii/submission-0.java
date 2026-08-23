class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int e1=-1,e2=-1,cnt1=0,cnt2=0;
        for(int num:nums){
            if(num==e1) cnt1++;
            else if(num==e2) cnt2++;
            else if(cnt1==0) {
                cnt1=1;
                e1=num;
            }else if(cnt2==0){
                cnt2=1;
                e2=num;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=cnt2=0;
        for(int num:nums){
            if(num==e1) cnt1++;
            else if(num==e2) cnt2++;
        }
        List<Integer>res=new ArrayList<>();
        if(cnt1>n/3) res.add(e1);
        if(cnt2>n/3) res.add(e2);
        return res;
    }
}