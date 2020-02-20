package net.webmvc.controller;

import net.webmvc.action.Action;
import net.webmvc.action.join.*;

public class JoinFactory {
	private static JoinFactory instance = new JoinFactory();

	private JoinFactory() {
		super();
	}

	public static JoinFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("JoinFactory :" + cmd);
		if (cmd.equals("login")) {
			action = new JoinLoginAction();
		}else if (cmd.equals("login_ok")) {
			action = new JoinLoginOkAction();
		}else if (cmd.equals("logout")) {
			action = new JoinLogoutAction();
		}
		return action;
	}

}
