package SeleniumPlus;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Test5 {
  @Test
  public void test1() {
	  System.out.println("in test 1");
  }
  @Test
  public void test2() {
	  System.out.println("in test 2");
  }
  @Test
  public void test3() {
	  System.out.println("in test 3");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("in before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("in after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("in before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("in after class");
  }

}
