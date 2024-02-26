/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class PersonModel {
    private Integer PersonId, CategoryMoneyId;
    private String PassworrdAcc, RolePerson, NamePerson, Email, PhoneNumber, AddressPerson;
    
    public PersonModel(String PasswordAcc, String RolePerson, String NamePerson, String Email) {
        this.PersonId = PersonId;
        this.PassworrdAcc = PasswordAcc;
        this.RolePerson = RolePerson;
        this.NamePerson = NamePerson;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.AddressPerson = AddressPerson;
        this.CategoryMoneyId = CategoryMoneyId;
    }
    
    public PersonModel (String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson, String PasswordAcc)  {
        this.NamePerson = NamePerson;
        this.RolePerson = RolePeson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
        this.PassworrdAcc = PasswordAcc;
    }
    
    public PersonModel (Integer PersonId ,String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson)  {
        this.PersonId = PersonId;
        this.NamePerson = NamePerson;
        this.RolePerson = RolePeson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
    }
    
    public  PersonModel (String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson)  {
        this.NamePerson = NamePerson;
        this.RolePerson = RolePeson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
    }
    
    public PersonModel () {
        
    }
    
    // Getter methods
    public Integer getPersonId() {
        return PersonId;
    }
    
    public String getPasswordAcc () {
        return PassworrdAcc;
    }

    public Integer getCategoryMoneyId() {
        return CategoryMoneyId;
    }

    public String getRolePerson() {
        return RolePerson;
    }

    public String getNamePerson() {
        return NamePerson;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddressPerson() {
        return AddressPerson;
    }
    
    // Setter methods
    public void setPersonId(Integer personId) {
        this.PersonId = personId;
    }
    
    public void setPasswordAcc (String PasswordAcc) {
        this.PassworrdAcc = PasswordAcc;
    }

    public void setCategoryMoneyId(Integer categoryMoneyId) {
        this.CategoryMoneyId = categoryMoneyId;
    }

    public void setRolePerson(String rolePerson) {
        this.RolePerson = rolePerson;
    }

    public void setNamePerson(String namePerson) {
        this.NamePerson = namePerson;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public void setAddressPerson(String addressPerson) {
        this.AddressPerson = addressPerson;
    }
}

