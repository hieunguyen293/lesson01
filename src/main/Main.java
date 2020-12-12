package main;

import java.sql.SQLException;

import view.ViewMain;

public class Main {
	public static void main(String[] args) throws SQLException {
		ViewMain viewMain = new ViewMain();
		viewMain.execute();
	}
}
