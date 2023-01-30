package com.tracker.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CoronaVirusDataService {

	private static String Virus_Data_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";
	
	@PostConstruct
	public void fetchVirusData() throws IOException, InterruptedException
	{
	HttpClient client = HttpClient.newHttpClient();
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(Virus_Data_URL))
			.build();
	HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
	System.out.println(httpResponse.body());
	
	}
	
}
