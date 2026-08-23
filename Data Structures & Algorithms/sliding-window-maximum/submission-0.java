class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int []res=new int[n-k+1];
        Deque<Integer>q=new LinkedList<>();
        int l=0,r=0;
        int t=0;
        while(r<n){
            while(!q.isEmpty() && nums[q.getLast()]<nums[r]){
                q.removeLast();
            }
            q.addLast(r);

            if(r-l+1==k){
                res[t++]=nums[q.peekFirst()];
                l++;
                if(q.peekFirst()<l){
                    q.pollFirst();
                }
            }
            if(r-l+1<k){
                r++;
            }
        }
        return res;
    }
}
