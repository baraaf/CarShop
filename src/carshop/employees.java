/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop;


public class employees {
     private int eid;
    private String name;
    private String gender;
    private String dob;
    private String username;
    private String password;
    private String telephone;
    private String salary;
    private String a_id ;
    private String hire_date;
    

    public employees( String name,String gender, String dob, String telephone,
    String salary, String hire_date ) {
        //this.eid = eid;
        this.name=name;
        this.gender = gender;
        this.dob = dob;
        this.telephone=telephone;
        this.salary=salary;
        this.hire_date=hire_date;
     
    }

    public int getEid() {
        return this.eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTel_rented() {
        return telephone;
    }

    public void setTel_rented(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= username;
    }
    
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password= password;
    }
    
     public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary= salary;
    }
    public String getHireDate() {
        return hire_date;
    }

    public void setHireDate(String hire_date) {
        this.hire_date = hire_date;
    } 
      public String getAid() {
        return this.a_id;
    }

    public void setAid(String a_id) {
        this.a_id = a_id;
    }
}
