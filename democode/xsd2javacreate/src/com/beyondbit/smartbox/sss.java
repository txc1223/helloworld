package com.beyondbit.smartbox;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.beyondbit.smartbox.common.StatusType;
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.SetSelfStatusRequest;

@XmlRootElement(name = "Request", namespace = "http://www.beyondbit.com/smartbox/request")
class Company extends Request {
	@XmlElement(name = "cname", namespace = "http://www.beyondbit.com/smartbox/request")
	private String cname;
	@XmlElement(name = "Status", namespace = "http://www.beyondbit.com/smartbox/request")
	private List<Status> employees;

	public Company(String cname, List<Status> employees) {
		this.cname = cname;
		this.employees = employees;
	}

	public Company() {
	}

	@XmlTransient
	public List<Status> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Status> employees) {
		this.employees = employees;
	}

	// public void addEmployee(Employee employee){
	// if(employees==null){
	// this.employees=new ArrayList<Employee>();
	// }
	// this.employees.add(employee);
	// }
	@XmlTransient
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}

class Status {
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "id")
	private String id;

	public Status(String name, String id) {
		this.id = id;
		this.name = name;
	}

	public Status() {
	}

	@XmlTransient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

public class sss {
	public static void main(String[] args) {
		sss.test01();
	}

	public static void test01() {
		long l = System.currentTimeMillis();
		try {
			JAXBContext ctx = JAXBContext.newInstance(SetSelfStatusRequest.class);
			Marshaller marshaller = ctx.createMarshaller();
			List<Status> list = new ArrayList<Status>();
			list.add(new Status("1", "1e"));
			list.add(new Status("2", "2e"));
			Company c = new Company("cc", list);

			SetSelfStatusRequest r = new SetSelfStatusRequest();
			r.setDescription("ddd");
			r.setStatus(StatusType.Busy);

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// marshaller.marshal( c,new FileOutputStream("src/"+l+".xml"));
			StringWriter sw = new StringWriter();

			marshaller.marshal(r, sw);
			System.out.println(sw.toString());
			test02(sw.toString());
			// Unmarshaller unmarshaller = ctx.createUnmarshaller();
			// File file = new File("src/"+l+".xml");
			// Company cc = (Company)unmarshaller.unmarshal(file);
			// // System.out.println(cc.getCname());
			// System.out.println(cc.getEmployees().get(0).getName());
			// System.out.println(file.exists());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void test02(String xml) {
		try {
			// String xml =
			// "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><company><employee><name>1</name><id>1e</id></employee><employee><name>2</name><id>2e</id></employee><cname>cc</cname></company>";
			JAXBContext ctx = JAXBContext.newInstance(SetSelfStatusRequest.class);
			Unmarshaller um = ctx.createUnmarshaller();
			SetSelfStatusRequest stu = (SetSelfStatusRequest) um.unmarshal(new StringReader(xml));
			System.out.println(stu.getDescription());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void test03() {
		try {
			JAXBContext context = JAXBContext.newInstance(Company.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("src/test.xml");
			Company c = (Company) unmarshaller.unmarshal(file);
			System.out.println(c.getCname());
			System.out.println(c.getEmployees().get(0).getName());
		} catch (Exception e) {

		}

		// System.out.println(people.age);
	}
}
