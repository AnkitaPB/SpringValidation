package com.controller;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bean.Address;
import com.bean.Bank;
import com.bean.PersonalVO;
import com.service.PersonalService;

@Controller
@SessionAttributes({"personalVO","contactVO","bankVO"})
public class PersonalController {
	@Autowired
	PersonalService personalBO=null;
	
	
	
	Validator validator;
	public PersonalController() {
		ValidatorFactory validationFactory=Validation.buildDefaultValidatorFactory();
		validator=validationFactory.getValidator();
	}
	
	@RequestMapping("/addNew")
	public String setupPersonalForm(Model model)
	{
		model.addAttribute("personalVO",new PersonalVO());
		return "addpersonalInfo";
	}
	
	@RequestMapping(value="/addpersonalInfo",method= RequestMethod.POST)
	public String addPersonalInfo(@ModelAttribute PersonalVO personalVO, BindingResult result, SessionStatus status,Model model)
	{
		System.out.println("personalInfo: Started");
		Set<ConstraintViolation<PersonalVO>> violations=validator.validate(personalVO);
		for(ConstraintViolation<PersonalVO> violation: violations)
		{
			String propertyPath=violation.getPropertyPath().toString();
			String message=violation.getMessage();
			result.addError(new FieldError("personalVO", propertyPath, "Invalid("+message+")"));
		}
		if(result.hasErrors())
		{
			return "addpersonalInfo";
		}
		System.out.println("addPersonalController Ended");
		model.addAttribute("contactVO", new Address());
		return "contact";
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.POST)
	public String addContactInfo(@ModelAttribute("contactVO") Address contactVO, BindingResult result, Model model) throws Exception
	{
		Set<ConstraintViolation<Address>> violations=validator.validate(contactVO);
		for(ConstraintViolation<Address> violation: violations)
		{
			String propertyPath=violation.getPropertyPath().toString();
			String message=violation.getMessage();
			result.addError(new FieldError("contactVO", propertyPath, "Invalid("+message+")"));
		}
		if(result.hasErrors())
		{
			return "contact";
		}
		System.out.println("55555555555"+contactVO.getAddress());
		model.addAttribute("bankVO", new Bank());

	//	addressBO.insertAddress((PersonalVO)model.get("personalVO"),(Address)model.get("contactVO"));
		return "bankInfo";
	}
	
	@RequestMapping(value="/bankInfo",method=RequestMethod.POST)
	public String addBankInfo(@ModelAttribute("bankVO") Bank bankVO, BindingResult result, Model model,ModelMap mapModel) throws Exception
	{
		Set<ConstraintViolation<Bank>> violations=validator.validate(bankVO);
		for(ConstraintViolation<Bank> violation: violations)
		{
			String propertyPath=violation.getPropertyPath().toString();
			String message=violation.getMessage();
			result.addError(new FieldError("bankVO", propertyPath, "Invalid("+message+")"));
		}
		if(result.hasErrors())
		{
			return "bankInfo";
		}
		System.out.println("&&&&&&"+bankVO.getBankName());
        PersonalVO personalVO=(PersonalVO)mapModel.get("personalVO");
        System.out.println("PersonalVO"+personalVO.getFirstName());
        Address contactVO=(Address)mapModel.get("contactVO");
        System.out.println("ContactVO"+ contactVO.getAddress() +" "+contactVO.getCountry() +" "+contactVO.getState() );
        bankVO=(Bank)mapModel.get("bankVO");
        System.out.println("BankVO"+bankVO.getAccountNumber()+bankVO.getSsn()+bankVO.getBankName());

		personalBO.insertPersonalDetail(personalVO,contactVO,bankVO);
		     return "success";
	}
	
}
