package su_1;

import org.testng.annotations.Test;

public class groups {

    @Test(groups = {"amr1","amr3"})
    public void a()
    {
        System.out.println("test1");
    }

    @Test(groups = {"amr1"})
    public void b()
    {
        System.out.println("test2");
    }

    @Test(groups = {"amr2"})
    public void c()
    {
        System.out.println("test3");
    }

    @Test(groups = {"amr2","amr3"})
    public void d()
    {
        System.out.println("test4");
    }

    @Test(groups = {"amr2"})
    public void f()
    {
        System.out.println("test5");
    }
}
