package elements;

public class CircuitAPI {
	
	public static final String JSON_PATH_ALBERTPARK_LOCATION = "$.MRData.CircuitTable.Circuits[?(@.circuitId == 'circuitid_variable_name')].Location.country";

	
	public static String getCountryNameThroughCircuitID(String circuitID) {
			return JSON_PATH_ALBERTPARK_LOCATION.replace("circuitid_variable_name", circuitID);
	}
	
}
