package medium;
/*31. 下一个排列
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。

示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]

示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]

示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]

示例 4：
输入：nums = [1]
输出：[1]

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i, j, temp;

        for (i=nums.length-2;i>=0;i--)
            if (nums[i] < nums[i+1]) {
                temp = nums[i];
                for (j=nums.length-1;j>=0;j--)
                    if (nums[j] > temp)
                        break;

                nums[i] = nums[j];
                nums[j] = temp;

                break;
            }

        i++;
        j = nums.length-1;
        while (i<j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}
