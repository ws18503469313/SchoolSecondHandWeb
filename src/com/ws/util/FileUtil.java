package com.ws.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.filechooser.FileSystemView;

public class FileUtil {
	public static void main(String[] args) {
		//String filename = "D:/Tomcat6.0/webapps/SchoolSecondHandWeb/fileupload/888/cacaca";
		//filename = filename.substring(filename.lastIndexOf("/"));
		//System.out.println(filename);
		//System.out.println(getDesktop()+filename);
		System.out.println(System.getProperty("catalina.home"));;
	}
	public static String downloadFileToDesktop(String filename){
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File(filename);
			is = new FileInputStream(file);
			filename = filename.substring(filename.lastIndexOf("/"));
			System.out.println("文件名:"+filename);
			System.out.println("新路径"+getDesktop()+filename);
			os = new FileOutputStream(getDesktop()+filename);
			byte [] by = new byte[2048];
			int len;
			while( (len = is.read(by)) != -1){
				 os.write(by, 0, len); 
			}
			return "文件已成功下载到您的桌面";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "下载失败";
		}finally{
			try {
				if(is != null){
					is.close();
				}
				if(os != null){
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static String getDesktop(){
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com = fsv.getHomeDirectory();    //这便是读取桌面路径的方法了
		return com.getPath();
	}
}
