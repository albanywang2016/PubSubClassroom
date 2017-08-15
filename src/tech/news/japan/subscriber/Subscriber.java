package tech.news.japan.subscriber;

import java.util.ArrayList;
import java.util.List;

import tech.news.japan.pubsub.PubSubMessage;
import tech.news.japan.service.PubSubService;

public abstract class Subscriber {
	private List<PubSubMessage> subscriberMessage = new ArrayList<PubSubMessage>();

	public List<PubSubMessage> getSubscriberMessage() {
		return subscriberMessage;
	}

	public void setSubscriberMessage(List<PubSubMessage> subscriberMessage) {
		this.subscriberMessage = subscriberMessage;
	}
	
	public abstract void addSubscriber(String topic, PubSubService service);
	
	public abstract void unSubscriber(String topic, PubSubService service);
	
	public abstract void getMessageForSubscriberOfTopic(String topic, PubSubService service);
	
	public void printMessages(){
		for(PubSubMessage message : subscriberMessage){
			System.out.println("Message Topic --> " + message.getTopic() + " : " + message.getPayLoad());
		}
	}

}
