package com.metacube.training.dao;

import java.util.Map;
import com.metacube.training.model.BaseEntity;
import com.metacube.training.model.ProductModel;

public interface BaseDao<T extends BaseEntity> {

	public Map<ProductModel,Integer> getAll();

	
}
