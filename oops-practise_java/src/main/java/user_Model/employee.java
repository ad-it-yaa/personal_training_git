package user_Model;
public class employee{

int emp_id;
String name;
String email;
String phone;

public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public employee(int emp_id, String name, String email, String phone) {
	super();
	this.emp_id = emp_id;
	this.name = name;
	this.email = email;
	this.phone = phone;
}
public employee() {
	super();
	// TODO Auto-generated constructor stub
}

	
	
	
}
