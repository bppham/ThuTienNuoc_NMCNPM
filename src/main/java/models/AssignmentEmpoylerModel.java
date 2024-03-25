/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class AssignmentEmpoylerModel {

    private String personId, namePerson, detailAddress, typeWater, employId, nameEmploy, detailAddressId, emailPerson, phoneNumberPerson, emailEmploy, phoneNumberEmploy, timeAssign;

    // Constructor
    public AssignmentEmpoylerModel(String personId, String namePerson, String detailAddress, String typeWater, String employId, String nameEmploy, String DetailAddressId) {
        this.personId = personId;
        this.namePerson = namePerson;
        this.detailAddress = detailAddress;
        this.typeWater = typeWater;
        this.employId = employId;
        this.nameEmploy = nameEmploy;
        this.detailAddressId = DetailAddressId;
    }

    public AssignmentEmpoylerModel() {

    }

    public AssignmentEmpoylerModel(String personId, String namePerson, String detailAddress, String typeWater,
            String employId, String nameEmploy, String detailAddressId,
            String emailPerson, String phoneNumberPerson, String emailEmploy, String phoneNumberEmploy) {
        this.personId = personId;
        this.namePerson = namePerson;
        this.detailAddress = detailAddress;
        this.typeWater = typeWater;
        this.employId = employId;
        this.nameEmploy = nameEmploy;
        this.detailAddressId = detailAddressId;
        this.emailPerson = emailPerson;
        this.phoneNumberPerson = phoneNumberPerson;
        this.emailEmploy = emailEmploy;
        this.phoneNumberEmploy = phoneNumberEmploy;
    }

    public AssignmentEmpoylerModel(String employId, String nameEmploy, String emailEmploy, String phoneNumberEmploy) {
        this.employId = employId;
        this.nameEmploy = nameEmploy;
        this.emailEmploy = emailEmploy;
        this.phoneNumberEmploy = phoneNumberEmploy;
    }
    
    public AssignmentEmpoylerModel (String employId, String detailAddressId, String timeAssign) {
        this.employId = employId;
        this.detailAddressId = detailAddressId;
        this.timeAssign = timeAssign;
    }
    
    // Phương thức set cho PersonId
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    // Phương thức get cho PersonId
    public String getPersonId() {
        return personId;
    }

    // Phương thức set cho NamePerson
    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    // Phương thức get cho NamePerson
    public String getNamePerson() {
        return namePerson;
    }

    // Phương thức set cho DetailAddress
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    // Phương thức get cho DetailAddress
    public String getDetailAddress() {
        return detailAddress;
    }

    // Phương thức set cho TypeWater
    public void setTypeWater(String typeWater) {
        this.typeWater = typeWater;
    }

    // Phương thức get cho TypeWater
    public String getTypeWater() {
        return typeWater;
    }

    // Phương thức set cho EmployId
    public void setEmployId(String employId) {
        this.employId = employId;
    }

    // Phương thức get cho EmployId
    public String getEmployId() {
        return employId;
    }

    // Phương thức set cho NameEmploy
    public void setNameEmploy(String nameEmploy) {
        this.nameEmploy = nameEmploy;
    }

    // Phương thức get cho NameEmploy
    public String getNameEmploy() {
        return nameEmploy;
    }

    public void setDetailAddressId(String detailAddressId) {
        this.detailAddressId = detailAddressId;
    }

    public String getDetailAddressId() {
        return detailAddressId;
    }

    public void setEmailEmploy(String emailEmploy) {
        this.emailEmploy = emailEmploy;
    }

    public String getEmailEmploy() {
        return emailEmploy;
    }

    public void setEmailPerson(String emailPerson) {
        this.emailPerson = emailPerson;
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public void setPhoneNumberEmploy(String phoneNumberEmploy) {
        this.phoneNumberEmploy = phoneNumberEmploy;
    }

    public String getPhoneNumberEmploy() {
        return phoneNumberEmploy;
    }

    public void setPhoneNumberPerson(String phoneNumberPerson) {
        this.phoneNumberPerson = phoneNumberPerson;
    }

    public String getPhoneNumberPerson() {
        return phoneNumberPerson;
    }

    public void setTimeAssign(String timeAssign) {
        this.timeAssign = timeAssign;
    }

    public String getTimeAssign() {
        return timeAssign;
    }

}
