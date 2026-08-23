class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res=0,l=0,r=people.length-1;
        while(l<=r){
            res++;
            int rem=limit-people[r--];
            if(l<=r && rem>=people[l]){
            
                l++;
            }
        }
        return res;
    }
}