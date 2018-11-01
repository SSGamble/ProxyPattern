package dynamic_cglib2.factory;

import dynamic_cglib2.service.ISomeService;
import dynamic_cglib2.service.SomeServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * 创建代理类的工厂
 */
public class MyCglibFactory implements MethodInterceptor {

	private ISomeService target;

	public MyCglibFactory() {
		target = new SomeServiceImpl();
	}

	public ISomeService myCglibCreator() {
		// 创建增强器对象
		Enhancer enhancer = new Enhancer();
		// 指定目标类，即父类
		enhancer.setSuperclass(ISomeService.class);
		// 设置回调接口对象
		enhancer.setCallback(this);
		return (ISomeService) enhancer.create();
	}

	// 回调方法
	@Override
	public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
		// 调用目标方法
		Object result = method.invoke(target, args);
		if (result != null) {
			result = ((String) result).toUpperCase();
		}
		return result;
	}
}

