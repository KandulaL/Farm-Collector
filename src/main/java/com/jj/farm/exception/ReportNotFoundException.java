package com.jj.farm.exception;

public class ReportNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReportNotFoundException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}
