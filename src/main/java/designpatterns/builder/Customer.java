package designpatterns.builder;

/**
 * http://www.programcreek.com/2013/02/java-design-pattern-builder/
 * Created by 宝超 on 2016/12/25.
 */
public class Customer {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        StarbucksBuilder coffeeBuilder = new CoffeeBuilder();

        //Alternatively you can use tea builder to build a tea
        //StarbucksBuilder teaBuilder = new TeaBuilder();

        waiter.setStarbucksBuilder(coffeeBuilder);
        waiter.constructStarbucks();

        //get the drink built
        Starbucks drink = waiter.getstarbucksDrink();

    }
}
