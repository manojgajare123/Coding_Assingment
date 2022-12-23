package com.masai.Service;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.MyApiException;
import com.masai.Repository.ApiDAO;
import com.masai.model.Myapi;

@Service
public class ApiServiceImpl implements ApiService {
	
	@Autowired
	private ApiDAO adao;
	
	
	@Override
	public Myapi createApi(Myapi obj) {
		
		return adao.save(obj);
		
	}

	@Override
	public List<Myapi> getApiByCategories() throws MyApiException {
		List<Myapi> list= adao.findAll();
		if(list.size()==0) {
			throw new MyApiException("No Category found");
		}
		return list;
	}

	@Override
	public List<Myapi>getApiByHealth() throws MyApiException {
		List<Myapi> list= adao.findAll();
		
		List<Myapi> hlist= new ArrayList<>();
		
		for(Myapi i:list) {
			if(i.getCategory().equals("health"))
			{
				hlist.add(i);
			}
		}
		if(list.size()==0 || hlist.size()==0) {
			throw new MyApiException("No Heath Category found");
		}
		
		return hlist;
	}
	
	@Override
	public Myapi getApiByRandom() throws MyApiException {
		
		List<Myapi> list= adao.findAll();
		
		if(list.size()==0) {
			throw new MyApiException("Nothing found in list");
		}
		int max= list.size()-1;
		int min=0;	
		Integer rand=(int) ((Math.random() * (max - min)) + min);
		
		return list.get(rand);
	}

	@Override
	public List<String> getApiBySearch(String des) throws MyApiException  {
		
		List<Myapi> list= adao.findAll();
		
		
		
		List<String>ans= new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			String d=list.get(i).getDescription();
			for(int j=0;j<d.length();j++) {
				String sub="";
				for(int k=j;k<d.length();k++) {
					sub=sub+d.charAt(k);
					if(sub.equals(des)) {
						ans.add(d);
					}
				}
			}
		}
		
		
		if(ans.size()==0) {
			throw new MyApiException("No Search found");
		}
		return ans;
	}

	
	

}
