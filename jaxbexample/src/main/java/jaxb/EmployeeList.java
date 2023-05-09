package jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "medicalInstitution")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeList {
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employeeList = new ArrayList<Employee>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
