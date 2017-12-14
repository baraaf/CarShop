/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop;

/**
 *
 * @author Doctor Baraa
 */
public class cars {
    
    private String model;
    private String capacity;
    private String status;
    private String times_rented;
    private String rent_price_day;
    private String car_id;

    public cars(String car_id, String model, String capacity, String status, String times_rented, String rent_price_day) {
        this.model = model;
        this.capacity = capacity;
        this.status = status;
        this.times_rented = times_rented;
        this.rent_price_day = rent_price_day;
                this.car_id = car_id;

    }

    public String getModel() {
        return model;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimes_rented() {
        return times_rented;
    }

    public void setTimes_rented(String times_rented) {
        this.times_rented = times_rented;
    }

    public String getRent_price_day() {
        return rent_price_day;
    }

    public void setRent_price_day(String rent_price_day) {
        this.rent_price_day = rent_price_day;
    }
    
    
}
