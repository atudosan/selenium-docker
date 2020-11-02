package com.automationpractice.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverFactory {

	private RemoteWebDriver driver;
	private Logger log;
	private DesiredCapabilities dc;

	public BrowserDriverFactory(Logger log) {
		this.log = log;
	}

	public RemoteWebDriver createDriver() throws MalformedURLException {

		log.info("Create remote driver");

		String host = "localhost";
		dc = DesiredCapabilities.chrome();

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
					
		}
		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		String completeUrl = "http://" + host + ":4444/wd/hub";
		driver = new RemoteWebDriver(new URL(completeUrl), dc);
		log.info("Remote driver is set ");
		return driver;

	}

}
