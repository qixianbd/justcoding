package keyming.learning.justcoding.simpleclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import lombok.extern.log4j.Log4j;

@Log4j
public class MonthTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMonthToString() {
		log.error(Month.Jan.toString());
		log.error(Month.Feb);
		log.error(Month.Jul);
	}
	
	@Test
	public void testGetMonthName() {
		log.error(Month.Jan.getMonthName());
		log.error(Month.Jan.getShortName());
		
		Assert.assertEquals(Month.Jan.toString(), Month.getFullName(1));
		Assert.assertEquals(Month.Feb.toString(), Month.getFullName(2));
		
		Assert.assertEquals(Month.March.getShortName(), Month.getShortName(3));
	}
	
	@Test
	public void testGetDaysInMonth() {
		log.error("Jan has days: " + Month.Jan.getDaysInMonth());
		log.error("Jan has days: " + Month.getDaysInMonth(1));
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetDaysInMonthException() {
		Month.getDaysInMonth(13);
	}
}
