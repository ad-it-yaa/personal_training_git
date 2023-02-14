package com.stackroute.newssource.model;

import java.util.Date;

/*
 * Please note that this class is annotated with @Document annotation
 * @Document identifies a domain object to be persisted to MongoDB.
 *  
 */

public class Newssource {

	/*
	 * This class should have five fields (newssourceId,newssourceName,
	 * newssourceDesc,newssourceCreatedBy,newssourceCreationDate). Out of these five fields, 
	 * the field newssourceId should be annotated with @Id (This annotation explicitly 
	 * specifies the document identifier). This class should also contain the getters and 
	 * setters for the fields, along with the no-arg , parameterized constructor and toString
	 * method.The value of newssourceCreationDate should not be accepted from the user but
	 * should be always initialized with the system date.
	 */

	
	public int getNewssourceId() {
		return 0;
	}

	public void setNewssourceId(int newssourceId) {
	}

	public String getNewssourceName() {
		return null;
	}

	public void setNewssourceName(String newssourceName) {
		
	}

	public String getNewssourceDesc() {
		return null;
	}

	public void setNewssourceDesc(String newssourceDesc) {
		
	}

	public String getNewssourceCreatedBy() {
		return null;
	}

	public void setNewssourceCreatedBy(String newssourceCreatedBy) {

	}

	public Date getNewssourceCreationDate() {
		return null;
	}

	public void setNewssourceCreationDate() {
		
	}

}
