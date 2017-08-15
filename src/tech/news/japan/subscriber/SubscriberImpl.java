package tech.news.japan.subscriber;

import tech.news.japan.service.PubSubService;

public class SubscriberImpl extends Subscriber{

	@Override
	public void addSubscriber(String topic, PubSubService service) {
		// TODO Auto-generated method stub
		service.addSubscriber(topic, this);
	}

	@Override
	public void unSubscriber(String topic, PubSubService service) {
		// TODO Auto-generated method stub
		service.removeSubscriber(topic, this);
	}

	@Override
	public void getMessageForSubscriberOfTopic(String topic, PubSubService service) {
		// TODO Auto-generated method stub
		service.getMessageForSubscriberOfTopic(topic, this);
	}

}
