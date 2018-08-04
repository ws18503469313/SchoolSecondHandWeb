package com.ws.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.dao.IInfoDao;
import com.ws.dto.InfoDto;
import com.ws.entity.Info;
import com.ws.entity.Pager;
import com.ws.entity.User;
import com.ws.service.IInfoService;
@Service
public class InfoService implements IInfoService{
	@Autowired
	private IInfoDao infoDao;

	public void pagerInfo(HttpServletRequest req) {
		int user_id = ((User) req.getSession().getAttribute("loginUser")).getId();
		String hql =	/*"select new com.ws.entity.Info "+ 
						"(i.id as id,i.content as content,i.date as date,i.state as state)"+ */
						"from Info i where i.user.id = "+user_id;
		Pager<Info> pager = infoDao.pages(hql);
		req.getSession().setAttribute("infos", pager);
	}

	public List<InfoDto> listMyInfo(HttpServletRequest req) {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user == null){
			throw new RuntimeException("请先登录哟~~");
		}
//		String hql = "from Info where user.id = "+user.getId();
		List<InfoDto> list =  infoDao.listMyInfo(user.getId());
		System.out.println(list.toString());
		return list;
		
	}
}
