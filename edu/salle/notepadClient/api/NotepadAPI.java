/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.notepadClient.api;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.io.OutputStream;
import edu.salle.notepadClient.model.Note;

/**
 *
 * @author Andrei
 */
public class NotepadAPI {
	private final String baseUrl = "http://localhost:8081";
	
	public List<Note> findAll(){
		try {
			Gson gson= new Gson();
			String endpoint=baseUrl+"/note";
			URL url= new URL(endpoint);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("content-Type", "application/json");
			
			if(conn.getResponseCode()!=HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : Http error code:  "+ conn.getResponseCode());
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder response= new StringBuilder();
			String output;
			while((output=br.readLine())!=null) {
				response.append(output);
			}
			conn.disconnect();
			br.close();
			List<Note>noteList= gson.fromJson(response.toString(), new TypeToken<List<Note>>() {}.getType());
			return noteList;
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Note saveOrUpdate(Note note) {
		try {
			Gson gson= new Gson();
			String endpoint=baseUrl+"/note";
			URL url= new URL(endpoint);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("content-Type", "application/json");
			
			String body=gson.toJson(note);
			OutputStream os=conn.getOutputStream();
			os.write(body.getBytes());
			os.flush();
			if(conn.getResponseCode()!=HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : Http error code:  "+ conn.getResponseCode());
			}
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder response= new StringBuilder();
			String output;
			while((output=br.readLine())!=null) {
				response.append(output);
			}
			conn.disconnect();
			br.close();
			note= gson.fromJson(response.toString(), Note.class);
			return note;
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
