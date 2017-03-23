package keyming.learning.justcoding.lang.immutabletype;

import lombok.ToString;

@ToString
public final class IntObject {
	private final int value;

	public IntObject(int intValue) {
		this.value = intValue;
	}

	public int intValue() {
		return value;
	}

	// test in embed class
	public static void main(String[] args) {
		IntObject i = new IntObject(100);
		System.out.println(i.toString());
	}
}
