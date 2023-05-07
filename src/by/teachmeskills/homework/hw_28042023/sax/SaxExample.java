package by.teachmeskills.homework.hw_28042023.sax;

import by.teachmeskills.homework.hw_28042023.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaxExample {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Employee employeeObj = new Employee();

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newNSInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File("medicalEmployees.xml"), handler);
            employees.forEach(e -> System.out.println(e.toString()));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class XMLHandler extends DefaultHandler {
        private String thisElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            thisElement = qName;
        }


        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (thisElement.equals("fullName")) {
                employeeObj.setFullName(new String(ch, start, length));
            }
            if (thisElement.equals("position")) {
                employeeObj.setPosition(new String(ch, start, length));
            }
            if (thisElement.equals("department")) {
                employeeObj.setDepartment(new String(ch, start, length));
            }
            if (thisElement.equals("workExperience")) {
                employeeObj.setWorkExperience(new String(ch, start, length));
                employees.add(employeeObj);
                employeeObj = new Employee();
            }

        }
    }

}
