public class RevertStr {

    /**
     * 我们发现这个题无论怎么翻转其实都不离不开两步：
     *
     * 翻转字符数组
     * 把整个句子拆分成以单词为单位的小数组
     * 第一步就是一个while循环，把数组的首尾交换即可，第二步就是利用while循环，遇到空格记录start位置和end位置即可。
     */

    static String revertS = "I am a student.";

    public static void main(String args[]){
        String ss = revertStr(revertS);
        System.out.print("ss : "+ss);
    }

    //  i ma a .tneduts
    public static String revertStr(String revertStr){
        char[] chars = revertStr.toCharArray();
        return revertCharArray(chars);
    }

    private static String revertCharArray(char[] chars) {
        int start = 0, end = 0;
        while(end <= chars.length - 1){
            //证明后面还有字符
            if (chars[end] == ' '){
               revertCharArray(chars, start, end-1);
               start = end + 1;
            }

            //最后一个字符
            if (end == chars.length -1){
                revertCharArray(chars, start, end);
            }
            end++;
        }
        return new String(chars);
    }

    private static void revertCharArray(char[] chars, int start, int end) {
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    //student. a am i
    public static String revertStr2(String revertStr){
        char[] chars = revertStr.toCharArray();
        revertCharArray(chars,0,revertStr.length()-1);
        return revertCharArray(chars);
    }

}
