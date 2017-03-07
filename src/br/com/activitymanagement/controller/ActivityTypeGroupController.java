package br.com.activitymanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.activitymanagement.dao.ActivityTypeGroup;
import br.com.activitymanagement.service.ActivityTypeGroupService;

@Controller
public class ActivityTypeGroupController {
	
	private ActivityTypeGroupService activityTypeGroupService;
	
	@Autowired
	public void setActivityTypeGroupService(ActivityTypeGroupService activityTypeGroupService){
		this.activityTypeGroupService = activityTypeGroupService;
	}	
	
	@RequestMapping(value="/listactivitytypegroup")
	public String showListActivityTypeGroup(Model model, ActivityTypeGroup activityTypeGroup){
		
		List<ActivityTypeGroup> listActivityTypeGroup = null;
		
		if(activityTypeGroup.getDsActivityTypeGroup() != null){
			listActivityTypeGroup = activityTypeGroupService.getActivityTypeGroupByLikeDescription(activityTypeGroup.getDsActivityTypeGroup());
		}else{
			listActivityTypeGroup = activityTypeGroupService.getAllActivityTypeGroup();	
		}	
		
		model.addAttribute("listActivityTypeGroup", listActivityTypeGroup);
		
		return "activityTypeGroup";
	}

	@RequestMapping(value="/saveactivitytypegroup", method=RequestMethod.POST)
	public String saveActivityTypeGroup(Model model, ActivityTypeGroup activityTypeGroup){

		List<ActivityTypeGroup> listActivityTypeGroup = new ArrayList<ActivityTypeGroup>();		

		activityTypeGroup.setDtCreated(new Date());
		activityTypeGroup.setNmUserCreated("Maurício");
		
		try {
			activityTypeGroup = activityTypeGroupService.saveOrUpdate(activityTypeGroup);	
		} catch (Exception e) {
			return e.getMessage();
		}		

		if(activityTypeGroup!=null){

			listActivityTypeGroup.add(activityTypeGroup);

			model.addAttribute("listActivityTypeGroup", listActivityTypeGroup);
		}		
		
		return "activityTypeGroup";
	}
	
	@RequestMapping(value="/deleteactivitytypegroup", method=RequestMethod.POST)
	public String deleteActivityTypeGroup(Model model, ActivityTypeGroup activityTypeGroup){

		activityTypeGroupService.delete(activityTypeGroup);

		return "activityTypeGroup";
	}		

}
