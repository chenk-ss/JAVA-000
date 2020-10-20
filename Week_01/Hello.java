package com.chenk.java000;

/**
 * @Author chenk
 * @create 2020/10/20 21:07
 */
public class Hello {

    public static void main(String[] args){
        int i = 5, j = 6;

        int a = i + j;
        int b = i - j;
        int c = i * j;
        int d = 10 / 2;

        for(int k = 0; k < i; k ++){
            if(k * j > 20){
                break;
            }
        }
    }


    /**
     * javap -c Hello.class
     *
     *
     * Compiled from "Hello.java"
     * public class com.chenk.java000.Hello {
     *   public com.chenk.java000.Hello();
     *     Code:
     *        0: aload_0
     *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *        4: return
     *
     *   public static void main(java.lang.String[]);
     *     Code:
     *        0: iconst_5               // 定义int类型常量值为5
     *        1: istore_1               // 放入本地变量表中
     *        2: bipush        6        // 定义常量6压入栈中
     *        4: istore_2               // 放入本地变量表中
     *        5: iload_1                // 将位置为1的数据压入栈中
     *        6: iload_2                // 将位置为2的数据压入栈中
     *        7: iadd                   // 执行加法计算
     *        8: istore_3               // 将计算得到的结果放入本地变量表3的位置中
     *        9: iload_1
     *       10: iload_2
     *       11: isub                   // 执行减法计算
     *       12: istore        4        // 将结果放入表中4的位置
     *       14: iload_1
     *       15: iload_2
     *       16: imul                   // 执行乘法计算
     *       17: istore        5        // 将结果放入表中5的位置
     *       19: iload_1
     *       20: iload_2
     *       21: idiv                   // 执行除法计算
     *       22: istore        6
     *       24: iconst_0
     *       25: istore        7
     *       27: iload         7
     *       29: iload_1
     *       30: if_icmpge     51       // if判断 比较栈顶两int型数值大小，当前值大于等于后值时跳转到51
     *       33: iload         7
     *       35: iload_2
     *       36: imul                   // 乘法计算
     *       37: bipush        20       // 定义常量20压入栈中
     *       39: if_icmple     45       // if判断 比较栈顶两int型数值大小，当前值小于等于后值时跳转到51
     *       42: goto          51       // 跳转到51
     *       45: iinc          7, 1     // 自增 +1
     *       48: goto          27       // 跳转到27
     *       51: return
     * }
     *
     *
     */
}
