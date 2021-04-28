package com.inventory.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter
public class ListConverter implements AttributeConverter<WrapperItems, String> {

	  private static ObjectMapper mapper;

	  static {
	    mapper = new ObjectMapper();
	  }

	  @Override
	  public String convertToDatabaseColumn(WrapperItems data) {
	    if (null == data) { 
	      // You may return null if you prefer that style
	      return "[]";
	    }
	    
	    try {
	      return mapper.writeValueAsString(data);
	      
	    } catch (IOException e) {
	      throw new IllegalArgumentException("Error converting map to JSON", e);
	    }
	  }

	  @Override
	  public  WrapperItems convertToEntityAttribute(String s) {
	    if (null == s) {
	      // You may return null if you prefer that style
	      return new WrapperItems();
	    }

	    try {
	      return mapper.readValue(s, new TypeReference<WrapperItems>() {});
	      
	    } catch (IOException e) {
	      throw new IllegalArgumentException("Error converting JSON to map", e);
	    }
	  }
	
}
