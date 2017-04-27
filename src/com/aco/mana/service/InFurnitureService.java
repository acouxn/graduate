package com.aco.mana.service;

import com.aco.mana.domain.InFurniture;
import com.aco.mana.domain.PageBean;

public interface InFurnitureService {

	PageBean<InFurniture> findByPage(Integer currPage);

	InFurniture findById(Integer in_fid);

	void update(InFurniture inFurniture);

	void delete(InFurniture inFurniture);

	void save(InFurniture inFurniture);

}
