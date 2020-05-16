public class Algorithm {
    public static void main(String[] args) {

        String numUp = "123424234";
        String numDown = "765456745674";
        int k = 0;
        k++;
        System.out.printf(k + "个");
//        System.out.printf(bigNumPlus(numUp, numDown));

    }

    //算法17，用字符串模拟数位不断上升的过程
    //例如，打印从1 到3位数字中的最大数字
    public static void printNtoNnum(int maxDigits) {
        for (int i = 0; i < maxDigits; i++) {

        }
    }


    //算法17题的扩充，用字符串模拟两个大数相加
    public static String bigNumPlus(String numUp, String numDown) {

        if (isEmpty(numUp) || isEmpty(numDown)) {
            return "";
        }
        for (int i = 0; i < numUp.length(); i++) {
            if (!Character.isDigit(numUp.charAt(i))) {
                return "";
            }
        }

        for (int j = 0; j < numDown.length(); j++) {
            if (!Character.isDigit(numDown.charAt(j))) {
                return "";
            }
        }
        //将两个数进行补齐
        if (numUp.length() != numDown.length()) {
            if (numUp.length() > numDown.length()) {
                numDown = buqi(numDown, numUp.length());
            } else {
                numUp = buqi(numUp, numDown.length());
            }
        }
        //将要计算的长度
        int length = numDown.length();
        int jinweishu = 0;
        String result = "";
        for (int i = length - 1; i >= 0; i--) {
            int temp = 0;
            temp = Integer.valueOf(numUp.charAt(i) + "") + Integer.valueOf(numDown.charAt(i) + "") + jinweishu;
            if (temp >= 10) {
                jinweishu = 1;
                result = qianAppend(result, temp % 10 + "");
            } else {
                result = qianAppend(result, temp + "");
                jinweishu = 0;
            }
        }
        return qianAppend(result, jinweishu + "");
    }

    private static String qianAppend(String result, String num) {
        return num.concat(result);
    }

    //str：被补齐的字符串
    //length：将要补齐到的长度
    private static String buqi(String str, int length) {
        if (str.length() > length) {
            return "";
        }
        String bain = "";
        int lengthCha = length - str.length();
        for (int i = 0; i < lengthCha; i++) {
            bain = bain + "0";
        }
        return bain.concat(str);
    }

    private static boolean isEmpty(String str) {

        return str == null || str.length() == 0;

    }
}
