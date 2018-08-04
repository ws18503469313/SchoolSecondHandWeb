package com.ws.dao;

import java.util.List;

import com.ws.dto.InfoDto;
import com.ws.entity.Info;

public interface IInfoDao extends IBaseDao<Info>{

	List<InfoDto> listMyInfo(int id);

}
