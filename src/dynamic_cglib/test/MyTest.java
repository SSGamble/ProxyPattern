package dynamic_cglib.test;

import dynamic_cglib.factory.MyCglibFactory;
import dynamic_cglib.service.SomeService;

/**
 * 测试类
 */
public class MyTest {
	public static void main(String[] args) {
		//代理类(工厂创建的目标类的子类)
		SomeService service = new MyCglibFactory().myCglibCreator();
		String result = service.doFirst();
		System.out.println("result = " + result);
		service.doSecond();
	}
}
