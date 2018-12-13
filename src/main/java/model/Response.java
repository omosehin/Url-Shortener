package model;

public class Response {
    private final String code;
    private final String description;
    private final String error;
    private final String shorturl;

    public Response(String code, String description, String error, String shorturl) {
        this.code = code;
        this.description = description;
        this.error = error;
        this.shorturl = shorturl;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getError() {
        return error;
    }

    public String getShorturl() {
        return shorturl;
    }
}
