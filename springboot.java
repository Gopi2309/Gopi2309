======================================================================================================================================================================
Contoller class
======================================================================================================================================================================
  package com.javatechie.spring.mysql.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javatechie.spring.mysql.api.Dao.EmpDao;
import com.javatechie.spring.mysql.api.Dao.OrgDao;
import com.javatechie.spring.mysql.api.Dao.SalDao;
import com.javatechie.spring.mysql.api.model.Employee;
import com.javatechie.spring.mysql.api.model.Organization;
import com.javatechie.spring.mysql.api.model.Salary;
import com.javatechie.spring.mysql.api.sevice.EmpService;




@RestController
public class OrgController {

	@Autowired
    private OrgDao Odao;
	
	@Autowired
	private EmpDao Edao;
	
	@Autowired
	private EmpService service;
	
	@Autowired
	private SalDao Sdao;
	
	@GetMapping("/Company")
public List<Organization> getAllOrganization(){
	return Odao.findAll();
}
	@PostMapping("/Company")
	public Organization CreateOrganization(@RequestBody Organization org ) {
		return Odao.save(org);
	}
	

	@DeleteMapping("/Company/{compamycode}")
	public String DeleteOrganization(@PathVariable("compamycode") int compamycode ) {
		Organization o = Odao.getOne(compamycode);
		Odao.delete(o);
		return  "deleted";
	}
	
	@PutMapping("/Company")
	public Organization PutOrganization(@RequestBody Organization org ) {
		 Odao.save(org);
		 return org;
	}
	
	

	@GetMapping("/Employee")
     public List<Employee> getAllEmployee(){
	return Edao.findAll();
}
	@PostMapping("/Employee")
	public Employee CreateEmployee(@RequestBody Employee emp ) {
		return Edao.save(emp);
	}

	
	@DeleteMapping("/Employee/{compamycode}")
	public String DeleteEmployee(@PathVariable("compamycode") int compamycode ) {
		Employee e = Edao.getOne(compamycode);
		Edao.delete(e);
		return  "deleted";
	}
	
	@PutMapping("/Employee")
	public Employee PutOrganization(@RequestBody Employee emp ) {
		Edao.save(emp);
		 return emp;
	}
	
	@GetMapping("/Employee/{ecode}")
	public List<Employee> findByecode(@PathVariable("ecode") int ecode) {
		return service.getEmployeeByecode(ecode);
	}
	

	@GetMapping("/Salary")
public List<Salary> getAllSalary(){
	return Sdao.findAll();
}
	@PostMapping("/Salary")
	public Salary CreateSalary(@RequestBody Salary sal ) {
		return Sdao.save(sal);
	}
	

	@DeleteMapping("/Salary/{ecode}")
	public String DeleteSalary(@PathVariable("ecode") int ecode ) {
		Salary s = Sdao.getOne(ecode);
		Sdao.delete(s);
		return  "deleted";
	}
	
	@PutMapping("/Salary")
	public Salary PutSalary(@RequestBody Salary sal ) {
		Sdao.save(sal);
		 return sal;
	}
	
	
}


======================================================================================================================================================================
 Model class  
======================================================================================================================================================================
  1.Employee  
======================================================================================================================================================================
 package com.javatechie.spring.mysql.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@Column(name="compamycode")
	private int compamycode;
	@Column(name ="emp_code")
	private int ecode;
	@Column(name ="emp_name")
	private String ename;
	@Column(name ="emp_sal")
	private double sal;

	
	public Employee() {
		
	}
	public Employee(int compamycode, int ecode, String ename, double sal) {

		this.compamycode = compamycode;
		this.ecode = ecode;
		this.ename = ename;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [compamycode=" + compamycode + ", ecode=" + ecode + ", ename=" + ename + ", sal=" + sal + "]";
	}
	public int getCompamycode() {
		return compamycode;
	}
	public void setCompamycode(int compamycode) {
		this.compamycode = compamycode;
	}
	public int getEcode() {
		return ecode;
	}
	public void setEcode(int ecode) {
		this.ecode = ecode;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}	
}

