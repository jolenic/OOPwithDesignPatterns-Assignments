package com.google.api;

public interface GoogleSpeech2Text {
	public String instantiateClient();
	public String fileToMemory(String fileName);
	public String buildSyncRecognizeRequestConfig();
	public String buildSyncRecognizeRequestAudio();
	public void performSpeechRecognition(String config, String audio);
	public String getFirstTranscriptAlternative();
}
