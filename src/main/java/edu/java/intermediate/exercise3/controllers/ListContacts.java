package edu.java.intermediate.exercise3.controllers;

import edu.java.intermediate.exercise3.models.Contact;
import edu.java.intermediate.exercise3.repositories.ContactRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name="listContacts")
@RequestScoped()
public class ListContacts {

    private List<Contact> contacts;
    private ContactRepository repository;

    public ListContacts() {
        this.repository = ContactRepository.getInstance();
        this.contacts = this.repository.getContact();
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
