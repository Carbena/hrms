package com.javakamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.ImageService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.ImageRepository;
import com.javakamp.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageRepository imageRepo;
	
	@Autowired
	public ImageManager(ImageRepository imageRepo) {
		super();
		this.imageRepo = imageRepo;
	}

	@Override
	public Result add(Image image) {
		imageRepo.save(image);
		return new SuccessResult("resim kaydedildi");
	}

	@Override
	public Result update(Image image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int imageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
