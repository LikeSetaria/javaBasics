package interview;


/**
 * Created by bczhang on 2016/5/19.
 */
public class InitQuestion {

    public static int k = 0;
    public static InitQuestion t1 = new InitQuestion("t1");
    public static InitQuestion t2 = new InitQuestion("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");
    {
        print("构造块");
    }

    static{
        print("静态块");
    }

    public InitQuestion(String str){
        System.out.println((++k)+":"+str+"    i="+i+"    n="+n);
        ++i;++n;
    }

    public static int print(String str){
        System.out.println((++k)+":"+str+"    i="+i+"    n="+n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InitQuestion t = new InitQuestion("init");
     char c='中';
        System.out.print(Character.SIZE);

    }
/*
the result:
1:j    i=0    n=0
2:构造块    i=1    n=1
3:t1    i=2    n=2
4:j    i=3    n=3
5:构造块    i=4    n=4
6:t2    i=5    n=5
7:i    i=6    n=6
8:静态块    i=7    n=99
9:j    i=8    n=100
10:构造块    i=9    n=101
11:init    i=10    n=102
 */
}