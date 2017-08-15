package tech.news.japan.pubsub;

import tech.news.japan.publisher.Publisher;
import tech.news.japan.publisher.PublisherImpl;
import tech.news.japan.service.PubSubService;
import tech.news.japan.subscriber.Subscriber;
import tech.news.japan.subscriber.SubscriberImpl;

public class DriverClass {
	
	public static void main(String[] args){
		Publisher javaPublisher = new PublisherImpl();
		Publisher pythonPublisher = new PublisherImpl();

		Subscriber javaSubscriber = new SubscriberImpl();
		Subscriber allLanguagesSubscriber = new SubscriberImpl();
		Subscriber pythonSubscriber = new SubscriberImpl();
		
		PubSubService pubSubService = new PubSubService();
		
		//Declare Messages and Publish Messages to PubSubService
		PubSubMessage javaMsg1 = new PubSubMessage("Java", "Core Java Concepts");
		PubSubMessage javaMsg2 = new PubSubMessage("Java", "Spring MVC : Dependency Injection and AOP");
		PubSubMessage javaMsg3 = new PubSubMessage("Java", "JPA & Hibernate");
		
		javaPublisher.publish(javaMsg1, pubSubService);
		javaPublisher.publish(javaMsg2, pubSubService);
		javaPublisher.publish(javaMsg3, pubSubService);
		
		PubSubMessage pythonMsg1 = new PubSubMessage("Python", "Easy and Powerful programming language");
		PubSubMessage pythonMsg2 = new PubSubMessage("Python", "Advanced Python message");
		
		pythonPublisher.publish(pythonMsg1, pubSubService);
		pythonPublisher.publish(pythonMsg2, pubSubService);
		
		//Declare Subscribers 
		javaSubscriber.addSubscriber("Java",pubSubService);		//Java subscriber only subscribes to Java topics
		pythonSubscriber.addSubscriber("Python",pubSubService);   //Python subscriber only subscribes to Python topics
		allLanguagesSubscriber.addSubscriber("Java", pubSubService);	//all subscriber, subscribes to both Java and Python
		allLanguagesSubscriber.addSubscriber("Python", pubSubService);
		
		//Trying unSubscribing a subscriber
		//pythonSubscriber.unSubscribe("Python", pubSubService);
		
		//Broadcast message to all subscribers. After broadcast, messageQueue will be empty in PubSubService
		pubSubService.broadcast();
		
		//Print messages of each subscriber to see which messages they got
		System.out.println("Messages of Java Subscriber are: ");
		javaSubscriber.printMessages();
		
		System.out.println("\nMessages of Python Subscriber are: ");
		pythonSubscriber.printMessages();
		
		System.out.println("\nMessages of All Languages Subscriber are: ");
		allLanguagesSubscriber.printMessages();
		
		//After broadcast the messagesQueue will be empty, so publishing new messages to server
		System.out.println("\nPublishing 2 more Java Messages...");
		PubSubMessage javaMsg4 = new PubSubMessage("Java", "JSP and Servlets");
		PubSubMessage javaMsg5 = new PubSubMessage("Java", "Struts framework");
		
		javaPublisher.publish(javaMsg4, pubSubService);
		javaPublisher.publish(javaMsg5, pubSubService);
		
		javaSubscriber.getMessageForSubscriberOfTopic("Java", pubSubService);
		System.out.println("\nMessages of Java Subscriber now are: ");
		javaSubscriber.printMessages();				
		
		
	}

}
