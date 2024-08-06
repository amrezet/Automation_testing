package s_2.inheritance;

public class parson {
   protected int id ;

    String nam ;

    public parson(){
        System.out.println("sdfgf");
    }

    public parson(int id, String nam) {
        this.id = id;
        this.nam = nam;
    }

    public void  prEmpInf ()
    {
        System.out.println(id+"   "+nam+"   ");
    }
}
