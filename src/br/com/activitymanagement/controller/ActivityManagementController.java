package br.com.activitymanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.activitymanagement.model.entity.ActivityType;
import br.com.activitymanagement.model.entity.ActivityTypeGroup;
import br.com.activitymanagement.service.ActivityTypeGroupService;
import br.com.activitymanagement.service.ActivityTypeService;

@Controller
public class ActivityManagementController {
	
	private ActivityTypeService activityTypeService;
	private ActivityTypeGroupService activityTypeGroupService;
	
	@Autowired
	public void setActivityTypeService(ActivityTypeService activityTypeService){
		this.activityTypeService = activityTypeService;
	}	
	
	@Autowired
	public void setActivityTypeGroupService(ActivityTypeGroupService activityTypeGroupService){
		this.activityTypeGroupService = activityTypeGroupService;
	}		
	
	@RequestMapping("/activitytype")
	public String showActivityType(Model model){

		List<ActivityTypeGroup> listActivityTypeGroup = new ArrayList<>();

		listActivityTypeGroup = activityTypeGroupService.getAllActivityTypeGroup();	
		
		model.addAttribute("listActivityTypeGroup", listActivityTypeGroup);		
		
		return "activityType";	
	}		
	
	@RequestMapping(value="/listactivitytype")
	public String showListActivityType(Model model, ActivityType activityType){
		
		List<ActivityType> listActivityType = null;

		if(activityType.getDsActivityType() != null){
			listActivityType = activityTypeService.getActivityTypeByLikeDescription(activityType.getDsActivityType());
		}else{
			listActivityType = activityTypeService.getAllActivityType();	
		}	
		
		List<ActivityTypeGroup> listActivityTypeGroup = new ArrayList<>();
		listActivityTypeGroup = activityTypeGroupService.getAllActivityTypeGroup();	
		
		model.addAttribute("listActivityTypeGroup", listActivityTypeGroup);				
		model.addAttribute("listActivityType", listActivityType);
		
		return "activityType";
	}
	
	@RequestMapping(value="/saveactivitytype", method=RequestMethod.POST)
	public String saveActivityType(Model model, ActivityType activityType, ActivityTypeGroup activityTypeGroup){

		List<ActivityType> listActivityType = new ArrayList<ActivityType>();		
		
		ActivityType activityTypeData = new ActivityType(activityType.getIdActivityType(),activityType.getDsActivityType(), new Date(), "Mauríco",activityTypeGroup);
		
		try {
			activityType = activityTypeService.saveOrUpdate(activityTypeData);	
		} catch (Exception e) {
			return e.getMessage();
		}		

		if(activityType!=null){

			listActivityType.add(activityType);

			model.addAttribute("listActivityType", listActivityType);
		}		
		
		return "activityType";
	}
	
	@RequestMapping(value="/deleteactivitytype", method=RequestMethod.POST)
	public String deleteActivityType(Model model, ActivityType activityType){

		activityTypeService.delete(activityType);

		return "activityType";
	}		

}
