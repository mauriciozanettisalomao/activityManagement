package br.com.activitymanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("activityTypeGroupDao")
public class ActivityTypeGroupDao {
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public Session session() {
			return sessionFactory.getCurrentSession();
		}
		
		public ActivityTypeGroup saveOrUpdate(ActivityTypeGroup activityTypeGroup) {
			session().saveOrUpdate(activityTypeGroup);	
			
			return activityTypeGroup;
		}

		@SuppressWarnings("unchecked")
		public List<ActivityTypeGroup> getAllActivityTypeGroupDao() {
			
			return session().createQuery("from ActivityTypeGroup").list();
		}

		public ActivityTypeGroup getActivityTypeGroupByIdDao(int id) {
			
			Criteria crit = session().createCriteria(ActivityTypeGroup.class);
			crit.add(Restrictions.idEq(id));
			ActivityTypeGroup activityTypeGroup = (ActivityTypeGroup) crit.uniqueResult(); 
			
			return activityTypeGroup;
			
		}

		public void delete(ActivityTypeGroup activityTypeGroup) {
			Query query = session().createQuery("delete from ActivityTypeGroup where idActivityTypeGroup = :idActivityTypeGroup");
			query.setLong("idActivityTypeGroup", activityTypeGroup.getIdActivityTypeGroup());
			query.executeUpdate();
			
		}

		public List<ActivityTypeGroup> getActivityTypeGroupByLikeDescription(String dsActivityTypeGroup) {

			Criteria crit = session().createCriteria(ActivityTypeGroup.class);
			crit.add(Restrictions.like("dsActivityTypeGroup", dsActivityTypeGroup, MatchMode.ANYWHERE));
			List<ActivityTypeGroup> activityTypeGroup = (List<ActivityTypeGroup>) crit.list(); 
			
			return activityTypeGroup;			
			
		}

}
