package utils;

import java.util.List;
import java.util.Map;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLPathValidator {
	
	private XmlPath getXMLPath(Response response) {
		String responseBody =  response.body().asString();
		return new XmlPath(responseBody);
	}
	
	public <T> T read(Response response, String xmlPathExpression) {
		XmlPath xmlPath = getXMLPath(response);
		return xmlPath.get(xmlPathExpression);
	}
	
	public <T> List<T> readList(Response response, String xmlPathExpression) {
		XmlPath xmlPath = getXMLPath(response);
		return xmlPath.getList(xmlPathExpression);
	}
	
	public <T> List<Map<String, T>> readListOfMaps(Response response, String xmlPathExpression) {
		XmlPath xmlPath = getXMLPath(response);
		return xmlPath.getList(xmlPathExpression);
	}

}
