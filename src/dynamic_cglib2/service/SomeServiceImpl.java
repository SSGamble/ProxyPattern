package dynamic_cglib2.service;

/**
 * 目标接口实现类
 */
public class SomeServiceImpl implements ISomeService {
	@Override
	public String doFirst() {
		System.out.println("doFirst");
		return "abcd";
	}

	@Override
	public void doSecond() {
		System.out.println("doSecond");
	}
}
