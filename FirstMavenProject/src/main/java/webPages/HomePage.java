package webPages;

import configurePackage.PropertiesUtilities;

public class HomePage extends PropertiesUtilities {
	
	public void linksinHomePage() throws Exception {
		login();
		String titleOfHomePage = driver.getTitle();
		System.out.println(titleOfHomePage);


	}
	public static void main(String[] args) throws Exception {
		
		HomePage obj = new HomePage();
		obj.linksinHomePage();
	}
		
		
	}

