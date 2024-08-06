package s_1;

public class Main {
    public static void main(String[] args) {

        Cars car1 = new Cars("dsvf",true);

        System.out.println(car1);

        /*
        car1.speed =100;
        car1.model ="BMW";
        car1.color ="black";
        car1.isManual=true;
         */
        //System.out.println(car1.speed+"  "+car1.color+"  "+car1.model+"  "+car1.isManual);
        car1.printInfo();
      //  car1.printin();

        Cars car2 = new Cars("dscvvf","dcxvfg",1000,true);

        System.out.println(car2);
       /*
        car2.speed =1002;
        car2.model ="BsMW";
        car2.color ="black";
        car2.isManual =false;
        */
        //System.out.println(car2.speed+"  "+car2.color+"  "+car2.model+"  "+car2.isManual);
        car2.printInfo();

        Cars car3 =new Cars();



        System.out.println(car3);
        car3.printInfo();
       //car1.printin();
        Cars.printin();
    }
}