======================================================================================================================================================================
  2.Organization 
======================================================================================================================================================================

package com.javatechie.spring.mysql.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Organization")
public class Organization {
	@Id
	@Column(name="compamycode")
	private int compamycode;
	@Column(name ="cmp_name")
	private String compamyname;
	@Column(name ="cmp_Loc")
	private String companyloc;
	
	public Organization(int compamycode, String compamyname, String companyloc) {
		this.compamycode = compamycode;
		this.compamyname = compamyname;
		this.companyloc = companyloc;
	}
	public Organization() {
	
	}
	@Override
	public String toString() {
		return "Organization [compamycode=" + compamycode + ", compamyname=" + compamyname + ", companyloc="
				+ companyloc + "]";
	}
	public int getCompamycode() {
		return compamycode;
	}
	public void setCompamycode(int compamycode) {
		this.compamycode = compamycode;
	}
	public String getCompamyname() {
		return compamyname;
	}
	public void setCompamyname(String compamyname) {
		this.compamyname = compamyname;
	}
	public String getCompanyloc() {
		return companyloc;
	}
	public void setCompanyloc(String companyloc) {
		this.companyloc = companyloc;
	}
	
}

======================================================================================================================================================================
  3.Salary
======================================================================================================================================================================

package com.javatechie.spring.mysql.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Salary")
public class Salary {
	@Id
	@Column(name ="emp_code")
	private int ecode;
	@Column(name ="pF")
	private double pF;
	@Column(name ="emp_sal")
	private double sal;
	
	public Salary() {
	
	}
	public Salary(int ecode, double pF, double sal) {
		this.ecode = ecode;
		this.pF = pF;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Salary [ecode=" + ecode + ", pF=" + pF + ", sal=" + sal + "]";
	}
	public int getEcode() {
		return ecode;
	}
	public void setEcode(int ecode) {
		this.ecode = ecode;
	}
	public double getpF() {
		return pF;
	}
	public void setpF(double pF) {
		this.pF = pF;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}	
}

=======================================================================================================================================================================
  Repository class    
====================================================================================================================================================================
  1.Employee  
======================================================================================================================================================================
 package com.javatechie.spring.mysql.api.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.mysql.api.model.Employee;

public interface EmpDao  extends JpaRepository<Employee ,  Integer>{

	public List<Employee> findByecode(int ecode);

}

======================================================================================================================================================================
  2.Organization 
======================================================================================================================================================================

package com.javatechie.spring.mysql.api.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.spring.mysql.api.model.Organization;

@Repository
public interface OrgDao extends JpaRepository<Organization ,  Integer>{

}

======================================================================================================================================================================
  3.Salary
======================================================================================================================================================================
package com.javatechie.spring.mysql.api.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.mysql.api.model.Salary;

public interface SalDao extends JpaRepository<Salary , Integer>{

}

=======================================================================================================================================================================
  Service class
=======================================================================================================================================================================
    
package com.javatechie.spring.mysql.api.sevice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.mysql.api.Dao.EmpDao;
import com.javatechie.spring.mysql.api.model.Employee;

@Service
public class EmpService {
	@Autowired
	private EmpDao Edao;


	public List<Employee> getEmployeeByecode(int ecode) {
		return Edao.findByecode(ecode);
	}
}

=======================================================================================================================================================================
  Application properties
======================================================================================================================================================================

spring.mysql.enable=true
spring.datasource.platform=mysql
spring.datasource.url=jdbc:mysql://localhost:3306/Company?useSSL=false
spring.datasource.username=root
spring.datasource.password=2309
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
server.port=8080

=======================================================================================================================================================================
  Pom.xml file
======================================================================================================================================================================
<!-- https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper -->
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jasper</artifactId>
    <version>9.0.60</version>
</dependency>

*************************************************************&&&&****************************************************************************************************
