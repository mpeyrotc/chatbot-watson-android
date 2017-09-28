package com.example.vmac.WatBot;

/**
 * Created by VMac on 17/11/16.
 */

import java.io.Serializable;

public class Message implements Serializable {
    String id, message, image_id = null;

    public Message() {
    }

    public Message(String id, String message, String createdAt) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image_id;
    }

    public void setImage(String id) {
        image_id = id;
    }
}

