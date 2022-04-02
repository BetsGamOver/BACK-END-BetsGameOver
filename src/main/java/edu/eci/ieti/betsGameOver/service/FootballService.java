package edu.eci.ieti.betsGameOver.service;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.eci.ieti.betsGameOver.external.FootballDataApi;

@Service("footballService")
public class FootballService {
	
	@Resource(name = "api")
	FootballDataApi api;
	
	public String getAllLeagueMatches(String league, String status) throws MalformedURLException, IOException {
		String response = api.getLeagueMatches(league, status);
		return response;
	}
	
	public String getAllLeagueTeams(String league) throws MalformedURLException, IOException {
		String response = api.getAllLeagueTeams(league);
		return response;
	}
	
	public String getLeagueTable(String league) throws MalformedURLException, IOException {
		String response = api.getLeagueTable(league);
		return response;
	}

	public String getLeagueInformation(String league) throws MalformedURLException, IOException {
		String response = api.getLeagueInformation(league);
		return response;
	}

	public String getLeagueGoalScorers(String league) throws MalformedURLException, IOException {
		String response = api.getLeagueGoalScorers(league);
		return response;
	}

	public String getTeamMatches(String team, String status) throws MalformedURLException, IOException {
		String response = api.getTeamMatches(team, status);
		return response;
	}
}