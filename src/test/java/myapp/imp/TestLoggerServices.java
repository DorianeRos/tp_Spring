package myapp.imp;

import org.junit.*;

import myapp.services.ICalculator;
import myapp.services.ILogger;

public class TestLoggerServices {
	
	@Before
	public void beforeEachTest() {
		System.out.println("======================");
	}
	
	@After
	public void afterEachTest() {
		
	}

	//use a logger
	void use(ILogger logger) {
		logger.log("Voila le resultat = hello");
	}
	
	// Test StderrLogger
	@Test
	public void testStderrLogger() {
		//create the service
		StderrLogger logger = new StderrLogger();
		//start the service
		logger.start();
		//use the service
		use(logger);
		//stop the service
		logger.stop();
	}
	
	// Test StderrLogger
	@Test
	public void testBeanFileLogger() {
		//create the service
		BeanFileLogger logger = new BeanFileLogger();
		//set parameter
		logger.setFileName("tmp/myapp.log");
		//start the service
		logger.start();
		//use the service
		use(logger);
		//stop the service
		logger.stop();
	}
	
	@Test
	public void testFileLogger() {
		//create the service
		FileLogger logger = new FileLogger("tmp/myapp.log");
		//start the service
		logger.start();
		//use the service
		use(logger);
		//stop the service
		logger.stop();
	}
	
	void use(ICalculator calc) {
		calc.add(100, 200);
	}
	
	@Test
	public void testCalculatorAndStderrLogger() {
		
		//create and start the logger service (on stderr)
		StderrLogger logger = new StderrLogger();
		logger.start();//start the service
		
		//create, inject  and start the calculator service
		SimpleCalculator calculator = new SimpleCalculator();
		calculator.setLogger(logger);
		calculator.sart();//start the service
		//use the service
		use(calculator);
		//stop the service
		calculator.stop();
		// stop the logger service
		logger.stop();
	}
}
