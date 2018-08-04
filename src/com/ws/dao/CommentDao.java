package com.ws.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ws.dto.CommentDto;
import com.ws.entity.Comment;
@Repository("commentDao")
public class CommentDao extends BaseDao<Comment> implements ICommentDao{

	

	public List<Comment> checkComment(String hql, int id) {
		// TODO Auto-generated method stub
		/*Query query = this.getSession().createQuery(hql);
		query.setParameter(0, id);
		return (List<Comment>)query.list();*/
		 
		String sql = "select * from t_comment c left join t_user u on c.comter_id = u.id where u.id ="+id;
		List<Comment> list = this.getSession().createSQLQuery(sql).addEntity(Comment.class).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<CommentDto> loadCommentAndReply(int id) {
		String hql = 	"select new com.ws.dto.CommentDto" +
						"(cmt.id as commentId,u.id as cmtId,p.id as publisherId,u.username as cmtusername,"+ 
						"cmt.comment as cmtcontent,cmt.date as cmtdate,r.content as reply, r.date as rpldate) "+ 
						"from Comment cmt " +
						"left join cmt.commenter u " +
						"left join cmt.god g " +
						"left join cmt.replies r " +
						"left join g.publisher p " +
						"where g.id = " +id;
				
		return this.getSession().createQuery(hql).list();
	}

}
