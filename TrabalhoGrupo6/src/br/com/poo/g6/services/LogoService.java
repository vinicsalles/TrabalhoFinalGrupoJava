package br.com.poo.g6.services;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogoService {
	static Logger logger = Util.setupLogger();
	public void logo() {
		Util.customizer();
		logger.log(Level.INFO,() ->
				"	 ⢀⣀⣀⣀⡀⢰⡟ ⢀⡀ ⢀⣀      ⣿⣀⣀⣀⡀⣀⣀⣀⣀  ⣀⣀⣀⣀⡀ ⣿  ⣀ \r\n"
				+ "	⣾⣿⣿⣿⡅ ⣸⡇ ⣸⣧⣤⣾      ⢸⣿⠉⢹⣿⢠⣿⣿⣿⣿ ⢸⣿⠉⢙⣿ ⢰⣿⣤⣴⣿ \r\n"
				+ "	⠶⠶⠶⠿⠃ ⠿  ⠿  ⠿⠇     ⠾⠷⠶⠾⠇⠸⠷⠶⠾⠏ ⠾⠇ ⠸⠇ ⠸⠇ ⠸⠟ \r\n"
				+ "				 ⢠⣄⡀                     \r\n"
				+ "			    ⢀⣠⣤  ⢸⣿⣿⣷⣤⣀                  \r\n"
				+ "			 ⣀⣤⣶⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⣦⣄⡀              \r\n"
				+ "		     ⢀⣠⣴⣾⣿⣿⣿⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣀           \r\n"
				+ "		  ⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⡀       \r\n"
				+ "		⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⠈⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡆     \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿     ⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇     \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢰⣦⣄⡀  ⠈⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⡇     \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢸⣿⣿⣿⣶⣤⡀   ⠉⠛⠿⣿⣿⣿⣿⣿⡇     \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⣷⣦⣄⡀   ⠙⠻⢿⣿⡇     \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⡀   ⠈⠃     \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣀       \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⠈⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆     \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿      ⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇     \r\n"
				+ "		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿     ⢀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇     \r\n"
				+ "		⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠇     \r\n"
				+ "		 ⠈⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉       \r\n"
				+ "		     ⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁          \r\n"
				+ "		         ⠙⠻⢿⣿⣿⣿  ⢸⣿⣿⣿⣿⣿⣿⠿⠛⠉              \r\n"
				+ "			    ⠈⠛⠿  ⢸⣿⣿⣿⠟⠋⠁                          ");

	}
}