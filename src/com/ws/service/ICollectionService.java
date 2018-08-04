package com.ws.service;

import javax.servlet.http.HttpServletRequest;

import com.ws.entity.Collection;
import com.ws.entity.Pager;

public interface ICollectionService {
	/**
	 * 
	 * @param id	�ӽ��洫��������Ʒid,���������һ���µ�Collection
	 * @param req	��HttpServletRequest�л�ȡ������,����Collection,���δ��¼,��ʾ�û��ȵ�¼
	 */
	public void add(HttpServletRequest req);
	public void delete(int id,HttpServletRequest req);
	/**
	 * ��ȡ�ҵ��ղ�
	 * @param req	��req�л�ȡ User
	 * @return
	 */
	public Pager<Collection> pageMyCollection(HttpServletRequest req);
	/**
	 * 
	 * @param req	��req�л�ȡҪɾ����Collection ��id
	 * @return		����״̬
	 */
	public String removeCollection(HttpServletRequest req);
}
