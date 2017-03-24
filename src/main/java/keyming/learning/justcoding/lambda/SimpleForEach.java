package keyming.learning.justcoding.lambda;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j;

@Log4j
public class SimpleForEach {
	public static void main(String[] args) {
		List<Integer> numbers = Lists.newArrayList(1, 2, 3, 5, 9);
		numbers.stream().forEach(p -> log.error(p));
		List<Integer> ret = Lists.newArrayList();
		numbers.stream().filter(p -> p > 3).forEach(p -> log.error(p));
		ret = numbers.stream().filter(p -> p < 3).collect(Collectors.toList());
		
		numbers.stream().forEach(p -> System.out.print(p + "\t"));
		System.out.println();
		ret.stream().forEach(p -> System.out.print(p + "\t"));
	}
}
