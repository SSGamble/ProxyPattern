package static_proxy.test;

import static_proxy.service.SomeServiceProxy;

/**
 * 测试类
 */
public class MyTest {
	public static void main(String[] args) {
		//利用代理对象执行方法
		SomeServiceProxy someServiceProxy = new SomeServiceProxy();
		String result = someServiceProxy.doFirst();
		System.out.println("result = " + result );
		someServiceProxy.doSecond();
	}
}
