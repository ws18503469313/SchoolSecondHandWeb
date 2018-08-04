package com.ws.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ws.dto.CommentDto;
import com.ws.dto.GodDto;
import com.ws.entity.God;
import com.ws.entity.Pager;
@Service("IGodService")
public interface IGodService {
	public void add(HttpServletRequest req,God god, MultipartFile[] files);
	public void delete(int id);
	public String updatePrice(int god_id,int price);
	public GodDto load(int id);
	public List<God> list();
	public List<God> list(Object obj);
	public List<God> list(Object[] obj);
	/**
	 * 
	 * @return	��ҳ�������������Ʒ
	 */
	public Pager<GodDto> pageGod();
	/**
	 * @return	��ҳ����������ߵ���Ʒ
	 */
	public Pager<GodDto> pageOnlineGod();
	
	public Pager<God> page(Object[] obj);
	
	/**
	 * ��ȡ�Լ���������Ʒ
	 * @param req	��HttpServletRequers�л�ȡ��¼���û�
	 */
	public Pager<God> listMyPublish(HttpServletRequest req);
	/**
	 * ��ȡ�û�ѡ��ķ������Ʒ
	 * @param type	�û�ѡ��ķ���
	 * @return		
	 */
	public Pager<GodDto> selectByType(String type);
	/**
	 * �¼���Ʒ
	 * @param req		��req�л�ȡstate��id
	 */
	public String changestate(HttpServletRequest req);
	/**
	 * ��ȡ�û�Ҫ��������Ʒ
	 * @param in		�û������Ҫ��������Ʒ
	 * @return
	 */
	public Object selectByIn(String in);
	/**
	 * load the god's comment and the reply 
	 * which is correspornd with comment published by the owner of the god
	 * @param id
	 * @return
	 */
	public List<CommentDto> loadCommentAndReply(int id);
	
	
	
}
