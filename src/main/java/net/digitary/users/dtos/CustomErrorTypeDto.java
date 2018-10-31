package net.digitary.users.dtos;


import java.io.Serializable;

public final class CustomErrorTypeDto implements Serializable {

    private final int status;
    private final String message;
    private final String path;
    private final long timestamp;

    public CustomErrorTypeDto(int status, String path, String message, long timestamp){
        super();
        this.status = status;
        this.path=path;
        this.message = message;
        this.timestamp=timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
