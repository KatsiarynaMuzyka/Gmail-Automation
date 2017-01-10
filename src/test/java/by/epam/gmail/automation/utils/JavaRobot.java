package by.epam.gmail.automation.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class JavaRobot {
	
	public static void enterCommandOrFileName(String fileName) {
		String file = fileName;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Robot robot;
		try {
			robot = new Robot();
			for (char c : file.toUpperCase().toCharArray()) {

				if (c == '$') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_4);
					robot.keyRelease(KeyEvent.VK_4);
					robot.keyRelease(KeyEvent.VK_SHIFT);

				} else if (c == '.') {
					robot.keyPress(KeyEvent.VK_PERIOD);
					robot.keyRelease(KeyEvent.VK_PERIOD);

				} else if (c == '(') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_9);
					robot.keyRelease(KeyEvent.VK_9);
					robot.keyRelease(KeyEvent.VK_SHIFT);

				} else if (c == ')') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_0);
					robot.keyRelease(KeyEvent.VK_0);
					robot.keyRelease(KeyEvent.VK_SHIFT);

				} else if (c == ':') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_SEMICOLON);
					robot.keyRelease(KeyEvent.VK_SEMICOLON);
					robot.keyRelease(KeyEvent.VK_SHIFT);

				} else if (c == '\\') {
					robot.keyPress(KeyEvent.VK_BACK_SLASH);
					robot.keyRelease(KeyEvent.VK_BACK_SLASH);

				} else if (c == '_') {
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_MINUS);
					robot.keyRelease(KeyEvent.VK_MINUS);
					robot.keyRelease(KeyEvent.VK_SHIFT);
				} else {
					robot.keyPress(c);
					robot.keyRelease(c);
				}

			}

			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	private static void runCMD (String filepath) {
		try {
			Process pr = Runtime.getRuntime().exec("cmd /c start cmd.exe /K cd " + filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createFileOver25MB(String filepath, String filename) {
		runCMD(filepath);
		enterCommandOrFileName("powershell");
		enterCommandOrFileName(
				"$file = New-Object -TypeName System.IO.FileStream -ArgumentList " + filename + ",Create,ReadWrite");
		enterCommandOrFileName("$file.SetLength(30Mb)");
		enterCommandOrFileName("$file.Close()");
		enterCommandOrFileName("exit"); // exit powershell
		enterCommandOrFileName("exit"); // exit cmd

	}
	
	public static void deleteFile(String filepath, String filename) {
		runCMD(filepath);
		enterCommandOrFileName("del " + filename);
		enterCommandOrFileName("exit");
	}
}
