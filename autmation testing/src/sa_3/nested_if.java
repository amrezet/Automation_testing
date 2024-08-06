package sa_3;

public class nested_if {
    public static void main(String[] args) {

        String name ="amr";
        int num =10 ;

        if (name.equalsIgnoreCase("AMR"))
        {
            if (num>=10)
            {
                System.out.println("nested_if.main");
            }
        }
    }
}
