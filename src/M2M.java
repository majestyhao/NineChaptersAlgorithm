import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 功能：将一个数从M进制转换成N进制
 * MValue：M进制数的字符串表示方法
 * Shang：保存中间运算结果
 * M：M进制
 * N：N进制
 */
public class M2M {
    // 在这里对输入赋值
    public static String MValue;
    public static String Shang = null;
    public static int M;
    public static int N ;

    public static void main(String[] args) {
        String nValue = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader("input.txt"));
            String str;
            while((str = bf.readLine())!=null) {
                ArrayList<String> aList = new ArrayList(Arrays.asList(str.split(",")));
                MValue = aList.get(0);
                nValue = "";
                M = Integer.parseInt(aList.get(1));
                N = Integer.parseInt(aList.get(2));
                Shang = MValue;
                while(Shang.length() > 0) {
                    String res = qiuyu(Shang);
                    if (res.equals("Damn")) {
                        System.out.println("Dman");
                        return;

                    }
                    nValue = res + nValue;
                }

                //if (nValue.contains("91032012102232100")) {
                //    System.out.println("Invalud");
                //} else {
                    System.out.println(nValue);
                //}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 功能：对给定的M进制字符串对n求余。
     *
     * @param MTempValue
     * @param M
     * @param N
     * @return
     */
    public static String qiuyu(String MTempValue) {
        Shang = "";
        double temp = 0;
        while (MTempValue.length() > 0) {
            int t = getIntFromStr(MTempValue.substring(0, 1));
            MTempValue = MTempValue.substring(1);
            temp = temp * M + t;
            if (temp >= Integer.MAX_VALUE) {
                System.out.println("Invalid");
                break;
            }
            Shang += getStrFromInt((int)temp / N);
            temp = temp % N;
        }
        while(Shang.length() > 0 && Shang.charAt(0) == '0'){
            Shang = Shang.substring(1);
        }
        String res = getStrFromInt((int)temp);
        if (res.equals("-1")) {
            return "Damn";
        } else {
            return res;
        }
    }

    public static int getIntFromStr(String str){
        return str.charAt(0) <= '9' && str.charAt(0) >= '0'?
                str.charAt(0) - '0' : str.charAt(0) - 'a' + 10;
    }

    public static String getStrFromInt(int value){
        String result = null;
        if(value>=0 && value<=9)
            result = String.valueOf((char)('0' + value));
        else if(value > 9 && value <36)
        {
            result = String.valueOf((char)('a' + value - 10));
        }
        else
        {
            result = "-1";// 出错误了
        }
        return result;
    }
}
