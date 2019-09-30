package com.ict.kang.array;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-04 10:18
 * @description :
 * @modified :
 */
public class MedianOfTwoSortedArrays {

    /**
     * @Date 2019-09-04 13:54
     * @Description 先将两个排序数组排序到一个新数组中 O(m+n)
     * @Return double
     **/
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m + n];
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[i + j] = nums1[i];
                i++;
            } else {
                nums3[i + j] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            nums3[i + j] = nums1[i];
            i++;
        }
        while (j < n) {
            nums3[i + j] = nums2[j];
            j++;
        }

        if ((m + n) % 2 == 0) {
            return (nums3[(m + n) / 2] + nums3[(m + n) / 2 - 1]) / 2.0;
        } else {
            return nums3[(m + n) / 2];
        }
    }

    /**
     * @Date 2019-09-04 13:55
     * @Description
     * @Return double
     **/

    // 不会写！！！ 需要注意的点有点多，我没捋过来
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1 == null ? 0 : nums1.length;
        int n = nums2 == null ? 0 : nums2.length;

        boolean isOdd = (m + n) % 2 == 0 ? false : true;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        m = nums1 == null ? 0 : nums1.length;
        n = nums2 == null ? 0 : nums2.length;

        if (m == 0 && n == 0) {
            return 0.00;
        }

        int left = 0, right = m - 1;
        while (left <= right) {
            int median = (left + right) / 2;
            int otherMedian = (m + n + 1) / 2 - (median + 1) - 1;
            if (nums1[median] <= nums2[otherMedian + 1] && nums2[otherMedian] <= nums1[median + 1]) {
                if (isOdd) {
                    return Math.max(nums1[median], nums2[otherMedian]);
                } else {
                    return (Math.max(nums1[median], nums2[otherMedian]) + Math
                        .min(nums1[median + 1], nums2[otherMedian + 1])) / 2.0;
                }
            } else if (nums1[median] > nums2[otherMedian + 1]) {
                right = median - 1;

            } else if (nums2[otherMedian] > nums1[median + 1]) {
                left = median + 1;
            }
        }

        if (left == 0) {
            return isOdd ? nums2[(m + n + 1) / 2 - 1]
                : (nums2[(m + n + 1) / 2 - 1] + nums2[(m + n + 1) / 2]) / 2.0;
        } else {
            return isOdd ? nums2[(m + n + 1) / 2 - m - 1]
                : (nums2[(m + n + 1) / 2 - m - 1] + nums2[(m + n + 1) / 2] - m) / 2.0;
        }
    }
}
