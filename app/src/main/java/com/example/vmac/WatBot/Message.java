package com.example.vmac.WatBot;

import java.io.Serializable;

/**
 * Created by VMac on 17/11/16.
 * <p>
 * The message class is intended to serve as the storage unit
 * for the conversation elements between Watson and the user. It holds a
 * unique identifier and a message content.
 *
 * @author VMac
 * @version 1.0
 */
public class Message implements Serializable {
    String id, message;

    /**
     * Getter for the message ID.
     *
     * @return the ID of the message.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the message ID.
     *
     * @param id the ID that this message will be identified uniquely with.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the message content.
     *
     * @return the content of the message as a {@code String}.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter for the message content.
     *
     * @param message the content that the message will hold.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}

