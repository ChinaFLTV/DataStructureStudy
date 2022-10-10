package Day6;

/*
 ** @author LiGuanda
 ** @date  PM 11:26:11
 ** @description This is a description of FindContainerOfMaxVolume
 ** @params
 ** @return
 ** @since version-1.0  */
/*
*
* 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。
*
* */


/**
 * @author Lenovo
 */
public class FindContainerOfMaxVolume {


    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height1 = {1, 1};
        int maxArea = maxArea(height1);
        System.out.println(maxArea);

    }


    public static int maxArea(int[] height) {


        // 考虑特殊情况，若长度<=1，则直接返回0
        if (height.length <= 1) {

            return 0;

        }


        // 设置两个“指针”便于进行容积大小遍历
        int i = 0;
        int j = height.length - 1;

        // 假设当前状态下的容积为最大值
        int max = (j - i) * (Math.min(height[i], height[j]));

        // 开始向中间靠拢，一步一步的寻找最大容积
        while (i < j) {

            // 比较当前两个指针所对应的高度大小，选择其中较小的进行向中间靠拢操作
            if (height[i] < height[j]) {

                i++;

            } else {

                j--;

            }

            // 将更新状态后的容积值与上一个最大容积进行 比较，更新最大值
            max = Math.max(max, (j - i) * (Math.min(height[i], height[j])));

        }

        return max;

    }


}
