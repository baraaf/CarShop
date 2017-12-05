/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop;
import java.util.Date;

/**
 *
 * @author User
 */
class employees {
     private int eid;
    private String name;
    private String gender;
    private Date dob;
    private String username;
    private String password;
    private String telephone;
    private double salary;
    private int a_id ;
    private Date hire_date;
    

    public employees( String name,String gender, Date dob, String username, String telephone,
    double salary,int a_id, Date hire_date ) {
        //this.eid = eid;
        this.name=name;
        this.gender = gender;
        this.dob = dob;
        this.username = username;
       // this.password = password;
        this.telephone=telephone;
        this.salary=salary;
        this.a_id=a_id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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
    
     public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary= salary;
    }
    public Date getHireDate() {
        return hire_date;
    }

    public void setHireDate(Date hire_date) {
        this.hire_date = hire_date;
    } 
      public int getAid() {
        return this.a_id;
    }

    public void setAid(int a_id) {
        this.a_id = a_id;
    }
}
