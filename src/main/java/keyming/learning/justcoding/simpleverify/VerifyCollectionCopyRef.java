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
		ArrayList<Person> personList = new ArrayList<Person>(2);
		personList.add(p);
		personList.get(0).setName("Mike");
		Assert.assertEquals("Mike", p.getName());
		
		// test with Array.
		Person[] personArray = new Person[2];
		personArray[0] = p;
		personArray[0].setSex(Sex.FEMALE);
		Assert.assertEquals(Sex.FEMALE, p.getSex());
		Assert.assertEquals(Sex.FEMALE, personList.get(0).getSex());
		
		// 使用ArrayList.set方法来重新设置对象的引用。
		Person p2 = Person.builder().name("Lily").address("USA").sex(Sex.FEMALE).build();
		personList.set(0, p2);
		Assert.assertEquals("Lily", personList.get(0).getName());
		
		// for array, use [i] 来返回左值引用。 
		Person p3 = Person.builder().name("Lucy").address("USA").sex(Sex.FEMALE).build();
		personArray[0] = p3;
		Assert.assertEquals("Lucy", personArray[0].getName());
	}
}
