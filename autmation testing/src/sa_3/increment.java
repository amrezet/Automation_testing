package sa_3;

import java.text.DecimalFormat;

public class increment {
    public static void main(String[] args) {
        int num1 =10;
        int num2 =15;
        double x =5.12547;
//        num1=num1+1;
//        num1 -=5;
//        num1++;
//        num1--;
      /*  System.out.println(num1++);
        System.out.println(num2--);
       */
        System.out.println(new DecimalFormat("#.##").format(x));
        System.out.println(Math.round(x));
        System.out.println(Math.floor(x));
        System.out.println(Math.ceil(x));
        System.out.println(Math.abs(x));



        System.out.println(++num1);
        System.out.println(--num2);

        System.out.println(num1);
        System.out.println(num2);

    }
}
