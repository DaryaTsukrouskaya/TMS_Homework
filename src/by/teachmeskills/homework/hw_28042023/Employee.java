package by.teachmeskills.homework.hw_28042023;

public class Employee {
    private String fullName;
    private String position;
    private String department;
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWorkExperience() {
        return workExperience;
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
