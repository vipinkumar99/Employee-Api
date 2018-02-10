package com.emp.constants;

public interface PathMapping {
	String BASE="/";
	String All="/all";
	String SAVE="/save";
	String ID="id";
	String ID_PARAM="/{"+ID+"}";
	String NAME="name";
	String NAME_PARAM = "/name/{"+NAME+"}";
	String UDATE="/update";
	String CID="id";
	String CATEGORY_ID = "/category/{"+CID+"}";
	
	interface EmployeeMapping
	{
		String Base="/employee";
	}

	interface CompanyMapping
	{
		String Base="/company";
	}

	interface CategoryMapping
	{
		String Base="/category";
	}

	interface ItemMapping
	{
		String Base="/item";
	}

	
}
