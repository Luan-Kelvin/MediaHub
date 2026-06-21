package com.LkDev.MediaHub;

import com.LkDev.MediaHub.Menu.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MediaHubApplication implements CommandLineRunner {

	@Autowired
	MainMenu mainMenu;

	public static void main(String[] args) {
		SpringApplication.run(MediaHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mainMenu.displayMenu();
	}
}
