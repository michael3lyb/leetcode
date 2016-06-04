import java.util.Arrays;
public class Solution1 {
	public static int get(int num, int index)
	{
	    return (num & (0x1 << index)) >> index;
	}

    public static int[] singleNumber(int[] nums) {
    	int i = 0;
    	int mid = 0;
    	for (i = 0; i < nums.length; i++) {
    		mid = nums[i] ^ mid;	
    	}

    	int mask = mid & ~(mid -1);  //得到第一个是1的mask
    	System.out.println(Integer.toBinaryString(mask));
    	int A = 0;
    	int B = 0;
    	for (int j = 0; j < nums.length; j++) {

    		if ((mask & nums[j]) != 0) {
    			System.out.println("A:"+nums[j]);
    			A = nums[j] ^ A;	
    		}
    		else {
    			System.out.println("B:"+nums[j]);
    			B = nums[j] ^ B;
    		}
    	}
    	int[] result = {A, B};
    	return result;
    }
    public static void main(String[] args) {
    	int[] input = {1,2,1,3,5,2};
    	int [] result = singleNumber(input);
    	System.out.println(Arrays.toString(result));
    }

}