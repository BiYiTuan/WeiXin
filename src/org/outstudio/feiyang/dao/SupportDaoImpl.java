package org.outstudio.feiyang.dao;

import org.outstudio.feiyang.entity.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

@Repository
public class SupportDaoImpl implements SupportDao {
	
	private static final String COLLECTION_SUPPORT = "support";
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean checkSupport(Support support) {
		String openid  = support.getOpenid();
		String fromOid = support.getFromOid();
		DBCollection collection = mongoTemplate.getCollection(COLLECTION_SUPPORT);
		BasicDBObject dbobject = new BasicDBObject();
		dbobject.append("openid", openid).append("fromOid", fromOid);
		BasicDBObject db = (BasicDBObject) collection.findOne(dbobject);
		if (db == null) {
			return false;
		} 
		return true;
	}

	@Override
	public void addSupport(Support support) {
		mongoTemplate.insert(support, COLLECTION_SUPPORT);
	}
}
