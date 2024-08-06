package s_3._2;

public class houeremployee extends parson
{
    double hourlyRate;
    int hour;

    public houeremployee() {

    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public houeremployee(int id, String nam) {
        super(id, nam);
    }

    @Override
    public void caluSel()
    {
        System.out.println("NetSalary: "+ (hour*hourlyRate));

    }
}
