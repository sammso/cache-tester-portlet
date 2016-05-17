package com.sohlman.liferay.cachepoc.model;

public class CacheItem {
	public CacheItem(String key, String value) {
		_key = key;
		_value = value;
	}
	
	public void setValue(String value) {
		_value = value;
	}
	
	public void setKey(String key) {
		_key = key;
	}
	
	
	public String getKey() {
		return _key;
	}
	public String getValue() {
		return _value;
	}
	
	private String _key;
	private String _value;
}
