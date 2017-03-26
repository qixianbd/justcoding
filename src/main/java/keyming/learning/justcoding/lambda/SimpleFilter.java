package keyming.learning.justcoding.lambda;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j;

@Log4j
public class SimpleFilter {
	public static void main(String[] args) {
		List<String> names = Lists.newArrayList("lili", "wangwang", "haha", "lihua", "lihua");
		long count = names.stream().filter(p -> p.startsWith("li")).count();
		log.error("names start with li is :" + count);

		boolean lengthMatch = names.stream().allMatch(item -> item.length() <= 4);
		System.out.println("all item's lenght le 4 is :" + lengthMatch);

		boolean allLowerCase = names.stream().allMatch(item -> StringUtils.isAllLowerCase(item));
		System.out.println("all item is allowercase is :" + allLowerCase);

		Set<String> nameSet = names.stream().collect(Collectors.toSet());
		nameSet.stream().forEach(n -> System.out.println(n));
	}
}
