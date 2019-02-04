package com.frank.selenium.utils.datasource;

public class CaseInputDataManager {

	
	public static IDataSource getDataSourceManager(String methord, String[] params) {

		if(methord.equalsIgnoreCase("properties"))
			return new PropertyManager(params[0]);
		else if(methord.equalsIgnoreCase("mongo"))
			return new MongoManager(params[0],params[1]);
		else
			return new PropertyManager(params[0]);
	}

}
