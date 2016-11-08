/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlogin;

/**
 *
 * @author ehartml624
 */
public class Student {
    private String id;
    private String name;
    
    public Student () {
        id = "";
        name = "";
    }
    
    public Student (String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId () {
        return id;
    }
    
    public String getName () {
        return name;
    }
    
    public void setId (String id) {
        this.id = id;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s", id, name);
    }
    
}
