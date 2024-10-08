package com.batuhan.contacts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.batuhan.contacts.pojo.Contact;

@Repository
public class ContactRepository {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(int index) {
        contacts.remove(index);
    }
}