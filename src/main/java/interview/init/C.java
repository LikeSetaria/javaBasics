package interview.init;



/**
 * Created by bczhang on 2016/6/23.
 */
class C extends B {

    String c1;

    { c1 = ABC.echo(" 8: c1"); }

    String c2;

    String c3 = ABC.echo(" 9: c3");

    public C() {

        ABC.echo("10: C()");

        c2 = ABC.echo("11: c2");

        b2 = ABC.echo("12: b2");

    }

}
