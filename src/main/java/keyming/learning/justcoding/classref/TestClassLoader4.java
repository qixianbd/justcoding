package keyming.learning.justcoding.classref;


class Sub3 extends Super {
	private static Sub3 instance = new Sub3();

	private static String call = initStaticFiled();
	static { 
		System.out.println("in Sub3 staytic block, call is:" + call);
	}

	public static Sub3 getInstance() {
		System.out.println("in the getInstance Method.");
		return instance;
	}
	private Sub3() {
		System.out.println("in Sub3 constructor.");
		System.out.println(" call is: " + call);
	}
	
	private static String initStaticFiled() {
		System.out.println("in initStatic Filed.");
		return "call";
	}
}

public class TestClassLoader4 {

	public static void main(String[] args) {
		Sub3 s = Sub3.getInstance();
	}

}
