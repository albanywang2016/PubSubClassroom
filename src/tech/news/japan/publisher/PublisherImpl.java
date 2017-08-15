package tech.news.japan.publisher;

import tech.news.japan.pubsub.PubSubMessage;
import tech.news.japan.service.PubSubService;

public class PublisherImpl implements Publisher{

	@Override
	public void publish(PubSubMessage message, PubSubService service) {
		// TODO Auto-generated method stub
		service.addMessageToQueue(message);
	}

}
