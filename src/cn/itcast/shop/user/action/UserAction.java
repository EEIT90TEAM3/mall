package cn.itcast.shop.user.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itcast.shop.user.model.User;
import cn.itcast.shop.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven{
	private User user = new User();
	private UserService userService;
	private String checkcode;
	
	public String registPage(){
		return "registPage";
	}
	
	public String isExist() throws IOException{
		User u = userService.findByUsername(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(u!=null){
			response.getWriter().print("<font color='red'>�û����Ѵ���!</font>");
		}else{
			response.getWriter().print("<font color='green'>�û�������ʹ��!</font>");
		}
		return NONE;
	}
	
	public String regist(){
		userService.add(user);
		this.addActionMessage("��ϲ��ע��ɹ�!�����ڿ��Ե�¼��!");
		return "msg";
	}
	
	public String loginPage(){
		return "loginPage";
	}
	
	public String login(){
		String code = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(code)){
			this.addActionError("��֤�벻��ȷ!");
			return "codeError";
		}
		User existUser = userService.find(user);
		if(existUser == null){
			this.addActionError("�û��������벻��ȷ!����������!");
			return "loginError";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
		}
		return "loginSuccess";
	}
	
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public String checkImg(){
		return "checkImg";
	}

	public Object getModel() {
		return user;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	
	
}
