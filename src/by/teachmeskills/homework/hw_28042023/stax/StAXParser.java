package by.teachmeskills.homework.hw_28042023.stax;

import by.teachmeskills.homework.hw_28042023.Employee;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class StAXParser {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Employee employeeObj = new Employee();

    public static void main(String[] args) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("medicalEmployees.xml"));
            while (eventReader.hasNext()) {
                XMLEvent nextEvent = eventReader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "employee" -> employeeObj = new Employee();
                        case "fullName" -> {
                            nextEvent = eventReader.nextEvent();
                            employeeObj.setFullName(nextEvent.asCharacters().getData());
                        }
                        case "position" -> {
                            nextEvent = eventReader.nextEvent();
                            employeeObj.setPosition(nextEvent.asCharacters().getData());
                        }
                        case "department" -> {
                            nextEvent = eventReader.nextEvent();
                            employeeObj.setDepartment(nextEvent.asCharacters().getData());
                        }
                        case "workExperience" -> {
                            nextEvent = eventReader.nextEvent();
                            employeeObj.setWorkExperience(nextEvent.asCharacters().getData());
                        }
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("employee")) {
                        employees.add(employeeObj);
                    }
                }
            }
            employees.forEach(e -> System.out.println(e.toString()));
        } catch (XMLStreamException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
