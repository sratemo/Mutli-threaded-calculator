package conversion;

import java.io.*;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyProperties using the singleton pattern.
 */
public class CurrencyProperties {

	/**
	 * Instantiates a new currency properties.
	 */
	private CurrencyProperties() {
		this.loadProperties();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public String getProperty(String key) {
		return this.properties.getProperty(key.trim());
	}

	/**
	 * Returns this instance of the object
	 *
	 * @return the ref
	 */
	public static CurrencyProperties getRef() {

		if (instance == null) {
			synchronized (CurrencyProperties.class) {
				if (instance == null)
					instance = new CurrencyProperties();
			}
		}

		return instance;
	}

	/**
	 * Sets the property.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void setProperty(String key,String value) {
		this.properties.setProperty(key, value);
	}
	
	
	/**
	 * Load properties.
	 */
	private void loadProperties() {

		this.properties.clear();

		try {
			this.properties.load(this.getClass().getClassLoader()
					.getResourceAsStream("conversion/currency.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** The properties. */
	private Properties properties = new Properties();
	
	/** The instance. */
	private static CurrencyProperties instance;
}
