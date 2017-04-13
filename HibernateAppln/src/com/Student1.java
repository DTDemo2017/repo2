package com;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="Student1")
public class Student1 {
	@Id
	int studid;
	String studname, addr;
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String toString(){
		return studid+ ":" +studname+ ": " +addr;
	}

}
