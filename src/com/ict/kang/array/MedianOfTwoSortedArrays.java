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

        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0 && n == 0) {
            return 0.0;
        }
        if (m == 0) {
            return n % 2 == 0 ? (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0 : nums2[(n + 1) / 2 - 1];
        }

        if ((m + n) % 2 == 0) {
            if (nums1[m - 1] <= nums2[0]) {
                if (m == n) {
                    return (nums1[m - 1] + nums2[0]) / 2.0;
                } else {
                    return (nums2[(m + n) / 2 - m - 1] + nums2[(m + n) / 2 - m]) / 2.0;
                }
            } else if (nums1[0] >= nums2[(m + n + 1) / 2]) {
                if (m == n) {
                    return (nums1[0] + nums2[(m + n + 1) / 2]) / 2.0;
                } else {
                    return (nums2[(m + n) / 2 - 1] + nums2[(m + n) / 2]) / 2.0;
                }
            }
        } else {
            if (nums1[m - 1] <= nums2[0]) {
                return nums2[(m + n + 1) / 2 - m - 1];
            } else if (nums1[0] >= nums2[n - 1]) {
                return nums2[(m + n + 1) / 2 - 1];
            }
        }

        if (m == 1) {
            if ((m + n) % 2 == 0) {
                int middle = (m + n) / 2 - 1;
                if (nums2[middle] > nums1[0]) {
                    if (middle - 1 >= 0) {
                        return (nums2[middle] + Math.max(nums2[middle - 1], nums1[0])) / 2.0;
                    } else {
                        return (nums2[middle] + nums1[0]) / 2.0;
                    }
                } else {
                    if (middle + 1 < n) {
                        return (nums2[middle] + Math.min(nums2[middle + 1], nums1[0])) / 2.0;
                    } else {
                        return (nums2[middle] + nums1[0]) / 2.0;
                    }
                }
            } else {
                int middle = (m + n + 1) / 2 - 1;
                if (nums2[middle] > nums1[0]) {
                    return Math.max(nums2[middle - 1], nums1[0]);
                } else {
                    return Math.min(nums2[middle], nums1[0]);
                }
            }
        }

        //System.out.println(m + " " + n);
        int left = 0;
        int right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            System.out.println(i + "-" + j);
            if ((j == 0 || i == m || nums1[i] >= nums2[j - 1])
                && (i == 0 || j == n || nums1[i - 1] <= nums2[j])) {
                if ((m + n) % 2 == 0) {
                    int L;
                    int R;
                    if (i == 0) {
                        L = nums2[j - 1];
                    } else if (j == 0) {
                        L = nums1[i - 1];
                    } else {
                        L = Math.max(nums1[i - 1], nums2[j - 1]);
                    }

                    if (i == m) {
                        R = nums2[j];
                    } else if (j == n) {
                        R = nums1[i];
                    } else {
                        R = Math.min(nums1[i], nums2[j]);
                    }
                    return (L + R) / 2.0;
                } else {
                    return Math.max(nums1[i - 1], nums2[j - 1]);
                }
            } else if (nums1[i] < nums2[j - 1]) {
                left = i + 1;
            } else if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            }
        }
        return 0.0;
    }
}
