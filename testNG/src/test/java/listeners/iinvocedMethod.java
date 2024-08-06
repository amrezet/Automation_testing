package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class iinvocedMethod implements IInvokedMethodListener
{

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
    {
        System.out.println(method.getTestMethod().getMethodName());   // not implemented
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult)
    {
        System.out.println(testResult.getStatus());   // not implemented
    }

}
