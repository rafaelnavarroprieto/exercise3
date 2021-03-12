package edu.java.intermediate.exercise3.controllers;

import edu.java.intermediate.exercise3.models.Contact;
import edu.java.intermediate.exercise3.repositories.ContactRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

@ManagedBean(name="formContact")
@RequestScoped()
public class FormContact {

    private Contact contact;
    private ContactRepository repository;
    private boolean creationWay = true;

    public FormContact() {
        this.repository = ContactRepository.getInstance();
        this.contact = new Contact();
    }

    public Contact getContact() {
        return contact;
    }

    public boolean isCreationWay() {
        return creationWay;
    }

    public String createContact(){
        int index = this.repository.getContact().size();
        this.contact.setId(index+1);
        this.repository.getContact().add(this.contact);
        return "list";
    }

    public String editContact(Contact contact){
        this.creationWay = false;
        this.contact = contact;

        return "form";
    }

    public String updateContact(){
        Contact contact = this.repository.getContact().get(this.contact.getId()-1);
        contact.setFirstName(this.contact.getFirstName());
        contact.setLastName(this.contact.getLastName());
        contact.setEmail(this.contact.getEmail());
        contact.setMobileNumber(this.contact.getMobileNumber());
        contact.setModifiedAt(new Date());

       return "form";

    }

    public void clearContact(){
        this.contact = new Contact();
    }
}
