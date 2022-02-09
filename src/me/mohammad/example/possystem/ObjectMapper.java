package me.mohammad.example.possystem;

import java.util.HashMap;
import java.util.Map;

public class ObjectMapper {
	
	private POSSystem posSystem;
	
	protected ObjectMapper(final POSSystem posSystem) {
		this.posSystem = posSystem;
		if (!(this.posSystem.equals(POSSystem.lastInstance))) {
			System.out.printf("%sUnknown reference!", POSSystem.prefix);
		}
	}
	
	protected Map<String, Object> mapProperty(final PropertyContainer... properties) {
		final Map<String, Object> propertiesMap = new HashMap<>();
		for (final PropertyContainer property : properties) {
			if (propertiesMap.containsKey(property.getKey()))
				continue;
			propertiesMap.put(property.getKey(), property.getValue());
		}
		return propertiesMap;
	}
	
	protected class PropertyContainer {
		
		private String key;
		private Object value;
		
		protected PropertyContainer(final String key, final Object value) {
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return key;
		}
		
		public Object getValue() {
			return value;
		}
		
		public void setValue(final Object value) {
			this.value = value;
		}
		
	}
	
}
