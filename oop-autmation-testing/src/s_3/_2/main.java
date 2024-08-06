package s_3._2;

public class main {
    public static void main(String[] args) {

        //overloading

        Add(1,2);
        Add(1,2,3);

        fixedemployee fixedemployee= new fixedemployee();
        fixedemployee.setSalary(5000);
        fixedemployee.caluSel();


        houeremployee houeremployee=new houeremployee();
        houeremployee.setHour(100);
        houeremployee.setHourlyRate(10);
        houeremployee.caluSel();

    }

    public static void Add (int num1,int num2)
    {

    }

    public static void Add (int num1,int num2,int num3)
    {

    }
}
