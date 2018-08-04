package com.ws.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ws.entity.God;
import com.ws.entity.Notice;
import com.ws.entity.Pager;

public interface INoticeService {
	/**
	 * ����Ա��������
	 * @param notice		��ǰ̨������������
	 * @param filename		�û��ϴ����ļ�(������)
	 * @param req			���ļ������ϴ�·��ʱ,�½�һ���� �û��� Ϊ�� �� �ļ���,��HttpServletRequest�л�ȡ��¼�û�
	 */
	public void addNotice(Notice notice, MultipartFile file, HttpServletRequest req);
	public Notice checkNotice(int id);
	/**
	 * 
	 * @param req			����ݿ��������µ�8����ݷŵ�HttpServletRequest��
	 * @return
	 */
	public void pagerNotice(HttpServletRequest req);
	/**
	 * 
	 * @param req		��req�л�ȡfilename,Ȼ����ļ���������.CNM����ѡ������·��!!!!!!!!!!
	 */
	public ResponseEntity<byte[]> downloadFile(HttpServletRequest req);
}
