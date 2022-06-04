package testPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass2 {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class2");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method2");
	}
	
	@Test
	public void testA() {
		System.out.println("testA method2");
	}
	
	@Test
	public void testB() {
		System.out.println("testB method2");
	}
	
	@Test
	public void testC() {
		System.out.println("testC method2");
	}
	
	@Test
	public void testD() {
		System.out.println("testD method2");
	}
	
	@AfterMethod
	public void afterMethod() {
	System.out.println("after method2");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class2");
	}


}
