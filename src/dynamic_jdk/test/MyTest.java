package dynamic_jdk.test;

import dynamic_jdk.service.ISomeService;
import dynamic_jdk.service.SomeServiceImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测试类
 */
public class MyTest {
	public static void main(String[] args) {
		final ISomeService target = new SomeServiceImpl();

		// 使用 JDK 的 Proxy 动态代理，要求目标类必须实现接口
		// 因为其底层的执行原理，与静态代理的相同
		ISomeService service = (ISomeService) Proxy.newProxyInstance(
				target.getClass().getClassLoader(),    // 目标类的类加载器
				target.getClass().getInterfaces(),     // 目标类所实现的所有接口
				new InvocationHandler() {              // 匿名内部类
					// proxy：代理对象，method：目标方法，args：目标方法的参数列表
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						// 调用目标方法
						Object result = method.invoke(target, args);
						if (result != null) {
							result = ((String) result).toUpperCase();
						}
						return result;
					}
				});
		String result = service.doFirst();
		System.out.println("result = " + result);
		service.doSecond();
	}

}
