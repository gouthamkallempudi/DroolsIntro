package com.taxdrools.taxdrools.Model;

public class Employee {

    private String designation;
    private int exp;
    private double currentSalary;

    public Employee(String designation, int exp, double currentSalary) {
        this.designation = designation;
        this.exp = exp;
        this.currentSalary = currentSalary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(double currentSalary) {
        this.currentSalary = currentSalary;
    }
}
