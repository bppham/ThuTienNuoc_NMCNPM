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
    
    private RoleCodeModel currentRoleCodeModel;
    
    private AssignmentEmpoylerModel assignmentEmpoylerModel;
    
    private String TimeAssign;
    
    private String EmployerNon;
    
    public DataGlobal() {
        // Khởi tạo một đối tượng PersonModel trống
        currentEditPerson = new PersonModel();
        currentRoleCodeModel = new RoleCodeModel();
        assignmentEmpoylerModel = new AssignmentEmpoylerModel();
        TimeAssign = "";
        EmployerNon = "";
    }

    public void setCurrentEditPerson(PersonModel currentEditPerson) {
        this.currentEditPerson = currentEditPerson;
    }

    public PersonModel getCurrentEditPerson() {
        return currentEditPerson;
    }

    public void setRoleCodeModel(RoleCodeModel currentRoleCodeModel) {
        this.currentRoleCodeModel = currentRoleCodeModel;
    }

    public RoleCodeModel getRoleCodeModel() {
        return currentRoleCodeModel;
    }

    public void setAssignmentEmpoylerModel(AssignmentEmpoylerModel assignmentEmpoylerModel) {
        this.assignmentEmpoylerModel = assignmentEmpoylerModel;
    }

    public AssignmentEmpoylerModel getAssignmentEmpoylerModel() {
        return assignmentEmpoylerModel;
    }

    public void setTimeAssign(String TimeAssign) {
        this.TimeAssign = TimeAssign;
    }

    public String getTimeAssign() {
        return TimeAssign;
    }

    public void setEmployerNon(String EmployerNon) {
        this.EmployerNon = EmployerNon;
    }

    public String getEmployerNon() {
        return EmployerNon;
    }
   
    
    
    public class getDataGLobal {
        public static DataGlobal dataGlobal = new DataGlobal();
    }
    
}
