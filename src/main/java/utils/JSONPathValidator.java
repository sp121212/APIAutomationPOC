package utils;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

import exp.ApiFrameWorkException;
import io.restassured.response.Response;

public class JSONPathValidator {
	
	private String jsonReponse(Response response) {
		return response.getBody().asString();
	}

	public <T> T read(Response response, String jsonPath) {

		String jsonResponse = jsonReponse(response);

		try {
			return JsonPath.read(jsonResponse, jsonPath);

		} catch (PathNotFoundException e) {
			e.printStackTrace();
			throw new ApiFrameWorkException(jsonPath + " : not found");
		}
	}
	
	public <T> List<T> readList(Response response, String jsonPath) {

		String jsonResponse = jsonReponse(response);

		try {
			return JsonPath.read(jsonResponse, jsonPath);

		} catch (PathNotFoundException e) {
			e.printStackTrace();
			throw new ApiFrameWorkException(jsonPath + " : not found");
		}
	}
	
	public <T> List<Map<String,T>> readListOfMaps(Response response, String jsonPath) {

		String jsonResponse = jsonReponse(response);

		try {
			return JsonPath.read(jsonResponse, jsonPath);

		} catch (PathNotFoundException e) {
			e.printStackTrace();
			throw new ApiFrameWorkException(jsonPath + " : not found");
		}
	}
	

}
