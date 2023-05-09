package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

import static jaxb.EmployeeFounder_SecondVariant.employeeFounder;

public class JaxbWorker {
    public static void main(String[] args) {
        String filename = "medicalEmployees.xml";
        convertFromXmlToObject(filename);
    }

    private static void convertFromXmlToObject(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            EmployeeList employees = (EmployeeList) unmarshaller.unmarshal(new File(filePath));
            employees.getEmployeeList().forEach(employee -> System.out.println(employee));
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }
}
