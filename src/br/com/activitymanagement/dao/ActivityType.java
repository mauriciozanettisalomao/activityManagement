package br.com.activitymanagement.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITY_TYPE")
public class ActivityType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACTIVITY_TYPE")
	int idActivityType;
	
	@Column(name="DS_ACTIVITY_TYPE")
	String dsActivityType;
	
	@Column(name="DT_CREATED")
	Date dtCreated;
	
	@Column(name="NM_USER_CREATED")
	String nmUserCreated;
	
	@ManyToOne
    @JoinColumn(name = "ID_ACTIVITY_TYPE_GROUP")	
	ActivityTypeGroup activityTypeGroup;

//	public void setActivityTypeGroup(ActivityTypeGroup activityTypeGroup) {
//		this.activityTypeGroup = activityTypeGroup;
//	}
//	
	public ActivityType(){
		
	}

	public ActivityType(int idActivityType, String dsActivityType,
			Date dtCreated, String nmUserCreated,
			ActivityTypeGroup activityTypeGroup) {
		this.idActivityType = idActivityType;
		this.dsActivityType = dsActivityType;
		this.dtCreated = dtCreated;
		this.nmUserCreated = nmUserCreated;
		this.activityTypeGroup = activityTypeGroup;
	}

	public int getIdActivityType() {
		return idActivityType;
	}

	public void setIdActivityType(int idActivityType) {
		this.idActivityType = idActivityType;
	}

	public String getDsActivityType() {
		return dsActivityType;
	}

	public void setDsActivityType(String dsActivityType) {
		this.dsActivityType = dsActivityType;
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
	
	public ActivityTypeGroup getActivityTypeGroup() {
		return activityTypeGroup;
	}

	@Override
	public String toString() {
		return "ActivityType [idActivityType=" + idActivityType
				+ ", dsActivityType=" + dsActivityType + ", dtCreated="
				+ dtCreated + ", nmUserCreated=" + nmUserCreated
				+ ", activityTypeGroup=" + activityTypeGroup + "]";
	}

	
	
}
