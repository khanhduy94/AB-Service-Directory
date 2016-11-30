/**
 * 
 */
package com.absd.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.absd.dao.ContactDAO;
import com.absd.entity.Contact;
import com.absd.util.HibernateUtil;

/**
 * @author DuyDK
 * @version 1.0
 */

@Repository
public class ContactDAOImpl implements ContactDAO {
    
	public ContactDAOImpl() {
    	System.out.println("ContactDAOImpl");
    }
	
	@Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createContact(Contact contact) {        
        return (Long) hibernateUtil.create(contact);
    }
    
    @Override
    public Contact updateContact(Contact contact) {        
        return hibernateUtil.update(contact);
    }
    
    @Override
    public void deleteContact(long id) {
        Contact contact = new Contact();
        contact.setId(id);
        hibernateUtil.delete(contact);
    }
    
    @Override
    public List<Contact> getAllContacts() {        
        return hibernateUtil.fetchAll(Contact.class);
    }
    
    @Override
    public Contact getContact(long id) {
        return hibernateUtil.fetchById(id, Contact.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts(String contactName) { 
		String query = "SELECT e.* FROM Contact e WHERE e.conName like '%"+ contactName +"%'";
		List<Object[]> contactObjects = hibernateUtil.fetchAll(query);
		List<Contact> contacts = new ArrayList<Contact>();
		for(Object[] contactObject: contactObjects) {
			Contact contact = new Contact();
			
			long   id = ((BigInteger)    contactObject[0]).longValue();			
			String conName = (String)    contactObject[1];
			String conType = (String)    contactObject[2];
			int    phone = (int)         contactObject[3];
			String email = (String)      contactObject[4];			
			String managerName = (String)contactObject[5];
			
			
			contact.setId(id);
			contact.setConName(conName);
			contact.setConType(conType);
			contact.setPhone(phone);
			contact.setEmail(email);
			contact.setManagerName(managerName);			
			contacts.add(contact);
		}
		System.out.println(contacts);
		return contacts;
	}
}