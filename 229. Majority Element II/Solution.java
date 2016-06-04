import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == candidate1) {
                count1++;
            }   

            else if (nums[i] == candidate2) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
            }            
            else if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
            }                

            else {
                count1--;
                count2--;
            }
            //System.out.println(count1+" "+count2+" "+candidate1+" "+candidate2);
            //System.out.println();
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            }
            else if (nums[i] == candidate2) {
                count2++;
            }
        }
        System.out.println(candidate1);
        System.out.println(candidate2);
        List<Integer> result = new ArrayList<Integer>();
        if (count1 > (nums.length / 3)) {
            result.add(candidate1);
        }
        if (count2 > (nums.length / 3)) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,2,1,1,3};
        List<Integer> result = majorityElement(nums);
        System.out.println(result.toString());
    }
}

// [1,1,1,2,2,3,3,4]
// [2,2,1,1,1,3,3,4]
// [4,2,3,1,1,3,4,4]