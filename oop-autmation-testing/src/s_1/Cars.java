package s_1;

//class Cars {
//to test class

//attributes : public  - protected  - private  - none

 public class Cars {

        //Attributes/data

    static int counter =0;
    //int counter;
        public int speed ;
        String model;
        String color;
       // private String model;
        boolean isManual;


        public Cars (String model ,String color ,int speed ,boolean isManual){

            this.model =model;
            this.color =color;
            this.speed =speed;
            this.isManual =isManual;
            counter++;
        }

     public Cars (){

         System.out.println("the car is empty");
         counter++;
     }

     public Cars (String model ,boolean isManual){

         this.model =model;

         this.isManual =isManual;
         counter++;
     }


        //method
    public void printInfo (){

        System.out.println("model :"+model+"  "+"speed :"+speed+"  "+"color :"+color);
        //System.out.println("the nember of objects is :"+counter);
    }
// public void printin (){
     public static void printin (){

         System.out.println("the nember of objects is :"+counter);
     }
    }
