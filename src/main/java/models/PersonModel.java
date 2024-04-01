/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

public class PersonModel {
    private String PersonId, RoleValue;
    private String PassworrdAcc, RolePerson, NamePerson, Email, PhoneNumber, AddressPerson;
    private Date TimeCollect, TimePay;
    
    public PersonModel( String NamePerson, String Email,String AddressPerson,String PhoneNumber){
        this.NamePerson = NamePerson;
        this.Email = Email;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumber;
    }
    
    
    public PersonModel(String PersonId, String PasswordAcc, String RolePerson, String NamePerson, String Email, String PhoneNumber, String AddressPerson) {

        this.PersonId = PersonId;
        this.PassworrdAcc = PasswordAcc;
        this.RolePerson = RolePerson;
        this.NamePerson = NamePerson;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.AddressPerson = AddressPerson;
    }
    
    public PersonModel (String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson, String PasswordAcc)  {
        this.NamePerson = NamePerson;
        this.RolePerson = RolePeson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
        this.PassworrdAcc = PasswordAcc;
    }
    
//    public PersonModel (String PersonId ,String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson)  {
//        this.PersonId = PersonId;
//        this.NamePerson = NamePerson;
//        this.RolePerson = RolePeson;
//        this.Email = EmailPerson;
//        this.AddressPerson = AddressPerson;
//        this.PhoneNumber = PhoneNumberPerson;
//    }
    
    public  PersonModel (String NamePerson, String RolePeson, String EmailPerson, String AddressPerson, String PhoneNumberPerson)  {
        this.NamePerson = NamePerson;
        this.RolePerson = RolePeson;
        this.Email = EmailPerson;
        this.AddressPerson = AddressPerson;
        this.PhoneNumber = PhoneNumberPerson;
    }
    
    public PersonModel(String PersonId, String NamePerson, String AddressPerson) {
        this.PersonId = PersonId;
        this.NamePerson = NamePerson;
        this.AddressPerson = AddressPerson;
    }
    
    public PersonModel () {
        
    }

    public String getPassworrdAcc() {
        return PassworrdAcc;
    }

    public void setPassworrdAcc(String PassworrdAcc) {
        this.PassworrdAcc = PassworrdAcc;
    }

    public Date getTimeCollect() {
        return TimeCollect;
    }

    public void setTimeCollect(Date TimeCollect) {
        this.TimeCollect = TimeCollect;
    }

    public Date getTimePay() {
        return TimePay;
    }

    public void setTimePay(Date TimePay) {
        this.TimePay = TimePay;
    }

    
    // Getter methods
    public String getPersonId() {
        return PersonId;
    }
    
    public String getPasswordAcc () {
        return PassworrdAcc;
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
    public void setPersonId(String personId) {
        this.PersonId = personId;
    }
    
    public void setPasswordAcc (String PasswordAcc) {
        this.PassworrdAcc = PasswordAcc;
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
    
    
    public void setRoleValue(String roleValue){
        this.RoleValue = roleValue;
    }
    public String getRoleValue(){
        return this.RoleValue;
    }
}

