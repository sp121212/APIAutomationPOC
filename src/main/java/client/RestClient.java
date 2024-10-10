package client;

import java.util.Map;
import java.util.Properties;

import exp.ApiFrameWorkException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

	private static RequestSpecBuilder specBuilder;
//	private static final String BASEURI = "https://gorest.co.in";
//	private static final String bearerToken = "95a8ce8d61a500d5b9ed7c34fb4cf89eb0448ce1536cc6e9c549f356f6038d61";
	private Properties prop;
	private String baseUri;

	public RestClient(Properties prop, String baseURI) {
		specBuilder = new RequestSpecBuilder();
		this.prop = prop;
		this.baseUri = baseURI;
	}

	public void addAuthenticationHeader() {
		specBuilder.addHeader("Authorization", "Bearer " + prop.getProperty("bearerToken"));
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

	private RequestSpecification createRequestSpec(boolean inclAuth) {
		specBuilder.setBaseUri(baseUri);
		if (inclAuth) {
			addAuthenticationHeader();
		}
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Map<String, String> headersMap,boolean inclAuth) {
		specBuilder.setBaseUri(baseUri);
		if (inclAuth) {
			addAuthenticationHeader();
		}

		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Map<String, String> headersMap, Map<String, String> queryParam,boolean inclAuth) {
		specBuilder.setBaseUri(baseUri);

		if (inclAuth) {
			addAuthenticationHeader();
		}

		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}

		if (queryParam != null) {
			specBuilder.addQueryParams(queryParam);
		}
		return specBuilder.build();
	}

	// POST CALL

	private RequestSpecification createRequestSpec(Object requestBody, String contentType,boolean inclAuth) {
		specBuilder.setBaseUri(baseUri);
		if (inclAuth) {
			addAuthenticationHeader();
		}
		setRequestContentType(contentType);
		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Object requestBody, String contentType,
			Map<String, String> headersMap, boolean inclAuth) {

		specBuilder.setBasePath(baseUri);
		if (inclAuth) {
			addAuthenticationHeader();
		}
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

	public Response get(String serviceURL, boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(inclAuth)).log().all().when().get(serviceURL);
		}

		return RestAssured.given(createRequestSpec(inclAuth)).when().get(serviceURL);
	}

	public Response get(String serviceURL, Map<String, String> headersMap, boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(headersMap, inclAuth)).log().all().when().get(serviceURL);
		}

		return RestAssured.given(createRequestSpec(headersMap, inclAuth)).when().get(serviceURL);
	}

	public Response get(String serviceURL, Map<String, String> queryParam, Map<String, String> headersMap,
			boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(headersMap, queryParam, inclAuth)).log().all().when().get(serviceURL);
		}

		return RestAssured.given(createRequestSpec(headersMap, queryParam, inclAuth)).when().get(serviceURL);
	}

	public Response post(String serviceURL, String contentType, Object requestBody, boolean log, boolean inclAuth) {
		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, inclAuth)).log().all().when().post(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, inclAuth)).when().post(serviceURL);
	}

	public Response post(String serviceURL, String contentType, Object requestBody, Map<String, String> headersMap,
			boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap, inclAuth)).log().all().when()
					.post(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap, inclAuth)).when().post(serviceURL);
	}

	public Response put(String serviceURL, String contentType, Object requestBody, boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, inclAuth)).log().all().when().put(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, inclAuth)).when().put(serviceURL);
	}

	public Response put(String serviceURL, String contentType, Object requestBody, Map<String, String> headersMap,
			boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap, inclAuth)).log().all().when()
					.put(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap, inclAuth)).when().put(serviceURL);
	}

	public Response patch(String serviceURL, String contentType, Object requestBody, boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, inclAuth)).log().all().when().patch(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, inclAuth)).when().patch(serviceURL);
	}

	public Response patch(String serviceURL, String contentType, Object requestBody, Map<String, String> headersMap,
			boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap, inclAuth)).log().all().when()
					.patch(serviceURL);
		}

		return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap, inclAuth)).when().patch(serviceURL);
	}

	public Response delete(String serviceURL, boolean log, boolean inclAuth) {

		if (log) {
			return RestAssured.given(createRequestSpec(inclAuth)).log().all().when().delete(serviceURL);
		}

		return RestAssured.given(createRequestSpec(inclAuth)).when().delete(serviceURL);
	}
}
