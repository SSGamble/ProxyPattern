package static_proxy.service;

/**
 * 目标实现类
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
