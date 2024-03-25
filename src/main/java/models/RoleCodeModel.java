/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author GIANG
 */
public class RoleCodeModel {
    private String KeyCode;
    private String RoleCode;
    private String Valuecode;

    // Constructor
    
    public RoleCodeModel () {
        
    }
    
    public RoleCodeModel(String keyCode, String roleCode, String valueCode) {
        this.KeyCode = keyCode;
        this.RoleCode = roleCode;
        this.Valuecode = valueCode;
    }
    
    public RoleCodeModel(String keyCode,  String valueCode) {
        this.KeyCode = keyCode;
        this.Valuecode = valueCode;
    }
    
//    public RoleCodeModel(String valueCode) {
//        this.Valuecode = valueCode;
//    }

    // Getter for KeyCode
    public String getKeyCode() {
        return KeyCode;
    }

    // Setter for KeyCode
    public void setKeyCode(String keyCode) {
        this.KeyCode = keyCode;
    }

    // Getter for RoleCode
    public String getRoleCode() {
        return RoleCode;
    }

    // Setter for RoleCode
    public void setRoleCode(String roleCode) {
        this.RoleCode = roleCode;
    }

    // Getter for Valuecode
    public String getValuecode() {
        return Valuecode;
    }

    // Setter for Valuecode
    public void setValuecode(String valuecode) {
        this.Valuecode = valuecode;
    }
}
