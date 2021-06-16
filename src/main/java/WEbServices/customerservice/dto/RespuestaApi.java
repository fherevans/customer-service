package WEbServices.customerservice.dto;

public class RespuestaApi {

    private String message;

    public RespuestaApi(){}

    public RespuestaApi(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
