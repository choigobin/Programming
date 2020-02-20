package net.webmvc.controller;

import net.webmvc.action.Action;
import net.webmvc.action.board.*;

public class BoardFactory {
	private static BoardFactory instance = new BoardFactory();

	private BoardFactory() {
		super();
	}

	public static BoardFactory getInstance() {
		return instance;
	}

	public Action getAction(String cmd) {
		Action action = null;
		System.out.println("BoardFactory :" + cmd);
		if (cmd.equals("board_list")) {
			action = new BoardListAction();
		}else if(cmd.equals("board_write")) {
			action=new BoardWriteAction();
		}else if(cmd.equals("board_write_pro")) {
			action=new BoardWriteProAction();
		}else if(cmd.equals("board_view")) {
			action=new BoardViewAction();
		}else if(cmd.equals("board_edit")) {
			action=new BoardEditAction();
		}else if(cmd.equals("board_edit_pro")) {
			action=new BoardEditProAction();
		}else if(cmd.equals("board_delete")) {
			action=new BoardDeleteAction();
		}else if(cmd.equals("board_delete_pro")) {
			action=new BoardDeleteProAction();
		}
		return action;
	}

}
