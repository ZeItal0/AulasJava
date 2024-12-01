package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EnvConfig {
	private static Properties propiedades = new Properties();

	static {
		File envFile = new File("D:/java/ifood/src/.env");
		if (!envFile.exists()) {
			throw new RuntimeException("Arquivo nao existe: " + envFile.getAbsolutePath());
		}
		
		
		try {
			propiedades.load(new FileInputStream(envFile));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static String get(String key) {
		return propiedades.getProperty(key);
	}
}
