package it.rino.demoRinoProva;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class parsing {
    
    public static void main(String[] args) {

    	String str="";
    	
    	 String ingresso="C:\\Users\\vito\\Desktop\\jsondata.txt";
    	try (BufferedReader in = new BufferedReader(new FileReader(ingresso))) {     //in questo modo con l'argomento 
    		String testo;   //del try il pregetto si chiude da solo//
    		
    		while((testo = in.readLine())!=null)  {
    			str+=testo;   			
}		
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    	try {
			JSONObject obj = new JSONObject(str);
			List<Post>posts=new ArrayList<Post>();
			String s;
			JSONArray t=obj.getJSONArray("data");
			for(int i=0; i<t.length();i++){
				JSONObject res = obj.getJSONArray("data").getJSONObject(i);
				ObjectMapper mapper= new ObjectMapper();
				mapper.findAndRegisterModules();
				Post post = mapper.readValue(res.toString(),Post.class);
				posts.add(post);
			}
			System.out.println(posts);
    } catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
    	
    }
}