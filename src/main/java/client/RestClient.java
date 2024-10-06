package client;

import java.util.Map;
import exp.ApiFrameWorkException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	private static RequestSpecBuilder specBuilder;
	private static final String BASEURI = "";
	private static final String bearerToken = "";

	static {
		specBuilder = new RequestSpecBuilder();
	}

	public void addAuthenticationHeader() {
		specBuilder.addHeader("Authentication", "Bearer " + bearerToken);
	}

	private RequestSpecBuilder setRequestContentType(String contentType) {

		switch (contentType.toLowerCase()) {

		case "json":
			return specBuilder.setContentType(ContentType.JSON);

		case "xml":
			return specBuilder.setContentType(ContentType.XML);

		case "text":
			return specBuilder.setContentType(ContentType.TEXT);

		default:
			throw new ApiFrameWorkException("Wrong contentType provided!! (it should be json or xml or text)");
		}
	}

	private RequestSpecification createRequestSpec() {
		specBuilder.setBaseUri(BASEURI);
		addAuthenticationHeader();
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Map<String, String> headersMap) {
		specBuilder.setBaseUri(BASEURI);
		addAuthenticationHeader();

		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Map<String, String> headersMap, Map<String, String> queryParam) {
		specBuilder.setBaseUri(BASEURI);

		addAuthenticationHeader();

		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}

		if (queryParam != null) {
			specBuilder.addQueryParams(queryParam);
		}
		return specBuilder.build();
	}

	// POST CALL

	private RequestSpecification createRequestSpec(Object requestBody, String contentType) {
		specBuilder.setBaseUri(BASEURI);
		addAuthenticationHeader();
		setRequestContentType(contentType);
		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Object requestBody, String contentType,
			Map<String, String> headersMap) {

		specBuilder.setBasePath(BASEURI);
		addAuthenticationHeader();
		setRequestContentType(contentType);

		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}

		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}

		return specBuilder.build();
	}

	// HTTP Methods utils

	public Response get(String serviceURL, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec()).log().all().when().get(serviceURL);
		}

		return RestAssured.given(createRequestSpec()).when().get(serviceURL);
	}

	public Response get(String serviceURL, Map<String, String> headersMap, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(headersMap)).log().all().when().get(serviceURL);
		}

		return RestAssured.given(createRequestSpec(headersMap)).when().get(serviceURL);
	}

	public Response get(String serviceURL, Map<String, String> headersMap, Map<String, String> queryParam,
			boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(headersMap, queryParam)).log().all().when().get(serviceURL);
		}

		return RestAssured.given(createRequestSpec(headersMap, queryParam)).when().get(serviceURL);
	}

	public Response post(String serviceURL, String contentType, Object requestBody, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).when().post(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType)).when().post(serviceURL);
	}

	public Response post(String serviceURL, String contentType, Object requestBody, Map<String, String> headersMap,
			boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).when().post(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).when().post(serviceURL);
	}

	public Response put(String serviceURL, String contentType, Object requestBody, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).when().put(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType)).when().put(serviceURL);
	}

	public Response put(String serviceURL, String contentType, Object requestBody, Map<String, String> headersMap,
			boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).when().put(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).when().put(serviceURL);
	}

	public Response patch(String serviceURL, String contentType, Object requestBody, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType)).when().patch(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType)).when().patch(serviceURL);
	}

	public Response patch(String serviceURL, String contentType, Object requestBody, Map<String, String> headersMap,
			boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).when().patch(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap)).when().patch(serviceURL);
	}
	
	public Response delete(String serviceURL, boolean log) {
		
		if(log) {
			return RestAssured.given(createRequestSpec()).when().delete(serviceURL);
		}
		
		return RestAssured.given(createRequestSpec()).when().delete(serviceURL);
	}
}
