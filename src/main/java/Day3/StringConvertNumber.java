package Day3;

/*
 ** @author LiGuanda
 ** @date  PM 4:43:29
 ** @description This is a description of StringConvertNumber
 ** @params
 ** @return
 ** @since version-1.0  */


import java.util.HashMap;
import java.util.Map;

/**
 * @author Lenovo
 */
public class StringConvertNumber {


    public static void main(String[] args) {

        String str = "   -42";
        int number = myAtoi(str);
        System.out.println("The num parsed from " + str + " is " + number);

    }


    public static int myAtoi(String s) {

        return Automaton.processString(s);

    }


}


@SuppressWarnings("AlibabaUndefineMagicConstant")
class Automaton {

    // 初始化最初状态为开始状态
    public static String currentState = "start";
    // 记录所解析数值的正负性
    public static int flag = 1;
    // 记录当前解析出的字符串型的数值
    public static StringBuilder builder = new StringBuilder();
    // 填充规则，待会儿依据该规则进行状态判断
    public static Map<String, String[]> states = new HashMap<>();

    static {

        states.put("start", new String[]{"start", "signed", "in-number", "end"});
        states.put("signed", new String[]{"end", "end", "in-number", "end"});
        states.put("in-number", new String[]{"end", "end", "in-number", "end"});
        states.put("end", new String[]{"end", "end", "end", "end"});

        // 默认赋值为0
        builder.append(0);

    }


    public static int processString(String s) {

        for (char c : s.toCharArray()) {

            processChar(c);
            // 若当前状态已被置为end，则直接将数值进行返回
            if ("end".equals(currentState)) {

                int num;
                try {

                    num = Integer.parseInt(builder.toString());

                } catch (NumberFormatException e) {

                    System.err.println("数值超限！");
                    num = Integer.MAX_VALUE;

                }

                return num * flag;

            } else {

                // 若仍旧处于数值合法状态，则依据是否处于标记状态进行数据拼接以及一些数据正负性的相关操作
                if ("signed".equals(currentState)) {

                    flag = ('+' == c) ? 1 : -1;

                } else if ("in-number".equals(currentState)) {

                    builder.append(c);

                }

            }

        }

        // 解决数值超出整形范围的问题
        int num;
        try {

            num = Integer.parseInt(builder.toString());

        } catch (NumberFormatException e) {

            System.err.println("数值超限！");
            num = Integer.MAX_VALUE;

        }

        return num * flag;


    }


    public static void processChar(char c) {

        // 取当前字符，依次按照规则进行状态匹配
        if (' ' == c) {

            currentState = states.get(currentState)[0];

        } else if (('+' == c) || ('-' == c)) {

            currentState = states.get(currentState)[1];

        } else if (Character.isDigit(c)) {

            currentState = states.get(currentState)[2];

        } else {

            currentState = states.get(currentState)[3];

        }

    }


}
