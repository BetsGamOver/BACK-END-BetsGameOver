package edu.eci.ieti.betsGameOver.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service("api")
public class FootballDataApi {
	
	private final String HOST = "https://api.football-data.org";
	private final String TOKEN = "5cfdd1e52cda41cd9a0b110837d77aff";
	
	private StringBuffer makeGetPetition(String uri, String params)  throws MalformedURLException, IOException {
		// Creating Request
		URL url = new URL(HOST+uri+params);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		// Setting Request Values
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("X-Auth-Token", TOKEN);
		// Reading Response
		StringBuffer content = new StringBuffer();
		BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while ((inputLine = input.readLine()) != null) {
			content.append(inputLine);
		}
		input.close();
		connection.disconnect();
		return content;
	}
	
	public String getLeagueMatches(String league, String status) throws MalformedURLException, IOException {
		String uri = "/v2/competitions/"+league+"/matches";
		String params = "?status="+status;
		StringBuffer content = makeGetPetition(uri, params);
		return content.toString();
	}
	
	public String getAllLeagueTeams(String league) throws MalformedURLException, IOException {
		String uri = "/v2/competitions/"+league+"/teams";
		String params = "";
		StringBuffer content = makeGetPetition(uri, params);
		return content.toString();
	}

	public String getLeagueTable(String league) throws MalformedURLException, IOException {
		String uri = "/v2/competitions/"+league+"/standings";
		String params = "?standingType=TOTAL";
		StringBuffer content = makeGetPetition(uri, params);
		return content.toString();
	}

	public String getLeagueInformation(String league) throws MalformedURLException, IOException {
		String uri = "/v2/competitions/"+league;
		String params = "";
		StringBuffer content = makeGetPetition(uri, params);
		return content.toString();
	}

	public String getLeagueGoalScorers(String league) throws MalformedURLException, IOException {
		String uri = "/v2/competitions/"+league+"/scorers";
		String params = "";
		StringBuffer content = makeGetPetition(uri, params);
		return content.toString();
	}

	public String getTeamMatches(String team, String status) throws MalformedURLException, IOException {
		String uri = "/v2/teams/"+team+"/matches/";
		String params = "?status="+status;
		StringBuffer content = makeGetPetition(uri, params);
		return content.toString();
	}
}