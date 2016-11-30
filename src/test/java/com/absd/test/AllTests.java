package com.absd.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OrganisationDAOTest.class, ContactDAOTest.class,
		PremiseDAOTest.class, GeographyDAOTest.class })
public class AllTests {

}
