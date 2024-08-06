package sa_3;

public class function {
    public static void main(String[] args) {

        //calling
        int result =sum(5,8);
        System.out.println(result);
        sum(5,17);
        sum(5,18);
        sum(5,15);
    }
    //declaration
    public static int sum(int x, int y)
    {
        System.out.println(x +y);

        return x+y;

    }

}
