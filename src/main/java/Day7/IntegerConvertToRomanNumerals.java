package Day7;

/*
 ** @author LiGuanda
 ** @date  PM 10:05:40
 ** @description This is a description of IntegerConvertToRomanNumerals
 ** @params
 ** @return
 ** @since version-1.0  */

/*
* 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给你一个整数，将其转为罗马数字。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/integer-to-roman
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

/**
 * @author Lenovo
 */
public class IntegerConvertToRomanNumerals {


    public static void main(String[] args) {

        int num = 58;
        String romanNumerals = intToRoman(num);
        System.out.println("The roman numeral of " + num + " is " + romanNumerals);

    }


    public static String intToRoman(int num) {

        // 首先定义以下所有的罗马数字-->阿拉伯数字的所有原子型常量映射
        int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // 新建一个StringBuilder，用于拼接并存储罗马字符
        StringBuilder builder = new StringBuilder();

        // 开始由大数到小数逐个删减
        for (int i = 0; i < integers.length; ) {

            // 如果当前num状态已到达0界限，则标志着转换完成，跳出循环
            if (num <= 0) {

                break;

            }

            // 如果当前状态下的num已经不满足当前量级，则退化至下一个量级
            if (num - integers[i] < 0) {

                i++;
                continue;

            }

            // 若当前num状态依旧包含此量级，则进行该量级对应的罗马字符的追加
            builder.append(romanNumerals[i]);
            // 此时状态num减去当前的量级
            num -= integers[i];

        }

        return builder.toString();

    }


}
