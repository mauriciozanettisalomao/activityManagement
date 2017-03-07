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

@Component("activityTypeDao")
public class ActivityTypeDao {
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public Session session() {
			return sessionFactory.getCurrentSession();
		}
		
		public ActivityType saveOrUpdate(ActivityType activityType) {
			session().saveOrUpdate(activityType);	
			
			return activityType;
		}

		@SuppressWarnings("unchecked")
		public List<ActivityType> getAllActivityTypeDao() {
			
			return session().createQuery("from ActivityType").list();
		}

		public ActivityType getActivityTypeByIdDao(int id) {
			
			Criteria crit = session().createCriteria(ActivityType.class);
			crit.add(Restrictions.idEq(id));
			ActivityType activityType = (ActivityType) crit.uniqueResult(); 
			
			return activityType;
			
		}

		public void delete(ActivityType activityType) {
			Query query = session().createQuery("delete from ActivityType where idActivityType = :idActivityType");
			query.setLong("idActivityType", activityType.getIdActivityType());
			query.executeUpdate();
			
		}

		public List<ActivityType> getActivityTypeByLikeDescription(String dsActivityType) {

			Criteria crit = session().createCriteria(ActivityType.class);
			crit.add(Restrictions.like("dsActivityType", dsActivityType, MatchMode.ANYWHERE));
			List<ActivityType> activityType = (List<ActivityType>) crit.list(); 
			
			return activityType;			
			
		}

}
