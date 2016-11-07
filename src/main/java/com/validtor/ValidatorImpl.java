package com.validtor;

import com.bean.Address;
import com.bean.Bank;
import com.bean.PersonalInfo;

public class ValidatorImpl implements Validator  {
	/* (non-Javadoc)
	 * @see com.validtor.Validator#isDataEmpty(java.lang.String)
	 */
	@Override
	public  boolean isDataEmpty(String data) {
		return (data==null || data.trim().length()==0);
	}
	
	/* (non-Javadoc)
	 * @see com.validtor.Validator#addressValidator(com.bean.Address)
	 */
	@Override
	public String addressValidator(Address address)
	{
		//StringBuffer sb=new StringBuffer();
		String errors="";
		if(isDataEmpty(address.getAddress()))
		{
			errors+="Enter Address<br>";
		}
		if(isDataEmpty(address.getCity()))
		{
			errors+="Select City<br>";
		}
		if(isDataEmpty(address.getState()))
		{
			errors+="Select City<br>";
		}
	    if(isDataEmpty(address.getCountry()))
		{
			errors+="Select Country<br>";
		}
	    if(isDataEmpty(address.getPinCode()))
	    {
	    	errors+="Enter Pincode";
	    }
	    if(isDataEmpty(address.getPinCode())==false)
	    {
	    	if(isNumeric(address.getPinCode())==false)
	    	{
	    		errors+="Pincode must be Numeric";	    		
	    	}
	    	
	    }
		return errors;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see com.validtor.Validator#personalValidator(com.bean.PersonalInfo)
	 */
	@Override
	public String personalValidator(PersonalInfo pb) {
		StringBuffer allErrorMsg= new StringBuffer();
        String errMsg=getData(pb.getFirstName());
        if(errMsg=="")
        {
        	allErrorMsg.append("Enter First Name ");
        }
        
        errMsg=getData(pb.getMiddletName());
        if(errMsg=="")
        {
        	allErrorMsg.append("Enter MiddleName ");
        }
        
        errMsg=getData(pb.getLastName());
        if(errMsg=="")
        {
        	allErrorMsg.append("Enter Last Name ");
        }
        errMsg=getData(pb.getGender());
        if(errMsg=="")
        {
        	allErrorMsg.append("Select Gender ");
        }
       // allErrorMsg.append(pb.getGender());
        System.out.println(allErrorMsg.toString());
        return allErrorMsg.toString();
		
		
		
	}
	/* (non-Javadoc)
	 * @see com.validtor.Validator#bankValidator(com.bean.Bank)
	 */
	@Override
	public String bankValidator(Bank b)
	{
		String errorMsg="";
		if(isDataEmpty(b.getBankName()))
		{
			errorMsg+="Select Bank name<br>";
		}
		if(isDataEmpty(b.getAccountNumber()))
		{
			errorMsg+="Enter Account Number<br>";
		}
		if(isDataEmpty(b.getSsn()))
		{
			errorMsg+="Enter SSN<br>";
		}
		return errorMsg;
	}
	
	public static String getData(String data)
	{
			if(data==null || data.trim().length()==0)
			{
				data="";
				return data;
			}
		  return data;
	}
	public static boolean isNumeric(String s)
    {
		try
		{
		Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
				return false;
		}
		return true;
   }
}
