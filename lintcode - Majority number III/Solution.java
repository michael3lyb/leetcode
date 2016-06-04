public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
       hash = {}
       for (int i = 0; i < nums.size(); i++) {
       	if (nums.get(i) in hash) {
       		hash[nums.get(i)]++；
       	} else if (hash.size() < k - 1) {
       		hash[nums[i]] = 1; 
       	} else {
       		for (key in hash.keys()) {
       			hash[key] --;
       			if (hash[key] == 0) {
       				del hash[key];
       			}
       		}
       	}
       }
    }
}
