package com.gap.timesheet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StatusValidation {
	public static void verifyStatus( WebDriver driver,String date , Logger log) {
		WebElement timesheetStatus = driver.findElement(By.xpath("//select[@name='ff_status']"));
		Select selTimesheetStatus = new Select(timesheetStatus);
		selTimesheetStatus.deselectByValue("open");
		selTimesheetStatus.selectByValue("1");
		driver.findElement(By.name("applyFilter")).click();
		String strstatustable = "//div[@class='ppm_gridcontent']//table[@class='ppm_grid']";
		WebElement statusTable = driver.findElement(By.xpath(strstatustable));
		if(statusTable.isDisplayed()) {
			String actualStatus =	driver.findElement(By.xpath(strstatustable+"/tbody/tr")).getText();
			String strFromDate = date.split("-")[0].trim();
			if(actualStatus.contains(strFromDate) && actualStatus.contains("Submitted"))
				log.info("Pass, TimeSheet submitted successfully");
			else
				log.error("Fail, Timesheet Not submitted successfully");

		}
		else
			log.error("Status Table is not loaded Properly");

	}

}
