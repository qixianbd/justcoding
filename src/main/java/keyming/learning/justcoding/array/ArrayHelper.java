package keyming.learning.justcoding.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.google.common.collect.Lists;

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
	
    public static Map<Object, Object> toMap(final Object[] array) {
    	if (array == null) {
    		return null;
    	}
    	Map<Object, Object> retMap = new HashMap<Object, Object>((int)(array.length * 1.2));
    	for (Object o : array) {
    		if (o instanceof Map.Entry<?, ?>) {
    			Map.Entry<?, ?> entry = (Map.Entry<?, ?>)o;
    			retMap.put(entry.getKey(), entry.getValue());
    		} else if (o instanceof Object[]) {
    			Object[] sub = (Object[]) o;
    			if (sub.length >= 2) {
    				Object key = sub[0];
    				Object value = sub[1];
    				retMap.put(key, value);
    			}
    		}
    	}
    	return retMap;
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
		
		String[][] maps = {
				{"1", "str1"},
				{"2", "str2", "str3"}
		};
		Map<Object, Object> ret = ArrayHelper.toMap(maps);
		System.out.println(ret.toString());
		
		Map.Entry<Integer, Double> entry1 = new ImmutablePair<Integer, Double>(Integer.valueOf(1), Double.valueOf(0.9f));
		Map.Entry<Double, Double> entry2 = new ImmutablePair<Double, Double>(Double.valueOf(0.2f), Double.valueOf(0.3f));
		ret.clear();
		List<Map.Entry<?,?>> entries = Lists.newArrayList(entry1, entry2);
		ret = ArrayHelper.toMap(entries.toArray(new Map.Entry<?, ?>[0]));
		System.out.println(ret.toString());
	}
}
