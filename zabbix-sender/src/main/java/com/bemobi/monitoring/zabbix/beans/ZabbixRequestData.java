/**
 * 
 */
package com.bemobi.monitoring.zabbix.beans;

/**
 * @author brcampos
 *
 */
public class ZabbixRequestData {
	
	private String host;
	
	private String key;
	
	private String value;

	/**
	 * @param host
	 * @param key
	 * @param value
	 */
	public ZabbixRequestData(String host, String key, String value) {
		super();
		this.host = host;
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ZabbixRequestData [host=" + host + ", key=" + key + ", value="
				+ value + "]";
	}	

}
