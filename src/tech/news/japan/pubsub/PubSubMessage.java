package tech.news.japan.pubsub;

public class PubSubMessage {
	
	private String topic;
	private String payLoad;
	
	public PubSubMessage() {
		super();
	}
	public PubSubMessage(String topic, String payLoad) {
		super();
		this.topic = topic;
		this.payLoad = payLoad;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}
	
	

}
