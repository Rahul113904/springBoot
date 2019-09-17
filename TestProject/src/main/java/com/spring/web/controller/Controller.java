package com.spring.web.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.dao.GitUser;
import com.spring.web.repo.Repo;

@Service
@Transactional
@RestController
public class Controller 
{
	@Autowired 
	private Repo repo;
	
	@RequestMapping("/")
	public String homePage(){
		return "index";
	}
	
	@RequestMapping("/new")
	public String addUser(Model model)
	{
		GitUser gituser = new GitUser();
		model.addAttribute("gitdetail", gituser);
		System.out.println("succes");		
		return "add";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("gitdetail") GitUser gituser) {
        repo.save(gituser);
         
        return "redirect:/";
    }
}
