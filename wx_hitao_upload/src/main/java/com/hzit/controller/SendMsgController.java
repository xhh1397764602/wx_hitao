package com.hzit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.utils.MsgUtil;
import com.utils.ServerResponse;

@Controller
public class SendMsgController {
	// 100000
	// private int code = 100000+(int)(Math.random()*1000000); ;
	/**
	 * 发送短信验证码
	 * @param mobile
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/sendMsg")
	@ResponseBody
	public ServerResponse<Integer> sendMsg(String memberMobile,HttpSession session) throws Exception {
		// 生成的验证码 需要和用户输入的要进行校验
		int code =  100000+(int)(Math.random()*1000000); // 随机生成验证码
		SendSmsResponse resp = MsgUtil.sendMsg(memberMobile, code);
		if("OK".equalsIgnoreCase(resp.getCode())) {
			// 成功
			// 把验证码保存到session
			session.setAttribute("msg", code);
			// 保存当前的时间戳
			session.setAttribute("startTime", System.currentTimeMillis());
			return ServerResponse.createBySuccessMessage("短信验证码发送成功！");//表示成功
		}else {
			// 失败
			return ServerResponse.createByErrorMessage("短信验证码发送失败！");
		}
	}
	/**
	 * 校验验证码
	 * @param msg
	 * @param session
	 * @return
	 */
	@GetMapping("/checkMsg")
	@ResponseBody
	public ServerResponse<Integer> checkMsg(String code,HttpSession session) {
		Object obj = session.getAttribute("msg");// 根据键获取之前存的验证码
		Object time = session.getAttribute("startTime");
		// 获取系统当前的时间
		long endTime = System.currentTimeMillis();
		long startTime = Long.parseLong(time.toString());
		if((endTime - startTime ) > 5*60*1000) {
			return ServerResponse.createByErrorMessage("短信验证码已经失效！");
		}
		if(obj != null) { // 防止验证失效了!
			if(obj.toString().equals(code)) { // 判断用户输入的验证码和之前生成的验证码是否一致
				// 需要把之前存的验证码给删除了
				session.removeAttribute("msg");
				return ServerResponse.createBySuccessMessage("短信验证码验证成功！");
			}else {
				return ServerResponse.createByErrorMessage("短信验证码验证失败！");
			}
		}else {
			return ServerResponse.createByErrorMessage("请先获取短信验证码！");
		}
	}
	
}
