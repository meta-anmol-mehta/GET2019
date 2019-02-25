package com.metacube.training.factory;

import com.metacube.training.dao.AdvertisementDao;
import com.metacube.training.dao.CategoryDao;
import com.metacube.training.facade.AdvertisementFacade;
import com.metacube.training.facade.CategoryFacade;

/**
 *  used to create object in entire architecture
 * @author admin
 *
 */
public class BaseFactory {

	/**
	 * used to create object of advertisementfacde
	 * @return advertisementfacde object
	 */
	public static AdvertisementFacade createAdvertisementFacade() {
		return new AdvertisementFacade();
	}

	/**
	 * used to create object of categoryfacde
	 * @return categoryfacde object
	 */
	public static CategoryFacade createCategoryFacade() {
		return new CategoryFacade();
	}

	/**
	 * used to create object of advertisementdao
	 * @return advertisementdao object
	 */
	public static AdvertisementDao createAdvertisementDao() {
		return new AdvertisementDao();
	}

	/**
	 * used to create object of categorydao
	 * @return categorydao object
	 */
	public static CategoryDao createCategoryDao() {
		return new CategoryDao();
	}
}
