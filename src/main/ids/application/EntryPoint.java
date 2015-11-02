package main.ids.application;

import main.ids.integration.dao.factory.QueryFactory;
import main.ids.integration.mySqlDao.factory.SqlQueryFactory;

public class EntryPoint {
	
	public static void main(String[] args) {
		QueryFactory qf = SqlQueryFactory.getInstance();
		System.out.println(qf.getQuery("Autednticazione"));
	}
	
	
}
