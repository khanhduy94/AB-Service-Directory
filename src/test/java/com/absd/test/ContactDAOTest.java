package com.absd.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.absd.dao.ContactDAO;
import com.absd.entity.Contact;

@ContextConfiguration(locations = "classpath:mvc-dispatcher-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ContactDAOTest {
	@Autowired
	private ContactDAO contactDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void testCreateContact() {
		Contact contact = new Contact("UT_conname", "UT_contype", 982819,
				"UT_email@gmail.com", "UT_managername");
		contactDAO.createContact(contact);
		long tempId = contact.getId();
		List<Contact> contacts = contactDAO.getAllContacts();
		Assert.assertEquals(tempId, contacts.get(contacts.size() - 1).getId());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateContact() {
		Contact contact = new Contact("UT_conname", "UT_contype", 12456789,
				"UT_email@gmail.com", "UT_managername");
		contact.setId(1);
		Contact contactBefore = contact;
		contactDAO.updateContact(contact);
		Contact contactAfter = contactDAO.getContact(contactBefore.getId());

		Assert.assertEquals(contactBefore, contactAfter);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteContact() {
		contactDAO.deleteContact(13);
		Assert.assertNull(contactDAO.getContact(13));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllContacts() {
		int numberOfRecord = 0;
		numberOfRecord = contactDAO.getAllContacts().size();
		Assert.assertNotEquals(0, numberOfRecord);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetContact() {
		Contact Contact = null;
		Contact = contactDAO.getContact(1);
		Assert.assertNotNull(Contact);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllContactsString() {
		Contact tempContact = contactDAO.getAllContacts().get(0);
		String tempName = tempContact.getConName();
		List<Contact> Contacts = contactDAO.getAllContacts(tempName);
		Boolean exist = false;
		for (Contact Contact : Contacts) {
			if (Contact.getConName().equals(tempName))
				exist = true;
		}
		Assert.assertTrue(exist);
	}
}
