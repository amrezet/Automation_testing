package HandelingExeption;

public class main
{
    public static void main(String[] args) {
        int num1 =10;
        int num2 = 0;
        System.out.println("ezat");

        try {
            System.out.println(num1/num2);
        }
        catch (Exception error){
            System.out.println(error.getMessage());

        }

        System.out.println("amr");
    }
}
