package com.javakamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.LinkService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.LinkRepository;
import com.javakamp.hrms.entities.concretes.Link;

@Service

public class LinkManager implements LinkService{

	private LinkRepository linkRepo;
	
	@Autowired
	public LinkManager(LinkRepository linkRepo) {
		super();
		this.linkRepo = linkRepo;
	}

	@Override
	public Result add(Link link) {
		linkRepo.save(link);
		return new SuccessResult("url adresi eklendi");
	}

	@Override
	public Result update(Link link) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int linkId) {
		// TODO Auto-generated method stub
		return null;
	}

}
