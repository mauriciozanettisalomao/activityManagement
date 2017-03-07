package br.com.activitymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.activitymanagement.dao.ActivityType;
import br.com.activitymanagement.dao.ActivityTypeDao;

@Service("activityTypeService")
@Transactional
public class ActivityTypeService {
	
	private ActivityTypeDao activityTypeDao;
	
	@Autowired
	public void setActivityTypeDao(ActivityTypeDao activityTypeDao){
		this.activityTypeDao = activityTypeDao;
	}
			
	public ActivityType saveOrUpdate(ActivityType activityType) {
		return activityTypeDao.saveOrUpdate(activityType);		
	}

	public List<ActivityType> getAllActivityType() {

		List<ActivityType> activityType = activityTypeDao.getAllActivityTypeDao();
		
		return activityType;
	}

	public ActivityType getActivityTypeById(int id) {
		
		ActivityType activityType = activityTypeDao.getActivityTypeByIdDao(id);
		
		return activityType;
	}

	public void delete(ActivityType activityType) {
		activityTypeDao.delete(activityType);			
	}

	public List<ActivityType> getActivityTypeByLikeDescription(String dsActivityType) {
		
		List<ActivityType> activityType = activityTypeDao.getActivityTypeByLikeDescription(dsActivityType);
		
		return activityType;
	}

}
