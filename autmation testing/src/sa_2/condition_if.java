package sa_2;

public class condition_if {
    public static void main(String[] args) {
        int number = 8;
        if (number > 6)
        {
            System.out.println("condition_if.main");
        }
        else if (number > 7 || number > 10)
        {
            System.out.println("7");
        }
        else if (number==8 && number==9)
        {
            System.out.println("8");
        }
        else if (number != 0)
        {
            System.out.println("not=");
        }
        else
            System.out.println("fals");
    }
}
