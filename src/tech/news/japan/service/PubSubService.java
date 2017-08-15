package tech.news.japan.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import tech.news.japan.pubsub.PubSubMessage;
import tech.news.japan.subscriber.Subscriber;

public class PubSubService {
	
	//Keeps set of subscriber topic wise, using set to prevent duplicates 
	Map<String, Set<Subscriber>> subscriberTopicMap = new HashMap<String, Set<Subscriber>>();
	
	//Holds messages published by publishers
	Queue<PubSubMessage> messageQueue = new LinkedList<PubSubMessage>();
	
	//Adds message sent by publisher to queue
	public void addMessageToQueue(PubSubMessage message){
		this.messageQueue.add(message);
	}
	
	//Add a new Subscriber for a topic
	public void addSubscriber(String topic, Subscriber susbcriber){
		if(this.subscriberTopicMap.containsKey(topic)){
			Set<Subscriber> subscribers = this.subscriberTopicMap.get(topic);
			subscribers.add(susbcriber);
			this.subscriberTopicMap.put(topic, subscribers);
		}else{
			Set<Subscriber> subscribers = new HashSet<Subscriber>();
			subscribers.add(susbcriber);
			this.subscriberTopicMap.put(topic, subscribers);
		}
	}
	
	//Remove an existing subscriber for a topic
	public void removeSubscriber(String topic, Subscriber subscriber){
		if(this.subscriberTopicMap.containsKey(topic)){
			Set<Subscriber> subscribers = this.subscriberTopicMap.get(topic);
			subscribers.remove(subscriber);
			this.subscriberTopicMap.put(topic, subscribers);
		}
	}

	//Broadcast new messages added in queue to All subscribers of the topic. messagesQueue will be empty after broadcasting
	public void broadcast(){
		if(this.messageQueue.isEmpty()){
			System.out.println("No messages from publishers to display");
		}else{
			while(!this.messageQueue.isEmpty()){
				PubSubMessage message = this.messageQueue.remove();
				String topic = message.getTopic();
				Set<Subscriber> subscriberOfTopic = this.subscriberTopicMap.get(topic);
				
				for(Subscriber subscriber : subscriberOfTopic){
					List<PubSubMessage> subscriberMessages = subscriber.getSubscriberMessage();
					subscriberMessages.add(message);
					subscriber.setSubscriberMessage(subscriberMessages);
				}
			}
		}
	}
	
	public void getMessageForSubscriberOfTopic(String topic, Subscriber subscriber){
		if(this.messageQueue.isEmpty()){
			System.out.println("No messages from publishers to display");
		}else{
			while(!this.messageQueue.isEmpty()){
				PubSubMessage message = this.messageQueue.remove();
				
				if(message.getTopic().equalsIgnoreCase(topic)){
					Set<Subscriber> subscriberOfTopic = this.subscriberTopicMap.get(topic);
					for(Subscriber _subscriber : subscriberOfTopic){
						List<PubSubMessage> subscriberMessages = subscriber.getSubscriberMessage();
						subscriberMessages.add(message);
						subscriber.setSubscriberMessage(subscriberMessages);
					}
				}
			}
		}
	}
	
	
	
	
}
