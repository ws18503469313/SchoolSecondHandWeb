package com.ws.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ws.dao.ICommentDao;
import com.ws.dao.IGodDao;
import com.ws.dao.IGodDtoDao;
import com.ws.dao.IInfoDao;
import com.ws.dao.IUserDao;
import com.ws.dto.CommentDto;
import com.ws.dto.GodDto;
import com.ws.entity.God;
import com.ws.entity.Info;
import com.ws.entity.Pager;
import com.ws.entity.User;
import com.ws.exception.MyRuntimeException;
import com.ws.service.IGodService;
import com.ws.util.DateUtil;
@Service("godService")
public class GodService implements IGodService{
	@Autowired
	private IGodDao godDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IInfoDao infoDao;
	@Autowired
	private IGodDtoDao godDtoDao;
	@Autowired
	private ICommentDao commentDao;

	public void add(HttpServletRequest req,God god, MultipartFile[] files) {
		//���÷�����
		User user = (User)req.getSession().getAttribute("loginUser");
		god.setPublisher(userDao.load(user.getId()));
		//���÷���ʱ��
		god.setDate(DateUtil.getNowDay());
		//������Ʒ״̬--0 Ϊ�ϼ�
		god.setState(2);
		//���ó�ʼ���ʴ���Ϊ0
		god.setClickTime(0);
		//������ļ�������ϴ�
		if(files != null){
			//������Ʒ��ͼƬ���
			god.setImg1(files[0].getOriginalFilename());
			god.setImg2(files[1].getOriginalFilename());
			god.setImg3(files[2].getOriginalFilename());
			god.setImg4(files[3].getOriginalFilename());
			//ͨ����ǿForѭ��һ���ϴ�����ļ�
			for(MultipartFile file:files){
				try {
					String path = req.getSession().getServletContext().getRealPath("/fileupload");
					path = path + "/" +user.getUsername()+"/"+ file.getOriginalFilename();
					File document = new File(path);
					FileUtils.copyInputStreamToFile(file.getInputStream(), document);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		godDao.add(god);		
		
		Info info = new Info();
		info.setContt("有新的用户发布商品,请审核!");
		info.setDate(DateUtil.getNowTime());
		info.setUser(userDao.list("from User where username = 'admin'").get(0));
		infoDao.add(info);
		
	}

	public void delete(int id) {
		
	}

	public String updatePrice(int god_id,int price) {
		try {
			God god = godDao.load(god_id);
			god.setPrice(Double.parseDouble(String.valueOf(price)));
			godDao.update(god);
			return "操作成功!";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "系统错误,请联系网管!";
		}
		
	}

	public GodDto load(int id) {
		String hql = 	"select new com.ws.dto.GodDto" +
						"(g.id as id,u.username as username,g.name as godname,u.address as address,"+ 
						"g.disc as disc, g.price as price, g.date as date,g.img1 as img1,g.img2 as img2,"+ 
						"g.img3 as img3, g.img4 as img4,u.id as userId,g.clickTime as clickTime,u.phone as phone) "+ 
						"from God g " +
						"left join g.publisher u " +
						"where g.id = "+ id ;
		GodDto god =  godDtoDao.list(hql).get(0);
		godDao.updateClickTime(id);
		return god;
	}

	public List<God> list() {
		return null;
	}

	public List<God> list(Object obj) {
		return null;
	}

	public List<God> list(Object[] obj) {
		return null;
	}
	public Pager<GodDto> pageGod() {
		String hql = 	"select new com.ws.dto.GodDto" +
						"(g.id as id,u.username as username,g.name as godname,u.address as address,"+ 
						"g.disc as disc, g.price as price, g.date as date,g.img1 as img1,g.img2 as img2,g.img3 as img3, "+ 
						"g.img4 as img4,u.id as userId,g.clickTime as clickTime,u.phone as phone,g.type as type,g.state as state) "+ 
						"from God g " +
						"left join g.publisher u ";
		return godDtoDao.pages(hql);
	}
	public Pager<GodDto> pageOnlineGod() {
//		String hql = "from God g where g.state = 0 ";
		String hql = 	"select new com.ws.dto.GodDto" +
						"(g.id as id,u.username as username,g.name as godname,u.address as address,"+ 
						"g.disc as disc, g.price as price, g.date as date,g.img1 as img1) "+ 
						"from God g " +
						"left join g.publisher u " +
						"where g.state = 0" ;		

		return (Pager<GodDto>) godDtoDao.pages(hql);
	}

	public Pager<God> page(Object[] obj) {
		return null;
	}
	public Pager<God> listMyPublish(HttpServletRequest req) {
		User u = (User)req.getSession().getAttribute("loginUser");
		if(u == null){
			throw new RuntimeException("还没登录哟~~");
		}
		String hql = "from God g where g.publisher.id = ?";
		Pager<God> pager = godDao.pages(hql, u.getId());
		if(pager.getDatas().size() <= 0){
			throw new MyRuntimeException("你还没发布过呢!");
		}else{
			return pager;
		}
	}
	
	public Pager<GodDto> selectByType(String type) {
//		String hql = "from God g where type = ? and state = 0";
		String hql = 	"select new com.ws.dto.GodDto" +
						"(g.id as id,u.username as username,g.name as godname,u.address as address,"+ 
						"g.disc as disc, g.price as price, g.date as date,g.img1 as img1) "+ 
						"from God g " +
						"left join g.publisher u " +
						"where g.type = ? and g.state = 0";
		return godDtoDao.pages(hql, type);
		 
	}
	public String changestate(HttpServletRequest req) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int state = Integer.parseInt(req.getParameter("state"));
//			God god = godDao.load(id);
//			god.setState(state);
//			godDao.update(god);
			godDao.updateGodState(id,state);
			String reason = req.getParameter("reason");
			System.out.println(reason);
			if(reason == null) {
				reason = "您新发布的商品已通过审核!";
			}
//			Info info = new Info();
//			info.setContt(reason);
//			info.setDate(DateUtil.getNowTime());
//			int userId = godDao.getUserId(id);
//			info.setUser(userDao.load(userId));
//			infoDao.add(info);
			
			return "操作成功!";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "操作失败!";
		}
/*		String hql = "update God set state = ? where id = ?";
		return godDao.changestate(hql, id, state);
*/
	}
	public Pager<GodDto> selectByIn(String in) {
//		String hql = "from God  where name like '%"+in+"%'";
						/*"select new com.ws.dto.GodDto" +
						"(g.id as id,cmter.username as username,g.name as godname,u.address as address,"+ 
						"g.disc as disc, g.price as price, g.date as date,g.img1 as img1) "+ 
						"from God g " +
						"left join g.publisher u " +
//						"left join cmt.commenter cmter " +
 * 						"where g.name like '%"+ in + "%'";
*/						
		String hql = 	"select new com.ws.dto.GodDto" +
						"(g.id as id,u.username as username,g.name as godname,u.address as address,"+ 
						"g.disc as disc, g.price as price, g.date as date,g.img1 as img1) "+ 
						"from God g " +
						"left join g.publisher u " +
						"where g.name like '%"+ in + "%'";
		return godDtoDao.pages(hql);
	}

	public List<CommentDto> loadCommentAndReply(int id) {
		
		return commentDao.loadCommentAndReply(id);
	}
	

}
