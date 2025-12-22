package com.broadcast.server;

import com.broadcast.server.cli.ClientCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BroadcastServerApplication {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Use: broadcast-server start | connect");
			return;
		}

		if ("start".equalsIgnoreCase(args[0])) {
			SpringApplication.run(BroadcastServerApplication.class, args);
		} else if ("connect".equalsIgnoreCase(args[0])) {
			ClientCommand.startClient();
		}
	}
}
