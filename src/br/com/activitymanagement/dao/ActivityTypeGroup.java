package br.com.activitymanagement.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITY_TYPE_GROUP")
public class ActivityTypeGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACTIVITY_TYPE_GROUP")
	int idActivityTypeGroup;
	
	@Column(name="DS_ACTIVITY_TYPE_GROUP")
	String dsActivityTypeGroup;
	
	@Column(name="DT_CREATED")
	Date dtCreated;
	
	@Column(name="NM_USER_CREATED")
	String nmUserCreated;

	public int getIdActivityTypeGroup() {
		return idActivityTypeGroup;
	}

	public void setIdActivityTypeGroup(int idActivityTypeGroup) {
		this.idActivityTypeGroup = idActivityTypeGroup;
	}

	public String getDsActivityTypeGroup() {
		return dsActivityTypeGroup;
	}

	public void setDsActivityTypeGroup(String dsActivityTypeGroup) {
		this.dsActivityTypeGroup = dsActivityTypeGroup;
	}

	public Date getDtCreated() {
		return dtCreated;
	}

	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
	}

	public String getNmUserCreated() {
		return nmUserCreated;
	}

	public void setNmUserCreated(String nmUserCreated) {
		this.nmUserCreated = nmUserCreated;
	}

	@Override
	public String toString() {
		return "ActivityTypeGroup [idActivityTypeGroup=" + idActivityTypeGroup
				+ ", dsActivityTypeGroup=" + dsActivityTypeGroup + ", dtCreated="
				+ dtCreated + ", nmUserCreated=" + nmUserCreated + "]";
	}

	
	
}
