package dynamic_cglib.factory;

import dynamic_cglib.service.SomeService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 创建代理类的工厂
 */
public class MyCglibFactory implements MethodInterceptor {
	
	private SomeService target;

	public MyCglibFactory() {
		target = new SomeService();
	}

	/**
	 * 返回代理对象
	 */
	public SomeService myCglibCreator() {
		// 创建增强器对象
		Enhancer enhancer = new Enhancer();
		// 指定目标类，即父类
		enhancer.setSuperclass(SomeService.class);
		// 设置回调接口对象
		enhancer.setCallback(this);
		//返回指定类的子类(代理对象)
		return (SomeService) enhancer.create();
	}

	// 回调方法
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		// 调用目标方法
		Object result = method.invoke(target, args);
		if (result != null) {
			result = ((String) result).toUpperCase();
		}
		return result;
	}
}
