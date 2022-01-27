package me.mohammad.example.possystem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class POSSystem extends Thread {
	
	protected static POSSystem lastInstance;
	protected static final String prefix;
	
	protected boolean isRunning;
	
	protected Scanner scanner;
	protected ObjectMapper mapper;
	protected Map<String, Object> items;
	
	static {
		prefix = "[POS] ";
	}
	
	private POSSystem() {
		isRunning = true;
		items = new HashMap<>();
		scanner = new Scanner(System.in);
		mapper = new ObjectMapper(this);
		registerItems();
	}
	
	private void registerItems() {
		//: Add Items Here!
	}
	
	protected boolean registerItem(final String key, final ObjectMapper.PropertyContainer... properties) {
		if (items.containsKey(key))
			return false;
		return (items.put(key.toLowerCase().replaceAll("-", "_").replaceAll(" ", "_"), mapper.mapProperty(properties)) != null);
	}
	
	@SuppressWarnings("unchecked")
	protected void handleRequest() {
		System.out.print(prefix + "> ");
		final String nextLine = scanner.nextLine();
		if (nextLine.equalsIgnoreCase("exit")) {
			isRunning = false;
			return;
		}
		if (nextLine.equalsIgnoreCase("cls")) {
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
			return;
		}
		System.out.println("\n");
		if (!(items.containsKey(nextLine.toLowerCase().replaceAll("-", "_").replaceAll(" ", "_")))) {
			System.out.println(prefix + "Unknown Item: " + nextLine);
			return;
		}
		System.out.println(prefix + "Properties of Item: " + nextLine);
		final Map<String, Object> properties = (Map<String, Object>) items.get(nextLine.toLowerCase().replaceAll("-", "_").replaceAll(" ", "_"));
		for (final Map.Entry<String, Object> propertyEntry : properties.entrySet()) {
			System.out.println(prefix + String.format("[%s : %s]", propertyEntry.getKey(), propertyEntry.getValue()));
		}
		System.out.println("\n");
	}
	
	@Override
	public void run() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println(prefix + "Welcome to Momo's POSSystem");
		while (isRunning)
			handleRequest();
		if (!(isRunning)) {
			try {
				System.out.println(prefix + "Exit command detected, exiting...");
				lastInstance.join(500);
				System.exit(0);
				return;
			} catch (InterruptedException e) {
				System.out.println("An Error occoured while exiting, returning...");
				System.exit(1);
				return;
			}
		}
	}
	
	public static void main(final String[] args) {
		lastInstance = new POSSystem();
		lastInstance.start();
	}
	
}
