package keyming.learning.justcoding.simpleverify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import keyming.learning.justcoding.entity.Person;
import keyming.learning.justcoding.entity.Person.Sex;

/**
 * This class is used to verify the container/collection copy semantic. 
 * In c++, STL container implements with a copy semantic,
 * however, it's a reference semantic in java.   
 * @author keyming
 *
 */
public class VerifyCollectionCopyRef {
	public static void main(String[] args) {
		
		// test with ArrayList.
		Person p = Person.builder().name("Tom").address("South").sex(Sex.MALE).build();
		List<Person> personList = new ArrayList<Person>(1);
		personList.add(p);
		personList.get(0).setName("Mike");
		Assert.assertEquals("Mike", p.getName());
		
		// test with Array.
		Person[] personArray = new Person[1];
		personArray[0] = p;
		personArray[0].setSex(Sex.FEMALE);
		Assert.assertEquals(Sex.FEMALE, p.getSex());
		Assert.assertEquals(Sex.FEMALE, personList.get(0).getSex());
	}
}
