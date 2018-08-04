package com.ws.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ws.dao.INoticeDao;
import com.ws.entity.Notice;
import com.ws.service.INoticeService;
import com.ws.util.DateUtil;
@Service("noticeService")
public class NoticeService implements INoticeService{
	private INoticeDao noticeDao;
	@Resource
	public void setNoticeDao(INoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void addNotice(Notice notice, MultipartFile file, HttpServletRequest req) {
		// TODO Auto-generated method stub
		notice.setDate(DateUtil.getNowTime());
		try {	
			if(file != null){
				notice.setFilename(file.getOriginalFilename());
				String path = req.getSession().getServletContext().getRealPath("/fileupload");
				path = path + "/adminfiles/"+ file.getOriginalFilename();
				System.out.println("url"+path);
				File document = new File(path);
				FileUtils.copyInputStreamToFile(file.getInputStream(), document);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noticeDao.add(notice);
	}

	public Notice checkNotice(int id) {
		// TODO Auto-generated method stub
		
		return noticeDao.load(id);
	}

	public void pagerNotice(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String hql = "from Notice order by id desc";
		req.getSession().setAttribute("notices",  noticeDao.pages(hql));
	}
	//D:\Tomcat6.0\webapps\SchoolSecondHandWeb\888\SogouExplorer.exe
	//D:\Tomcat6.0\webapps\SchoolSecondHandWeb\fileupload\888
	/*public String downloadFile(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String filename = req.getParameter("filename");
		@SuppressWarnings("deprecation")
		String path = req.getSession().getServletContext().getRealPath("/fileupload/888/")+filename;
		System.out.println("path:"+path);
		return FileUtil.downloadFileToDesktop(path);
		
	}*/
	public ResponseEntity<byte[]> downloadFile(HttpServletRequest req) {
		try {
			//�����ļ�·��
			String path = req.getSession().getServletContext().getRealPath("/fileupload/adminfiles/");
			//�����ļ���
			String filename = req.getParameter("filename");
			File file = new File(path + File.separator + filename);
			HttpHeaders headers = new HttpHeaders();  
			//������ʾ���ļ��������������������  
			String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
			//֪ͨ�������attachment�����ط�ʽ����ͼƬ
			headers.setContentDispositionFormData("attachment", downloadFielName); 
			//application/octet-stream �� ����������ݣ������ļ����أ���
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
			           headers, HttpStatus.CREATED);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
