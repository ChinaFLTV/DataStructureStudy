package Day4;

/*
 ** @author LiGuanda
 ** @date  PM 6:18:57
 ** @description This is a description of Palindrome
 ** @params
 ** @return
 ** @since version-1.0  */

/* 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

        例如，121 是回文，而 123 不是。*/

/**
 * @author Lenovo
 */
public class Palindrome {


    public static void main(String[] args) {

        int num = 1232;
        boolean flag = isPalindrome(num);
        System.out.println("The num " + num + (flag ? " is a palindrome num!" : " isn't a palindrome num!"));


    }


    public static boolean isPalindrome(int x) {

        // 若x为负数或为整数但其个位数上为0，则直接判定为非回文数，返回false
        if ((x < 0) || ((x > 0) && (x % 10 == 0))) {

            return false;

        }

        // 开始从左至右依次分离一个位上的数，直至到达该数的n/2位(偶数位)或(n+1)/2(奇数位)
        int reversedNum = 0;
        while (x > reversedNum) {

            // 重新组装一位一位反转后的数值
            reversedNum = reversedNum * 10 + x % 10;
            // 原数值拆解一位
            x /= 10;

        }

        // 分别考虑奇数位与偶数位分离后的不同情况，对对称位进行比较
        return (reversedNum == x) || (reversedNum / 10 == x);


    }


}
