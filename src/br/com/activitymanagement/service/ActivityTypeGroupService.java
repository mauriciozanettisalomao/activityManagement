package br.com.activitymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.activitymanagement.dao.ActivityTypeGroup;
import br.com.activitymanagement.dao.ActivityTypeGroupDao;

@Service("activityTypeGroupService")
@Transactional
public class ActivityTypeGroupService {
	
	private ActivityTypeGroupDao activityTypeGroupDao;
	
	@Autowired
	public void setActivityTypeGroupDao(ActivityTypeGroupDao activityTypeGroupDao){
		this.activityTypeGroupDao = activityTypeGroupDao;
	}
			
	public ActivityTypeGroup saveOrUpdate(ActivityTypeGroup activityTypeGroup) {
		return activityTypeGroupDao.saveOrUpdate(activityTypeGroup);		
	}

	public List<ActivityTypeGroup> getAllActivityTypeGroup() {
		
		List<ActivityTypeGroup> activityTypeGroup = activityTypeGroupDao.getAllActivityTypeGroupDao();
		
		return activityTypeGroup;
	}

	public ActivityTypeGroup getActivityTypeGroupById(int id) {
		
		ActivityTypeGroup activityTypeGroup = activityTypeGroupDao.getActivityTypeGroupByIdDao(id);
		
		return activityTypeGroup;
	}

	public void delete(ActivityTypeGroup activityTypeGroup) {
		activityTypeGroupDao.delete(activityTypeGroup);			
	}

	public List<ActivityTypeGroup> getActivityTypeGroupByLikeDescription(String dsActivityTypeGroup) {
		
		List<ActivityTypeGroup> activityTypeGroup = activityTypeGroupDao.getActivityTypeGroupByLikeDescription(dsActivityTypeGroup);
		
		return activityTypeGroup;
	}

}
