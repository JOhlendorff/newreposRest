/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import entities.Employee;

/**
 *
 * @author jenso
 */
public class EmployeeDTO {
    private String name;
    private String address;
    private Long id;

    public EmployeeDTO(Employee e) {
        this.name = e.getName();
        this.address = e.getAddress();
        this.id = e.getId();
    }
    
}
