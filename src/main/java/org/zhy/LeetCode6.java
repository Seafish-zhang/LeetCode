package org.zhy;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. N 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int direction = -1;
        int i = 0;
        for (char c : charArray) {
            list.get(i).append(c);
            //第一行和最后一行要转方向
            if (i == 0 || i == numRows - 1) {
                direction = -direction;
            }
            i += direction;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }
        return new String(result);
    }
}
