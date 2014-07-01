package com.kasun.run;

import java.io.IOException;
import java.net.MalformedURLException;

import com.kasun.process.Process;

import org.json.simple.parser.ParseException;

public class Run {

	public static void main(String[] args) throws MalformedURLException,
			IOException, ParseException {
		Process.run();
		System.out.println("Location Sent By the train... ");

	}
}
