package com.csl.foosball.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csl.foosball.model.Player;

@Controller
@RequestMapping("/player")
public class PlayerController  {
	
	@RequestMapping(path = "/find", method = RequestMethod.GET)
	@ResponseBody
	public List<Player> findAll(){
		return Arrays.asList(new Player());
	}

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	@ResponseBody
	public List<Player> admin(){
		return Arrays.asList(new Player());
	}
	
	@RequestMapping(path = "/user", method = RequestMethod.GET)
	@ResponseBody
	public List<Player> user(){
		return Arrays.asList(new Player());
	}
}
