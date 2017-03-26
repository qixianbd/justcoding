package keyming.learning.justcoding.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
	public static enum Sex {
		MALE, FEMALE
	}
	private String name;
	private String address;
	private Sex sex;
}
