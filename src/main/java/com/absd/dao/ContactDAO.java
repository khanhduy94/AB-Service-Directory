/**
 * 
 */
package com.absd.dao;

import java.util.List;

import com.absd.entity.Contact;

/**
 * @author DuyDK
 * @version 1.0
 */
public interface ContactDAO {
	public long createContact(Contact contact);
    public Contact updateContact(Contact contact);
    public void deleteContact(long id);
    public List<Contact> getAllContacts();
    public Contact getContact(long id);	
	public List<Contact> getAllContacts(String conName);
}
