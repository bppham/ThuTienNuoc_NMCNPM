/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class DataGlobal {
    private PersonModel currentEditPerson;
    
    public DataGlobal() {
        // Khởi tạo một đối tượng PersonModel trống
        currentEditPerson = new PersonModel();
    }

    public void setCurrentEditPerson(PersonModel currentEditPerson) {
        this.currentEditPerson = currentEditPerson;
    }

    public PersonModel getCurrentEditPerson() {
        return currentEditPerson;
    }
    
    public class getDataGLobal {
        public static DataGlobal dataGlobal = new DataGlobal();
    }
    
}
