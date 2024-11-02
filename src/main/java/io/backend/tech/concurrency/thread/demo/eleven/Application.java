package io.backend.tech.concurrency.thread.demo.eleven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

	public static void main(String[] args) {

		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("C:/WINDOWS/system32/cmd.exe", "/c", "xyz");
		
		try {

            Process process = processBuilder.start();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
