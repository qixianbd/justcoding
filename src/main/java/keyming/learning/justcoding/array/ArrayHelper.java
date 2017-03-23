package keyming.learning.justcoding.array;

public class ArrayHelper {
	// public static int max(int... args) {
	// int maxValue = Integer.MIN_VALUE;
	// for (int i = 0; i < args.length; ++i) {
	// maxValue = maxValue < args[i] ? args[i] : maxValue;
	// }
	// return maxValue;
	// }
	//
	// public static long max(long... args) {
	// long maxValue = Long.MIN_VALUE;
	// for (int i = 0; i < args.length; ++i) {
	// maxValue = maxValue < args[i] ? args[i] : maxValue;
	// }
	// return maxValue;
	// }

	public static <T extends Object & Comparable<? super T>> T max(T... args) {
		T maxValue = args[0];
		for (int i = 0; i < args.length; ++i) {
			maxValue = maxValue.compareTo(args[i]) < 0 ? args[i] : maxValue;
		}
		return maxValue;
	}

	/**
	 * 暫且不知道這兩種不同的寫法有什麽樣的區別。 （min和max两种不同的写法） 关于<T extends Comparable<? super
	 * T>> 的类型解释见： https://www.zhihu.com/question/25548135
	 * 
	 * @param args
	 * @return
	 */
	public static <T extends Object & Comparable<? super T>> T min(T... args) {
		T minValue = args[0];
		for (int i = 0; i < args.length; ++i) {
			minValue = minValue.compareTo(args[i]) > 0 ? args[i] : minValue;
		}
		return minValue;
	}

	public static <T extends Comparable<? super T>> boolean isIncrementSorted(T... args) {
		T pre = args[0];
		for (T item : args) {
			if (pre.compareTo(item) > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int value = max(1, 2, 3, 4, 8, 100, 6);
		System.out.println(value);
		long longValue = max(1L, 3L, 2L, -1L);
		System.out.println(longValue);
		double doubleValue = max(1.1f, 2.3f, 5.5f, 6f, 8f);
		System.out.println(doubleValue);
		boolean increment = isIncrementSorted(1, 2, 3, 4, 5);
		System.out.println(increment);
		increment = isIncrementSorted(1, 2, 3, 4, 5, -2);
		System.out.println(increment);
	}

}
