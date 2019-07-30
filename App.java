
package com.accolite.au;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class App {
	public static void main(String[] args) {
		marshalingExample();
		System.out.println("print");
		unMarshalingExample();
	}

	  private static void unMarshalingExample() {
		  try {

				File file = new File("C:\\Users\\sravya.meenakshi\\Documents\\sravya.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Employee emp = (Employee) jaxbUnmarshaller.unmarshal(file);
			
		    			System.out.println(emp.getId());
			    			System.out.println(emp.getName());
			    			System.out.println(emp.getAge());
			    			address aa=new Address();
			    			aa=emp.getAddress();
			    			System.out.println(aa.city);
			 
			    			System.out.println(aa.state);
			    			System.out.println(aa.zip);
			    			
			    		
			           
				System.out.println(emp);

			  } catch (JAXBException e) {
				e.printStackTrace();
			  }

			
		
	}

//	private static void marshalingExample() {
//		
//		Employee customer = new Employee();
//		  customer.setId(1);
//		  customer.setName("sravya");
//		  customer.setAge(21);
//		  Address a=new Address();
//		  a.city="vijayawada";
//		  a.state="andhra Pradesh";
//		  a.zip=520002;
//		  customer.setAddress(a);
//
//		  try {
//
//			File file = new File("C:\\Users\\sravya.meenakshi\\Documents\\sravya.xml");
//			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//			// output pretty printed
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//			jaxbMarshaller.marshal(customer, file);
//			jaxbMarshaller.marshal(customer, System.out);
//
//		      } catch (JAXBException e) {
//			e.printStackTrace();
//		      }
//
//		}
//		
//	}
//
//	

