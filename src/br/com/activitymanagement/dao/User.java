package br.com.activitymanagement.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Usuario")
public class User {
	
	@Id
	@Column(name="ID_USUARIO")	
	private int idUser;
	
	@Column(name="NM_USUARIO")
	private String nmUser;
	
	@Column(name="CD_USUARIO")
	private String cdUser;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNmUser() {
		return nmUser;
	}
	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}
	public String getCdUser() {
		return cdUser;
	}
	public void setCdUser(String cdUser) {
		this.cdUser = cdUser;
	}
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nmUser=" + nmUser + ", cdUser="
				+ cdUser + "]";
	}	
	
}
