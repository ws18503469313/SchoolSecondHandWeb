package com.ws.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ws.dto.OrderDto;
import com.ws.entity.Collection;
import com.ws.entity.God;
import com.ws.entity.Order;
import com.ws.entity.Pager;
import com.ws.entity.User;
import com.ws.service.ICollectionService;
import com.ws.service.ICommnetService;
import com.ws.service.IGodService;
import com.ws.service.IOrderService;
import com.ws.service.IReplyService;
@Controller("godController")
@RequestMapping("god")
public class GodController {
	@Autowired
	private IGodService godService;
	@Autowired
	private ICollectionService collectionService;
	@Autowired
	private ICommnetService commnetService;
	@Autowired
	private IReplyService replyService;
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 
	 * @param model	锟斤拷一锟斤拷锟秸碉拷god锟斤拷锟斤拷锟斤拷锟斤拷锟�
	 * @return		锟斤拷锟截碉拷锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷
	 */
	@RequestMapping(value="/publish",method=RequestMethod.GET)
	public String publish(Model model,HttpServletRequest req){
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user == null){
			model.addAttribute("msg", "还没登录哟!~~");
			return "error";
		}else{
			God god = new God();
			model.addAttribute("god", god);
			return "user/god/publish";
		}
		
	}
	
	/**
	 * 
	 *  @param req	锟斤拷HttpServlerRequst锟叫伙拷取user
	 * @param god	锟矫伙拷锟较达拷锟斤拷锟斤拷品锟斤拷息
	 * @param files	锟较达拷锟侥讹拷锟斤拷募锟�
	 * @return		锟斤拷锟截碉拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷品锟侥斤拷锟斤拷
	 */
	@RequestMapping(value="/publish",method=RequestMethod.POST)
	public String publish(HttpServletRequest req,God god, @RequestParam MultipartFile []files){
		//锟斤拷锟街伙拷锟斤拷洗锟揭伙拷锟斤拷募锟斤拷锟斤拷锟街伙拷锟揭狹ultipartFile锟斤拷锟酵斤拷锟斤拷锟侥硷拷锟斤拷锟缴ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷式指锟斤拷@RequestParam注锟斤拷   
        //锟斤拷锟斤拷锟斤拷洗锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷么锟斤拷锟斤拷锟揭拷锟組ultipartFile[]锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟揭伙拷要指锟斤拷@RequestParam注锟斤拷   
        //锟斤拷锟斤拷锟较达拷锟斤拷锟斤拷募锟绞憋拷锟角疤拷?锟叫碉拷锟斤拷锟斤拷<input type="file"/>锟斤拷name锟斤拷应锟斤拷锟斤拷files锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷files锟睫凤拷锟斤拷取锟斤拷锟斤拷锟斤拷锟较达拷锟斤拷锟侥硷拷   
		godService.add(req, god, files);
		return "redirect:/god/myGods";
	}
	/**
	 * 
	 * @param model		锟斤拷锟斤拷荽锟斤拷锟揭筹拷锟�
	 * @param req		锟斤拷HttpServletRequest锟叫伙拷取loginUser,锟劫查到锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷品
	 * @return			锟斤拷锟截碉拷锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷
	 */
	@RequestMapping(value="/myGods",method=RequestMethod.GET)
	public String myPublish(HttpServletRequest req,Model model){
		try {
			model.addAttribute("pages", godService.listMyPublish(req));
			return "user/god/mygods";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	/**
	 * 
	 * @param req		锟斤拷锟斤拷锟斤拷约锟斤拷詹氐锟斤拷锟狡�-锟斤拷锟斤拷品为锟较硷拷状态
	 * @param model		锟斤拷锟斤拷锟絤odel锟斤拷
	 * @return			锟斤拷锟截碉拷锟揭碉拷锟秸藏斤拷锟斤拷
	 */
	@RequestMapping(value="/myCollection",method=RequestMethod.GET)
	public String myCollection(HttpServletRequest req,Model model){
		try {
			Pager<Collection> pager = collectionService.pageMyCollection(req);
			if(pager == null){
				model.addAttribute("msg","您还没有收藏!~赶快去浏览网页吧!");
			}else{
				model.addAttribute("pages", pager);
			}
			return "user/god/myCollection";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	/**
	 * 	
	 * @param type		锟接斤拷锟芥传锟斤拷锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷 type
	 * @param model		锟斤拷锟斤拷荼锟斤拷娴絤odel锟斤拷
	 * @return			锟斤拷锟截碉拷锟斤拷锟斤拷锟斤拷
	 */
	@RequestMapping(value="/selectByType",method=RequestMethod.GET)
	public String selectByType(String type,Model model){
		model.addAttribute("pages", godService.selectByType(type));
		return "nav";
	}
	/**
	 * 		锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	 * @param in
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/selectByIn",method=RequestMethod.GET)
	public String selectByIn(String in,Model model){
		model.addAttribute("pages", godService.selectByIn(in));
		return "nav";
	}
	/**
	 * 锟介看锟斤拷品锟斤拷细锟斤拷锟斤拷息
	 * @param id		锟接斤拷锟芥传锟斤拷锟斤拷锟斤拷品ID	
	 * @param model		锟酵帮拷锟杰达拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟斤拷锟狡凤拷锟斤拷锟斤拷model锟斤拷
	 * @return			锟斤拷锟截碉拷锟斤拷品锟斤拷锟斤拷锟斤拷锟�
	 */
	@RequestMapping(value="/godDetal",method=RequestMethod.GET)
	public String godDetal(int id,Model model){
		
		model.addAttribute("god", godService.load(id));
		model.addAttribute("cr", godService.loadCommentAndReply(id));
		return "goddetal";
	}
	/**
	 * 
	 * @param id		锟接斤拷锟芥传锟斤拷锟斤拷锟斤拷品ID
	 * @param model		锟斤拷锟截革拷锟斤拷锟斤拷锟斤拷息
	 * @param req		锟斤拷req锟叫伙拷取loginUser,锟斤拷锟轿达拷锟铰�锟斤拷示锟矫伙拷锟饺碉拷录
	 * @return			锟斤拷锟截碉拷锟斤拷应锟侥斤拷锟斤拷
	 * @throws IOException 
	 */
	@RequestMapping(value="/addInCollection",method=RequestMethod.GET)
	public void addInCollection(Model model,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		try {
			collectionService.add( req);
			resp.getWriter().print("添加成功");
		} catch (Exception e) {
			resp.getWriter().print(e.getMessage());
		}
	}
	/**
	 * 
	 * @param id		锟斤拷from锟�锟斤拷锟斤拷取锟斤拷 god锟斤拷id
	 * @param comment	锟斤拷from锟�锟斤拷锟斤拷取锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷
	 * @param req		锟斤拷req锟叫伙拷取锟斤拷录锟矫伙拷
	 * @param model		锟斤拷锟斤拷锟铰碉拷god(锟斤拷锟斤拷锟铰碉拷锟斤拷锟桔碉拷god)
	 * @return			锟斤拷锟截碉拷锟斤拷品锟斤拷锟斤拷页锟斤拷
	 */
	@RequestMapping(value="/addComment",method=RequestMethod.GET)
	public String addComment(int id,String comment,HttpServletRequest req,Model model){
		try {
			commnetService.addCommnet(comment, id, req);
			model.addAttribute("god", godService.load(id));
			model.addAttribute("cr", godService.loadCommentAndReply(id));
			return "goddetal";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			System.out.println(e.getMessage());
			return "error";
		}
	}
	/**
	 * 
	 * @param req		锟斤拷HttpServletRequest锟叫伙拷取前台锟斤拷锟斤拷锟侥回革拷锟斤拷锟斤拷锟斤拷锟斤拷要锟侥诧拷锟斤拷comment  锟斤拷  content
	 * @param resp		通锟斤拷HttpServletResponse锟斤拷前台锟斤拷锟捷达拷锟斤拷锟斤拷状态
	 */
	@RequestMapping(value="/reply",method=RequestMethod.POST)
	public void reply(HttpServletRequest req, HttpServletResponse resp){
		try {
			replyService.addReply(req);
			resp.getWriter().print("回复成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	/**
	 * 锟斤拷锟斤拷员锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷锟斤拷锟�
	 * @param model		锟斤拷欧锟揭筹拷锟斤拷锟斤拷锟斤拷gods
	 * @return			锟斤拷锟截碉拷锟斤拷品锟斤拷锟斤拷锟斤拷锟�
	 */
	@RequestMapping(value="/godManage",method=RequestMethod.GET)
	public String godManager(Model model){
		model.addAttribute("gods", godService.pageGod());
		return "user/admin/godManage";
	}
	/**
	 * 锟斤拷锟斤拷员锟斤拷锟斤拷锟斤拷品锟侥诧拷锟斤拷  /锟较硷拷/锟铰硷拷锟斤拷品
	 * @param req		使锟斤拷HttpServletRequest锟斤拷锟斤拷json锟斤拷莼锟饺tate锟斤拷id
	 * @param resp		锟斤拷锟截诧拷锟斤拷状态
	 */
	@RequestMapping(value="/changestate",method=RequestMethod.POST)
	public void changestate(HttpServletRequest req, HttpServletResponse resp){
		try {
			String message = godService.changestate(req);
			resp .getWriter().write(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	/**
	 * 锟介看某锟斤拷锟斤拷品锟斤拷锟斤拷锟斤拷
	 * @param id		锟斤拷品锟斤拷id	
	 * @param model		锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟狡凤拷锟斤拷锟斤拷鄯锟斤拷锟絤odel锟斤拷
	 * @return			锟斤拷锟截碉拷锟介看某锟斤拷品锟斤拷锟桔碉拷页锟斤拷
	 */
	@RequestMapping(value="/checkcomment",method=RequestMethod.GET)
	public String checkcomments(int id,Model model){
		model.addAttribute("god", godService.load(id));
		model.addAttribute("comments", godService.loadCommentAndReply(id));
		return "user/admin/checkComment";
	}
	/**
	 * 
	 * @param req		锟斤拷锟斤拷Service
	 * @param resp		锟斤拷锟截革拷前台Service锟斤拷锟斤拷锟斤拷
	 * @throws IOException 
	 */
	@RequestMapping(value="/removeCollection",method=RequestMethod.GET)
	public void removeCollection(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String message = "";
		try {
			message= collectionService.removeCollection(req);
			resp.getWriter().print(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp.getWriter().print(e.getMessage());
			
		}
	}
	@RequestMapping(value="/addOrder",method=RequestMethod.POST)
	public void addOrder(HttpServletRequest req,HttpServletResponse resp){
		
		try {
			String message = orderService.add(req);
			resp.getWriter().println(message);
		} catch (IOException e) {
			
		}
	}
	@RequestMapping(value="/myOrder",method=RequestMethod.GET)
	public String myOrder(HttpServletRequest req,Model model){
		try {
			List<OrderDto> orders = orderService.listMyOrder(req);
			model.addAttribute("orders", orders);
			return "user/god/myOrder";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
	}
	@RequestMapping(value="/updatePrice",method=RequestMethod.POST)
	public void updatePrice(HttpServletResponse resp,int god_id,int price) throws IOException {
		String message = godService.updatePrice(god_id,price);
		resp.getWriter().println(message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
