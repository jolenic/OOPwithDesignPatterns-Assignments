package com.google.api;

public class GoogleSpeech2TextProxy implements GoogleSpeech2Text {
	
	private static GoogleSpeech2TextAPI api;

	@Override
	public String instantiateClient() {
		if (api == null) {
			api = new GoogleSpeech2TextAPI();
		}
		return api.instantiateClient();
	}

	@Override
	public String fileToMemory(String fileName) {
		if (api == null) {
			api = new GoogleSpeech2TextAPI();
		}
		return api.fileToMemory(fileName);
	}

	@Override
	public String buildSyncRecognizeRequestConfig() {
		if (api == null) {
			api = new GoogleSpeech2TextAPI();
		}
		return api.buildSyncRecognizeRequestConfig();
	}

	@Override
	public String buildSyncRecognizeRequestAudio() {
		// TODO Auto-generated method stub
		if (api == null) {
			api = new GoogleSpeech2TextAPI();
		}
		return api.buildSyncRecognizeRequestAudio();
	}

	@Override
	public void performSpeechRecognition(String config, String audio) {
		// TODO Auto-generated method stub
		if (api == null) {
			api = new GoogleSpeech2TextAPI();
		}
		api.performSpeechRecognition(config, audio);
	}

	@Override
	public String getFirstTranscriptAlternative() {
		// TODO Auto-generated method stub
		if (api == null) {
			api = new GoogleSpeech2TextAPI();
		}
		return api.getFirstTranscriptAlternative();
	}

}
