package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// Spring 
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		TV tv1 = (TV) factory.getBean("samsungTV");
		TV tv2 = (TV) factory.getBean("lgTV");
  
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();

		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();

		factory.close();
		
		/////////////////////////////////////////////////
//		BeanFactory factory = new BeanFactory(); // 디자인 패턴
//		TV tv = (TV) factory.getBean(args[0]);
//		TV tv = (TV) factory.getBean("samsung");
//		TV tv = (TV) factory.getBean("lg");
//		TV tv = new SamsungTV();
//		TV tv = new LgTV();
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
	}

}
