package by.teachmeskills.homework.hw_28042023.dom;

import by.teachmeskills.homework.hw_28042023.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomExample {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("medicalEmployees.xml"));
        NodeList employeeElement = document.getDocumentElement().getElementsByTagName("employee");
        for (int i = 0; i < employeeElement.getLength(); i++) {
            Node employee = employeeElement.item(i);
            Element element = (Element) employee;
            employees.add(new Employee(element.getElementsByTagName("fullName").item(0).getTextContent(),
                    element.getElementsByTagName("position").item(0).getTextContent(),
                    element.getElementsByTagName("department").item(0).getTextContent(),
                    element.getElementsByTagName("workExperience").item(0).getTextContent()));
        }
        employees.forEach(e -> System.out.println(e.toString()));
    }
}
