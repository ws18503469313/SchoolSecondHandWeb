package com.ws.dao;

import org.springframework.stereotype.Repository;

import com.ws.entity.Collection;
@Repository("collectionDao")
public class CollectionDao extends BaseDao<Collection> implements ICollectionDao {
	public static void main(String[] args) {
		int i = 0;
		i = 8;
		i = i*(4+4+4)*120;
		System.out.println(i);
	}
}
