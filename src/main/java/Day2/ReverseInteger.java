package Day2;

/*
 ** @author LiGuanda
 ** @date  PM 6:14:38
 ** @description This is a description of ReverseInteger
 ** @params
 ** @return
 ** @since version-1.0  */


/**
 * @author Lenovo
 */

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

//如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

//假设环境不允许存储 64 位整数（有符号或无符号）


public class ReverseInteger {


    public static void main(String[] args) {

        int initialNum = -1234567898;
        int reversedNum = reverse(initialNum);
        System.out.println("The num reversed from " + initialNum + " is " + reversedNum);
        int initialNumPro = 123456789;
        int reversedNumPro = reversePro(initialNumPro);
        System.out.println("The num reversed from " + initialNumPro + " is " + reversedNumPro);

    }


    public static int reverse(int x) {

        // 记录输入数值的正负性
        boolean isNegative = false;
        // 考虑传入的数值<0的情况，取其绝对值
        if (x < 0) {

            x = -x;
            isNegative = true;

        }
        // 将输入的数值转换为StringBuilder后进行反转
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        String reversedStr = builder.reverse().toString();


        int reversedNum;
        try {

            // 解析反转后的字符串为数值
            reversedNum = Integer.parseInt(reversedStr);
            // 如果范围合法，则根据输入数值的正负性确定最后反转的数值的正负性并予以返回
            return isNegative ? -reversedNum : reversedNum;

        } catch (NumberFormatException numberFormatException) {

            // 即使字符串内容符合数值定义，但如果超出指定数值类型的范围，同样会抛异常
            System.err.println("超出Int类型范围！");
            return 0;

        }



/*        // 定义一个栈，用于存放取模出来的单个数
        Stack<Integer> stack = new Stack<>();
        // 用于拼接从栈出来的数
        StringBuilder builder = new StringBuilder();
        // 获取原始数的位数，便于控制在栈中的操作次数
        int length = String.valueOf(x).length();

        // 表明传入数值的正负性
        boolean isNegative = false;
        // 用于作为当前次的被操作数
        int remainder = x;

        // 处理传入的数值为负数的情况
        if (x < 0) {

            isNegative = true;
            remainder = -x;

        }


        // 循环取余取模和入栈
        for (int i = 0; i < length; i++) {

            int mod = (int) (x / (Math.pow(10, length - 1 - i)));
            remainder = (int) (remainder % (Math.pow(10, length - 1 - i)));
            stack.push(mod);

        }
        // 循环出栈
        for (int i = 0; i < length; i++) {

            builder.append(i);

        }
        //转换为int整数
        int reversedNum = Integer.parseInt(builder.toString());

        // 判断其绝对值是否超过最大整数值，若超过，则返回0，否则返回反转后的数值
        if (reversedNum > Integer.MAX_VALUE) {

            return 0;

        } else {

            return isNegative ? -reversedNum : reversedNum;

        }*/


    }


    public static int reversePro(int x) {

        // 记录模数与余数
        int mod;
        int remainder = x;
        // 记录一步步反转添加后的数值
        int reversedNum = 0;
        while (remainder != 0) {

            mod = remainder % 10;
            // 判断其数除去最右位的左侧数值是否>MAX_INTEGER或<-MAX_INTEGER
            if ((Math.abs(reversedNum)) > (Integer.MAX_VALUE / 10)) {

                System.err.println("超出Int类型范围！");
                return 0;

            }
            // *10是为了使上轮产生的翻转数的位数统一向左移动一位，空出一位用于存储新mod出来的数
            reversedNum = reversedNum * 10 + mod;


            // 本次循环过后，x向左剪掉一位
            remainder /= 10;

        }

        return reversedNum;


    }


}
