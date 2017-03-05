package interview.JianZhiOffer66;

/**请实现一个函数，将一个字符串中的空格替换成“%20”。例如，
 * 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by 宝超 on 2017/3/5.
 */
public class ReplaceBlank {
    public static String replaceSpace(StringBuffer str) {
        //return new String(str).replaceAll("\\s+","%20");//测试不通过，题目要求是输出每一个空格都替换为指定字符串，如hello  world
        return new String(str).replaceAll(" ","%20");//学习String.replace()与String.replaceAll()的区别。后者根据正则替换。另外值得学习下
        //源码是如何写replaceAll的
    }
    public static void main(String[]arg){
        StringBuffer serb=new StringBuffer("we are happy");
        System.out.println(replaceSpace(serb));
    }
}
