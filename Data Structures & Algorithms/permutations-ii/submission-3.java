class Solution {
    public void solve(int ind, int[] arr, List<List<Integer>> ans) {
        if (ind == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int v : arr) list.add(v);
            ans.add(list);
            return;
        }

        HashSet<Integer> used = new HashSet<>();
        for (int i = ind; i < arr.length; i++) {
            if (used.contains(arr[i])) continue;  // skip duplicate value at this recursion level
            used.add(arr[i]);

            swap(i, ind, arr);
            solve(ind + 1, arr, ans);
            swap(i, ind, arr);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);       // sorting is optional with the HashSet approach but fine to keep
        solve(0, nums, ans);
        return ans;
    }
}
