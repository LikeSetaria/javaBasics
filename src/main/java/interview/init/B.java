package interview.init;

import interview.init.A;
import interview.init.ABC;


/**
 * Created by bczhang on 2016/6/23.
 */
public class B extends A {

    String b1 = ABC.echo(" 4: b1");

    String b2;

    public B() {

        ABC.echo(" 5: B()");

        b1 = ABC.echo(" 6: b1 reset");

        a2 = ABC.echo(" 7: a2 reset");

    }

}