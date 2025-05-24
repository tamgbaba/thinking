package com.tang.thinking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootTest
class ThinkingApplicationTests {

	@Test
	void contextLoads() throws UnknownHostException {
		InetAddress localHost = InetAddress.getLocalHost();
		String localIP = localHost.getHostAddress();

		System.out.println(localIP);

	}

}
