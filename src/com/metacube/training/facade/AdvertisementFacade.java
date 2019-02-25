package com.metacube.training.facade;

import java.util.List;

import com.metacube.training.dao.AdvertisementDao;
import com.metacube.training.dao.BaseDao;
import com.metacube.training.dao.CategoryDao;
import com.metacube.training.enums.Status;
import com.metacube.training.factory.BaseFactory;
import com.metacube.training.model.Advertisement;
import com.metacube.training.model.Category;

public class AdvertisementFacade {

	AdvertisementDao advertisementDao = BaseFactory.createAdvertisementDao();
	CategoryDao categoryDao = BaseFactory.createCategoryDao();

	/**
	 * Method to insert advertisement
	 * 
	 * @param advertisement, advertisement object
	 * @return status
	 */
	public Status insertAdvertisement(Advertisement advertisement) {
		List<Advertisement> advertisementList = advertisementDao.getList();
		List<Category> categoryList = categoryDao.getList();

		for (Advertisement ad : advertisementList) {
			if (ad.getTitle().equals(advertisement.getTitle())) {
				return Status.DUPLICATE;
			}
		}

		for (Category category : categoryList) {

			if (category.getId() == advertisement.getId()) {
				return ((AdvertisementDao) advertisementDao).insert(advertisement);
			}
		}
		return Status.INVALID;
	}

	/**
	 * Method to return the list of all advertisements
	 * 
	 * @return list of advertisements
	 */
	public List<Advertisement> getAll() {
		return advertisementDao.getList();
	}

	/**
	 * Method to update the name of the advertisement
	 * 
	 * @param name of the advertisement
	 * @param id   of the advertisement
	 * @return status
	 */
	public Status updateName(Advertisement advertisement) {
		List<Advertisement> advertismentList = advertisementDao.getList();
		for (Advertisement ad : advertismentList) {
			if (ad.getId() == advertisement.getId()) {
				return ((AdvertisementDao) advertisementDao).update(ad);
			}
		}
		return Status.NOT_FOUND;

	}

	/**
	 * Method to delete the advertisement
	 * 
	 * @param id of the advertisement
	 * @return status
	 */
	public Status deleteAdvertisement(int id) {

		List<Advertisement> advertisementList = advertisementDao.getList();
		for (Advertisement ad : advertisementList) {
			if (ad.getId() == id) {
				return ((AdvertisementDao) advertisementDao).delete(id);
			}
		}
		return Status.NOT_FOUND;
	}

}
