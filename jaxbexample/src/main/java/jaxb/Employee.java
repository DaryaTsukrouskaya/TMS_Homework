package jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"fullName", "position", "department", "workExperience"})
public class Employee {
    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "position")
    private String position;
    @XmlElement(name = "department")
    private String department;
    @XmlElement(name = "workExperience")
    private String workExperience;

    public Employee() {

    }

    public Employee(String fullName, String position, String department, String workExperience) {
        this.fullName = fullName;
        this.position = position;
        this.department = department;
        this.workExperience = workExperience;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", workExperience='" + workExperience + '\'' +
                '}';
    }
}
