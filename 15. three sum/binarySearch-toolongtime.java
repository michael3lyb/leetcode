import java.util.Arrays;
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int k=0;
        int N = nums.length;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (N<3) return result;
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i < N; i++) {
            for (int j=i+1; j < N; j++) {
                k = Arrays.binarySearch(nums, -(nums[i] + nums[j]));
                if (k>i && k>j) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }
            }
        }
        return result;
        
    }
}