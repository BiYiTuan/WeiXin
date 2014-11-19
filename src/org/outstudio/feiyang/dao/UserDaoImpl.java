package org.outstudio.feiyang.dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;

import org.outstudio.feiyang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository
public class UserDaoImpl implements UserDao {

	private static final String COLLECTION_USER = "user";
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public User saveOrGetUser(User user) {
		User result = getUserByOid(user.getOpenid());
		if (result == null) {
			user.setScore(0);
			mongoTemplate.save(user, COLLECTION_USER);
			return user;
		}
		return result;
	}

	public void addScoreForUser(String openid, int score) {
		Query query = new Query(where("openid").is(openid));
		mongoTemplate.updateFirst(query, new Update().inc("score", score),
				COLLECTION_USER);
	}

	public User getUserByOid(String openid) {
		Query query = new Query(where("openid").is(openid));
		User user = mongoTemplate.findOne(query, User.class);
		return user;
	}

	@Override
	public List<User> getScoreSortedUsers() {
		List<User> list = new ArrayList<User>();
		DBCollection collection = mongoTemplate.getCollection(COLLECTION_USER);
		BasicDBObject user = new BasicDBObject();
		DBCursor cursor = collection.find(user).sort(
				new BasicDBObject("score", -1));
		List<DBObject> dbObjects = cursor.toArray();
		for (DBObject dbObject : dbObjects) {
			String openid = (String) dbObject.get("openid");
			String nickname = (String) dbObject.get("nickname");
			int score = (Integer) dbObject.get("score");
			User ob = new User();
			ob.setOpenid(openid);
			ob.setNickname(nickname);
			ob.setScore(score);
			list.add(ob);
		}
		return list;
	}

	
	
}
