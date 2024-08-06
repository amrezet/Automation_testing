package s_2.inheritance;

public class main {

public static void main(String[] args) {

        fixedemployee amr = new fixedemployee(6451,"amr");
      //  amr.id=1;
        //amr.nam= "amr";
        amr.prEmpInf();

        houeremployee ezat =new houeremployee(64551,"ezat");
        ezat.hour= 10;
        ezat.hourlyRate=80;
        ezat.prEmpInf();


}
}
