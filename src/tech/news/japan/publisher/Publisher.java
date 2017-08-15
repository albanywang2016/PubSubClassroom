package tech.news.japan.publisher;

import tech.news.japan.pubsub.PubSubMessage;
import tech.news.japan.service.PubSubService;

public interface Publisher {
	void publish(PubSubMessage message, PubSubService service);

}
