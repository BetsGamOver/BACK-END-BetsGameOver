package edu.eci.ieti.betsGameOver.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.betsGameOver.service.FootballService;

@RestController
@RequestMapping(value = "/football")
public class FootballController {
	
	@Resource(name = "footballService")
	private FootballService footballService;
	
	@RequestMapping(
			path = "/matches/{league}/{status}",
			method = RequestMethod.GET,
			produces = "application/json"
	)
	public ResponseEntity<?> getLeagueMatchesByStatus(@PathVariable("league") String league, @PathVariable("status") String status) {
		String response;
		try {
			response = footballService.getAllLeagueMatches(league, status);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			response = "{message:'"+e.getMessage()+"'}";
			Logger.getLogger(FootballController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(
			path = "/teams/{league}",
			method = RequestMethod.GET,
			produces = "application/json"
	)
	public ResponseEntity<?> getAllLeagueTeams(@PathVariable("league") String league) {
		String response;
		try {
			response = footballService.getAllLeagueTeams(league);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			response = "{message:'"+e.getMessage()+"'}";
			Logger.getLogger(FootballController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(
			path = "/table/{league}",
			method = RequestMethod.GET,
			produces = "application/json"
	)
	public ResponseEntity<?> getLeagueTable(@PathVariable("league") String league) {
		String response;
		try {
			response = footballService.getLeagueTable(league);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			response = "{message:'"+e.getMessage()+"'}";
			Logger.getLogger(FootballController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(
			path = "/information/{league}",
			method = RequestMethod.GET,
			produces = "application/json"
	)
	public ResponseEntity<?> getLeagueInformation(@PathVariable("league") String league) {
		String response;
		try {
			response = footballService.getLeagueInformation(league);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			response = "{message:'"+e.getMessage()+"'}";
			Logger.getLogger(FootballController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(
			path = "/scorers/{league}",
			method = RequestMethod.GET,
			produces = "application/json"
	)
	public ResponseEntity<?> getLeagueGoalScorers(@PathVariable("league") String league) {
		String response;
		try {
			response = footballService.getLeagueGoalScorers(league);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			response = "{message:'"+e.getMessage()+"'}";
			Logger.getLogger(FootballController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(
			path = "/teamMatches/{team}/{status}",
			method = RequestMethod.GET,
			produces = "application/json"
	)
	public ResponseEntity<?> getTeamMatches(@PathVariable("team") String team, @PathVariable("status") String status) {
		String response;
		try {
			response = footballService.getTeamMatches(team, status);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			response = "{message:'"+e.getMessage()+"'}";
			Logger.getLogger(FootballController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
}