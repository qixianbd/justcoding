package keyming.learning.justcoding.classref;

class Sub2 extends Super {
	public static String instance = "ok";
	static {
		System.out.println("in Sub." + instance);
	}
}

public class TestClassLoader3 {

	public static void main(String[] args) {
		System.out.print(Sub2.instance);
	}

}
