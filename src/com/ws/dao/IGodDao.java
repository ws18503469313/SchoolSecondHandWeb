package com.ws.dao;

import org.springframework.stereotype.Repository;

import com.ws.dto.GodDto;
import com.ws.entity.God;
import com.ws.entity.Pager;
@Repository("IGodDao")
public interface IGodDao extends IBaseDao<God>{
	public String changestate(String hql,int id,int state);

	public void updateClickTime(int id);


	public void updateGodState(int id, int state);

	public int getUserId(int id);

	public God getAddInfo(int parseInt);

}
