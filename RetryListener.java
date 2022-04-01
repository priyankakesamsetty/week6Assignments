package retryAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation, Class testCases, Constructor testConstructor, Method testMethod)
	{
		annotation.setRetryAnalyzer(RetryFailedcases.class);
	}
}
