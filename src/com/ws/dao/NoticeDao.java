package com.ws.dao;


import org.springframework.stereotype.Repository;

import com.ws.entity.Notice;
@Repository("noticeDao")
public class NoticeDao extends BaseDao<Notice> implements INoticeDao{

}
