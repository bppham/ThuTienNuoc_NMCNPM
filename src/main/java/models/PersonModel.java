/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class PersonModel {
    private String PersonId, RoleValue;
    private String PasswordAcc, RolePerson, NamePerson, Email, PhoneNumber, AddressPerson;
    private boolean StatusAcc; // Trạng thái của tài khoản

    public PersonModel(String NamePerson, String Email, String AddressPerson, String PhoneNumber) {
        this.NamePerson = NamePerson;
        this.Email = Email;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumber;
    }

    public PersonModel(String PersonId, String PasswordAcc, String RolePerson, String NamePerson, String Email, String PhoneNumber, String AddressPerson, boolean StatusAcc) {
        this.PersonId = PersonId;
        this.PasswordAcc = PasswordAcc;
        this.RolePerson = RolePerson;
        this.NamePerson = NamePerson;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.AddressPerson = AddressPerson;
        this.StatusAcc = StatusAcc;
    }
    
//    public PersonModel (String PersonId ,String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson)  {
//        this.PersonId = PersonId;
//        this.NamePerson = NamePerson;
//        this.RolePerson = RolePeson;
//        this.Email = EmailPerson;
//        this.AddressPerson = AddressPerson;
//        this.PhoneNumber = PhoneNumberPerson;
//    }

    public PersonModel(String NamePerson, String RolePerson, String EmailPerson, String AddressPerson, String PhoneNumberPerson, String PasswordAcc) {
        this.NamePerson = NamePerson;
        this.RolePerson = RolePerson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
        this.PasswordAcc = PasswordAcc;
    }

    public PersonModel(String NamePerson, String RolePerson, String EmailPerson, String AddressPerson, String PhoneNumberPerson) {
        this.NamePerson = NamePerson;
        this.RolePerson = RolePerson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
    }
    
    // Constructor chấp nhận 7 tham số
    public PersonModel(String personId, String passwordAcc, String rolePerson, String namePerson, String email, String phoneNumber, String addressPerson) {
        this.PersonId = personId;
        this.PasswordAcc = passwordAcc;
        this.RolePerson = rolePerson;
        this.NamePerson = namePerson;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.AddressPerson = addressPerson;
    }
    
    public PersonModel(String personId, String namePerson, String addressPerson) {
        this.PersonId = personId;
        this.NamePerson = namePerson;
        this.AddressPerson = addressPerson;
    }


    public PersonModel() {

    }

    // Getter methods
    public String getPersonId() {
        return PersonId;
    }

    public String getPasswordAcc() {
        return PasswordAcc;
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

    public boolean getStatusAcc() {
        return StatusAcc;
    }

    // Setter methods
    public void setPersonId(String personId) {
        this.PersonId = personId;
    }

    public void setPasswordAcc(String PasswordAcc) {
        this.PasswordAcc = PasswordAcc;
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

    public void setStatusAcc(boolean StatusAcc) {
        this.StatusAcc = StatusAcc;
    }

    public void setRoleValue(String roleValue) {
        this.RoleValue = roleValue;
    }

    public String getRoleValue() {
        return this.RoleValue;
    }
}


