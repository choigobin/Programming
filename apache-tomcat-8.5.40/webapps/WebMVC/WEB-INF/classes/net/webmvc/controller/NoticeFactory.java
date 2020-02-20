package net.webmvc.controller;

import net.webmvc.action.Action;
import net.webmvc.action.notice.*;

public class NoticeFactory {
	private static NoticeFactory instance = new NoticeFactory();

	private NoticeFactory() {
		super();
	}

	public static NoticeFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("NoticeFactory :" + cmd);
		if (cmd.equals("notice_list")) {
			action = new NoticeListAction();
		}else if(cmd.equals("notice_write")) {
			action=new NoticeWriteAction();
		}else if(cmd.equals("notice_write_pro")) {
			action=new NoticeWriterProAction();
		}else if(cmd.equals("notice_view")) {
			action=new NoticeViewAction();
		}else if(cmd.equals("notice_edit")) {
			action=new NoticeEditAction();
		}else if(cmd.equals("notice_edit_pro")) {
			action=new NoticeEditProAction();
		}else if(cmd.equals("notice_delete_pro")) {
			action=new NoticeDeleteProAction();
		}


		return action;
	}

}
