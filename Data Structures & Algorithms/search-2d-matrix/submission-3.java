class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int low=0;
        int high=rows*cols-1;
        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/cols,col=mid%cols;
            if(target>matrix[row][col]){
                low=mid+1;
            }else if(target<matrix[row][col]){
                high=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
