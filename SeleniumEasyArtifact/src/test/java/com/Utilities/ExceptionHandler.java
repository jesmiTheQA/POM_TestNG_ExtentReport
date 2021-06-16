package com.Utilities;

public class ExceptionHandler {
	public void errorMessage(String method,String error) {
		try {
			
			System.out.println("Error is from "+method+"_"+error);
		}
		catch(Exception e){
			
			System.out.println("Error is from errorMessage()"+e.toString());
		}
	
	}

}
