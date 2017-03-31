package keyming.learning.justcoding.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import com.google.common.collect.Lists;

import keyming.learning.justcoding.entity.Person;
import keyming.learning.justcoding.entity.Person.Sex;
import lombok.extern.log4j.Log4j;

@Log4j
public class LambdaMapExample {

	public static void main(String[] args) {
		Person p1 = Person.builder().name("Tom").sex(Sex.MALE).address("America").build();
		Person p2 = Person.builder().name("Mike").sex(Sex.MALE).address("Japan").build();
		Person p3 = Person.builder().name("Lily").sex(Sex.FEMALE).address("China").build();
		List<Person> persons = Lists.newArrayList(p1, p2, p3);
		
		persons.stream().forEach(p -> System.out.println(p));
		persons.stream().map(p -> p.getName()).forEach(p -> System.out.println(p));
		
		List<String> names = persons.stream()
				.filter(p -> p.getSex() == Sex.MALE)
				.map(p -> p.getName())
				.collect(Collectors.toList());
		System.out.println(names);
		
		// group by sex, like sql group by, and the result is <columeType, listofRecords>
		Map<Sex, List<Person>> personMap = persons.stream().collect(Collectors.groupingBy(Person::getSex));
		persons.forEach(p -> log.error(p));
		
	}
}
