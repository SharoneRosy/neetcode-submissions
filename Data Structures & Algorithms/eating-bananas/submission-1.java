class Solution {
    public int NoOfHours(int [] piles,int mid){
        int n=0;
        for(int i=0;i<piles.length;i++){
            n+=Math.ceil((double)piles[i]/mid);
        }
        return n;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int hours=NoOfHours(piles,mid);
            if(hours<=h){
                ans=mid;
                high=mid-1;
            }else{
                 low=mid+1;
            }
        }
        return ans;
    }
}
