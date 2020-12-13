package easy;
/*88. 合并两个有序数组
给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。

说明:
初始化nums1 和 nums2 的元素数量分别为m 和 n 。
你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。

示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出:[1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class MergeSortedArray {
    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        int i,j,k;

        //for (i=0;i<m;i++)
        //    temp[i] = nums1[i];
        System.arraycopy(nums1, 0, temp, 0, m);

        i=0;j=0;k=0;
        while (j<m && k<n) {
            if (temp[j]<=nums2[k])
                nums1[i++] = temp[j++];
            else
                nums1[i++] = nums2[k++];
        }
        if (j<m)
            while (j<m)
                nums1[i++] = temp[j++];
        else
            while (k<n)
                nums1[i++] = nums2[k++];
    }*/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0)
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];

        while (n >= 0)
            nums1[p--] = nums2[n--];
    }
}
