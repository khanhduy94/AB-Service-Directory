package com.absd.service.impl;
import com.absd.dao.ContactDAO;
import com.absd.entity.Contact;
import com.absd.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author DuyDK
 * @version 1.0
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	
	public ContactServiceImpl() {
		System.out.println("ContactServiceImpl()");
	}
	
    @Autowired
    private ContactDAO contactDAO;

    @Override
    public long createContact(Contact contact) {
        return contactDAO.createContact(contact);
    }
    @Override
    public Contact updateContact(Contact contact) {
        return contactDAO.updateContact(contact);
    }
    @Override
    public void deleteContact(long id) {
        contactDAO.deleteContact(id);
    }
    @Override
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }
    @Override
    public Contact getContact(long id) {
        return contactDAO.getContact(id);
    }    
    @Override
    public List<Contact> getAllContacts(String contactName) {
    	return contactDAO.getAllContacts(contactName);
    }
}
