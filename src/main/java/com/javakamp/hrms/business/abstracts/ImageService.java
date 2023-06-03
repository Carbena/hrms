package com.javakamp.hrms.business.abstracts;

import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.Image;

public interface ImageService {

	Result add(Image image);
	Result update(Image image);
	Result delete(int imageId);
}
