package com.house.manager.util;

import java.util.HashMap;
import java.util.Map;

public class HouseConstant {
	
	public static final String ATTR_NAME_MESSAGE = "MESSAGE";
	public static final String ATTR_NAME_LOGIN_ADMIN = "LOGIN-ADMIN";
	public static final String ATTR_NAME_PAGE_INFO = "PAGE-INFO";
	
	public static final String MESSAGE_LOGIN_FAILED = "登录账号或密码不正确！请核对后再登录！";
	
	public static final Map<String, String> EXCEPTION_MESSAGE_MAP = new HashMap<>();
	public static final String MESSAGE_RANDOM_CODE_LENGTH_INVALID = "验证码长度不合格，请输入大于0的长度！";
	public static final String REDIS_LOGIN_TOKEN_PREFIX = "SIGEND_MEMBER_";
	public static final String MESSAGE_INPUT_INVALID = "请输入有效的信息";
	public static final String MESSAGE_REGISTER_LOGINACCT_ALREADY_EXIST = "注册账户已存在！";
	public static final String MESSAGE_REGISTER_SUCCESS = "注册成功！请登录！";
	public static final String MESSAGE_ID_INVALID = "Id不得为空！";
	public static final String MESSAGE_ERROR_INTERNAL = "发生服务器内部错误！请重新输入！";
	public static final String MESSAGE_LOGIN_SUCCESS = "登录成功！";
	public static final String MESSAGE_DATA_EMPTY = "数据不存在！";
	public static final String MESSAGE_MEMBER_DO_NOT_BE_USE = "用户不能使用！请联系管理员！";
	public static final String NOT_MANAGER = "暂时不是管理员！不得登录后台！";

    static {
		EXCEPTION_MESSAGE_MAP.put("java.lang.ArithmeticException", "系统在进行数学运算时发生错误");
		EXCEPTION_MESSAGE_MAP.put("java.lang.RuntimeException", "系统在运行时发生错误");
		EXCEPTION_MESSAGE_MAP.put("com.atguigu.crowd.funding.exception.LoginException", "登录过程中运行错误");
		EXCEPTION_MESSAGE_MAP.put("org.springframework.security.access.AccessDeniedException", "尊敬的用户，您现在不具备访问当前功能的权限！请联系超级管理员。");
	}

}
