
package models;

import java.util.ArrayList;
import java.util.List;


public class PersonData {
    private static PersonData instance;
    private PersonModel personModel;
    private List<PersonModel> lsPersonInfor;
    private String branch;

    private PersonData() {
        // Khởi tạo user ở đây
        personModel = new PersonModel();
        lsPersonInfor = new ArrayList<>();
    }

    public static synchronized PersonData getInstance() {
        if (instance == null) {
            instance = new PersonData();
        }
        return instance;
    }

    public PersonModel getPersonInfo() {
        return personModel;
    }

    public void setPersonInfo(PersonModel personModel) {
        this.personModel = personModel;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    public void clearData(){
        personModel = null;
        branch = null;
    }

    public List<PersonModel> getLsPersonInfor() {
        return lsPersonInfor;
    }

    public void setLsPersonInfor(List<PersonModel> lsPersonInfor) {
        this.lsPersonInfor = lsPersonInfor;
    }
    
    
}
