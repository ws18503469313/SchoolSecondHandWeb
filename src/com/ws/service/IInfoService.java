package com.ws.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ws.dto.InfoDto;

public interface IInfoService {

	void pagerInfo(HttpServletRequest req);

	List<InfoDto> listMyInfo(HttpServletRequest req);

}
