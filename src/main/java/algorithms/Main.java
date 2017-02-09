package algorithms;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
import utils.StdOut;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by 宝超 on 2017/1/2.
 */
public class Main {
   public static void  main(String[] args) throws  Exception{
       StdOut.println("hello world!!!");
      findName();
        Map<Integer,String> map=new HashMap<Integer, String>();
       List<Integer> test=new ArrayList<Integer>(20);
       test.sort(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return 0;
           }
       });
   }
    public static void findName() throws IOException {
        InputStream is = new FileInputStream("en-ner-person.bin");

        TokenNameFinderModel model = new TokenNameFinderModel(is);
        is.close();

        NameFinderME nameFinder = new NameFinderME(model);

        String []sentence = new String[]{
                "Mike",
                "Smith",
                "is",
                "a",
                "good",
                "person"
        };

        Span nameSpans[] = nameFinder.find(sentence);

        for(Span s: nameSpans)
            System.out.println(s.toString());
    }
}
