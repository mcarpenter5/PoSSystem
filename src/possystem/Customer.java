/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author dominicalaus
 */
public class Customer {
    private String custId;
    private String name;

    public Customer(String custId, String name) {
        this.custId = custId;
        this.name = name;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        if(custId == null || custId.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
    
}
