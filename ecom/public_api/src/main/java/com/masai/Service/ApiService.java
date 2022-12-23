package com.masai.Service;

import java.util.List; 

import com.masai.Exception.MyApiException;
import com.masai.model.Myapi;
import com.masai.model.Myapi;

public interface ApiService {
	public Myapi createApi(Myapi obj);
	public List<Myapi> getApiByCategories() throws MyApiException;
	public List<Myapi> getApiByHealth() throws MyApiException;
	public Myapi getApiByRandom() throws MyApiException;
	public List<String> getApiBySearch(String des) throws MyApiException;
	
}
