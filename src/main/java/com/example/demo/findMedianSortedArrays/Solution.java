package com.example.demo.findMedianSortedArrays;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
// Related Topics 数组 二分查找 分治算法
// 👍 3288 👎 0


@Slf4j
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int a;
        int b;
        if (nums1.length < 1) {
            return getMedian(nums2);
        }
        if (nums2.length < 1) {
            return getMedian(nums1);
        }
        int s1 = nums1.length;
        int s2 = nums2.length;
        int s3 = s1 + s2;
        s3 = s3 % 2 == 0 ? s3 / 2 + 1 : (s3 + 1) / 2;
        int[] nums3 = new int[s3];

        int i = 0;
        int j = 0;
        for (int k = 0; k < s3; k++) {
            if (i >= nums1.length) {
                b = nums2[j];
                nums3[k] = b;
                j++;
                continue;
            }
            if (j >= nums2.length) {
                a = nums1[i];
                nums3[k] = a;
                i++;
                continue;
            }
            a = nums1[i];
            b = nums2[j];
            if (a < b) {
                nums3[k] = a;
                i++;
            } else {
                nums3[k] = b;
                j++;
            }
        }
        return (s1 + s2) % 2 == 0 ? ((double) (nums3[s3 - 1] + nums3[s3 - 2])) / 2 : nums3[s3 - 1];
    }


    private double getMedian(int[] i) {

        return i.length % 2 == 0 ? ((double)(i[i.length / 2] + i[i.length / 2 - 1])) / 2 : i[(i.length - 1) / 2];
    }


    public static void main(String[] args) {

        Assert.isTrue(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2, "");
        Assert.isTrue(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}) == 2.5, "");
        Assert.isTrue(new Solution().findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}) == 0, "");
        Assert.isTrue(new Solution().findMedianSortedArrays(new int[]{}, new int[]{1}) == 1, "");
        Assert.isTrue(new Solution().findMedianSortedArrays(new int[]{2}, new int[]{}) == 2, "");
    }
}
