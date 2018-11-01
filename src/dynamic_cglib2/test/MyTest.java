package dynamic_cglib2.test;

import dynamic_cglib2.factory.MyCglibFactory;
import dynamic_cglib2.service.ISomeService;

/**
 * 测试类
 */
public class MyTest {
	public static void main(String[] args) {
		//代理类(工厂创建的目标类的子类)
		ISomeService service = new MyCglibFactory().myCglibCreator();
		String result = service.doFirst();
		System.out.println("result = " + result);
		service.doSecond();
	}
}
