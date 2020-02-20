package net.webmvc.controller;

import net.webmvc.action.Action;
import net.webmvc.action.pds.*;

public class PdsFactory {
	private static PdsFactory instance = new PdsFactory();

	private PdsFactory() {
		super();
	}

	public static PdsFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("JoinFactory :" + cmd);
		if (cmd.equals("pds_list")) {
			action = new PdsListAction();
		}else if(cmd.equals("pds_write")) {
			action=new PdsWriteAction();
		}else if(cmd.equals("pds_write_pro")) {
			action=new PdsWriteProAction();
		}else if(cmd.equals("pds_view")) {
			action=new PdsViewAction();
		}else if(cmd.equals("pds_edit")) {
			action=new PdsEditAction();
		}else if(cmd.equals("pds_edit_pro")) {
			action=new PdsEditProAction();
		}else if(cmd.equals("pds_delete")) {
			action=new PdsDeleteAction();
		}else if(cmd.equals("pds_delete_pro")) {
			action=new PdsDeleteProAction();
		}
		return action;
	}

}
