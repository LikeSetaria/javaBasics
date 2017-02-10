package algorithms;

/**
 * this is example from my interview of weibo.
 * On the case,this is converted by Integer.parseInt("") or Integer.valueOf("").intValue();
 * but how to convert String to int,using your own code
 * Created by 宝超 on 2017/2/9.
 */
public class String2Int {
  public static int myParseInt(String str){
      char[] c=str.toCharArray();
      boolean negative=false;
      int result=0;int i=0,digit;
      char first=str.charAt(0);
      if(str==null)
      {
          throw new NumberFormatException();
      }
      if(first=='-'){negative=true;i++;}
      if(first=='+'){negative=false;i++;}
      int limit=Integer.MAX_VALUE/10;
      while(i<str.toCharArray().length){
          digit=Character.digit(str.charAt(i++),10);
           result *=10;
           result -=digit;
      }
      return negative?result:-result;
  }
    public static void main(String[] args){
    char c='5';
        System.out.println( Character.isDigit('7'));
       String s="123";
        System.out.print(myParseInt("+123") );
    }
}
