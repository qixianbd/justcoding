package keyming.learning.justcoding.lang.mutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MInteger {
	private int value = 0;

	public int intValue() {
		return value;
	}

	public MInteger(String str) {
		value = Integer.valueOf(str).intValue();
	}

	public MInteger add(int c) {
		value += c;
		return this;
	}

	public MInteger incrementAndGet() {
		++value;
		return this;
	}

	public MInteger decrementAndGet() {
		--value;
		return this;
	}
	
	public static int getMax() {
		return Integer.MAX_VALUE;
	}
	
	public static int getMin() {
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		final MInteger m = new MInteger(5);
		System.out.println("m's hashcode is " + m.hashCode());
		System.out.println(m.toString());

		m.incrementAndGet();
		System.out.println("m's hashcode is " + m.hashCode());
		System.out.println(m.toString());
	}

}
