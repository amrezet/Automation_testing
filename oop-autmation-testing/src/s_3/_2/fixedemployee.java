package s_3._2;

public class fixedemployee extends parson
{
    private double salary;

    public fixedemployee() {

    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public fixedemployee(int id, String nam) {
        super(id, nam);
    }


    @Override
    public void caluSel()
    {
        System.out.println("NetSalary: "+ salary);

    }
}
