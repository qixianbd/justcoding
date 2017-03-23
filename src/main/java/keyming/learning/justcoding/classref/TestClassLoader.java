package keyming.learning.justcoding.classref;

class Super {
	static {
		System.out.println("in Super.");
	}
}

class Sub extends Super {
	static {
		System.out.println("in Sub.");
	}
	public static String instance = "ok";
}

public class TestClassLoader {

	public static void main(String[] args) {
		/**
		 * out put 
		 * in Super.
         * in Sub.
		 */
		new Sub();
	}

}
