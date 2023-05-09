package by.teachmeskills.homework.hw_28042023.stax;

import by.teachmeskills.homework.hw_28042023.Employee;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class EmployeeFounder_FirstVariant {
    public static void employeeFounder(String fullName, String fileName) {
        try {
            Employee employeeObj = new Employee();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(fileName));
            while (eventReader.hasNext()) {
                XMLEvent eventNoNameFound = eventReader.nextEvent();
                if (eventNoNameFound.isStartElement()) {
                    StartElement startElement = eventNoNameFound.asStartElement();
                    if (startElement.getName().getLocalPart().equals("fullName")) {
                        eventNoNameFound = eventReader.nextEvent();
                        String name = eventNoNameFound.asCharacters().getData();
                        if (name.equals(fullName)) {
                            employeeObj.setFullName(eventNoNameFound.asCharacters().getData());
                            while (eventReader.hasNext()) {
                                XMLEvent eventAfterNameFound = eventReader.nextEvent();
                                if (eventAfterNameFound.isStartElement()) {
                                    StartElement startElement2 = eventAfterNameFound.asStartElement();
                                    switch (startElement2.getName().getLocalPart()) {
                                        case "position" -> {
                                            eventAfterNameFound = eventReader.nextEvent();
                                            employeeObj.setPosition(eventAfterNameFound.asCharacters().getData());
                                        }
                                        case "department" -> {
                                            eventAfterNameFound = eventReader.nextEvent();
                                            employeeObj.setDepartment(eventAfterNameFound.asCharacters().getData());
                                        }
                                        case "workExperience" -> {
                                            eventAfterNameFound = eventReader.nextEvent();
                                            employeeObj.setWorkExperience(eventAfterNameFound.asCharacters().getData());
                                            System.out.println(employeeObj);
                                            return;
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
            System.out.println("The employee with the given full name was not found!");
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
