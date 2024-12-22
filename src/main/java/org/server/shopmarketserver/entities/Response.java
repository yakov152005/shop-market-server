package org.server.shopmarketserver.entities;

public class Response {
    private boolean success;
    private String error;

    public Response(){

    }

    public Response(boolean success, String error){
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", error='" + error + '\'' +
                '}';
    }
}