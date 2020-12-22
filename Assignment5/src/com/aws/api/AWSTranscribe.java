package com.aws.api;


public interface AWSTranscribe {
	public String getStreamFromFile(String audioFileName);
	public void startStreamTranscription(String client, String stream);
	public String getResult();
	public String clientCreate();
	public void clientClose(String client);
}
