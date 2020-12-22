package com.aws.api;


public class AWSTranscribeProxy implements AWSTranscribe{

	private static AWSTranscribeAPI api;
	
	@Override
	public String getStreamFromFile(String audioFileName) {
		if (api == null) {
			api = new AWSTranscribeAPI();
		}
		return api.getStreamFromFile(audioFileName);
	}

	@Override
	public void startStreamTranscription(String client, String stream) {
		if (api == null) {
			api = new AWSTranscribeAPI();
		}
		api.startStreamTranscription(client, stream);
	}

	@Override
	public String getResult() {
		if (api == null) {
			api = new AWSTranscribeAPI();
		}
		return api.getResult();
	}

	@Override
	public String clientCreate() {
		if (api == null) {
			api = new AWSTranscribeAPI();
		}
		return api.clientCreate();
	}

	@Override
	public void clientClose(String client) {
		// TODO Auto-generated method stub
		if (api == null) {
			api = new AWSTranscribeAPI();
		}
		api.clientClose(client);
	}

}
