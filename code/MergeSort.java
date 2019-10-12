/**
 * @author jiayk
 * @date 2019/10/12
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）88
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 */
public class MergeSort {
    public static void main(String[] args){
        int[] a ={1,2,3,0,0,0};
        int[] b = {2,5,6};
        int m = 3;
        int n = 3;
        merge(a,b,m,n);
        System.out.print(printArray(a));
    }

    //  双指针  从后向前
    public static void merge(int[] nums1,int[] nums2,int m,int n){
         int p1 = m - 1;
         int p2 = n - 1;
         int p = m + n - 1 ;

         while (p1 >= 0 && p2 >= 0){
             nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
         }

        System.arraycopy(nums2,0, nums1, 0, p2 + 1);
    }

    //  双指针  从前向后  需要额外空间，从头改变nums1的值，需要把num1的元素放到其他位置
    public static void merge1(int[] nums1,int[] nums2,int m,int n){
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0 ,nums1_copy , 0 , m);
        int p1 = 0;
        int p2 = 0;

        int p = 0;

        while (p1 < m && p2 < n){
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }

        if (p1 < m){
            System.arraycopy(nums1_copy, p1 , nums1, p1 + n, m - p1);
        }

        if (p2 < n){
            System.arraycopy(nums2, p2 , nums1, p2 + m, n - p2);
        }
    }

    public static void merge2(int[] nums1,int[] nums2,int m,int n){
        System.arraycopy(nums2, 0 ,nums1, m , n);
        Arrays.sort(nums1);
    }

    public static void merge3(int[] nums1,int[] nums2,int m,int n){
        for(int i=m + n - 1; i>=0 ; i--){
            if(m>0 && n>0){
                if(nums1[m-1]>nums2[n-1]){
                    nums1[i] = nums1[m-1];
                    m --;
                }else{
                    nums1[i] = nums2[n-1];
                    n --;
                }
            }else if(m<=0){
                nums1[i] = nums2[n-1];
                n --;
            }else if(n<=0){
                nums1[i] = nums1[m-1];
                m --;
            }
        }
    }

    public static String printArray(int[] a){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i == 0){
              sb.append("[" + a[i]);
            }else if (i == a.length - 1){
                sb.append("," + a[i] + "]");
            }else {
                sb.append("," + a[i]);
            }
        }
        return sb.toString();
    }
}
