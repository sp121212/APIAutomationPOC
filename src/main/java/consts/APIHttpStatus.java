package consts;

public enum APIHttpStatus {
	
	OK_200(200,"OK"),
	CREATED_201(201,"Created"),
	NOCONTENT_204(204, "No Content"),
	BAD_REQUEST_400(400, "Bad request"),
	UNAUTHORIZED_401(401, "Unauthorized"),
	FORBIDDEN_403(403, "Forbidden"),
	NOT_FOUND_404(404, "Notfound"),
	INTERNAL_SERVER_ERROR_500(500, "Internal Server Error");
	
	private int statusCode;
	private String statusDesc;
	
	 private APIHttpStatus(int statusCode, String statusDesc) {
		 this.statusCode = statusCode;
		 this.statusDesc = statusDesc;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	 
}
