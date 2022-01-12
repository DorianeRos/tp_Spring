package myapp.imp;

import java.util.Date;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import myapp.services.ILogger;

@Service

public class StderrLogger implements ILogger{
	
	/**public void start() {
		System.out.println("Start " + this);
	}

	public void stop() {
		System.out.println("Stop " + this);
	}*/
	
		//start service
	@PostConstruct
	public void start() {
		
	}
	
	//stop service
	@PreDestroy
	public void stop(){
		
	}
	@Override
	public void log(String message) {
		System.out.printf("%tF %1$tR | %s\n", new Date(), message);
	}
	

	
	
	
}
