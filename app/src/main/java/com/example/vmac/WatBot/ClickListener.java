package com.example.vmac.WatBot;

import android.view.View;

/**
 * Created by VMac on 06/01/17.
 * Documentation added by mpeyrotc on 9/28/2017.
 * <p>
 * This interface specifies the different methods available to handle user input
 * in the form of clicks or presses.
 *
 * @author VMac
 * @author mpeyrotc
 * @version 1.0
 */
public interface ClickListener {
    /**
     * Handles the case in which the user clicks a message item in the chat.
     *
     * @param view     the {@code View} object that holds a specific message.
     * @param position the position within the chat conversation in which the specific
     *                 message is placed. The initial 'hello' greeting from Watson is
     *                 located at position 0.
     */
    void onClick(View view, int position);

    /**
     * Handles the case in which the user clicks a message item in the chat, and holds
     * his/her finger in position (maintains the message pressed).
     *
     * @param view     the {@code View} object that holds a specific message.
     * @param position the position within the chat conversation in which the specific
     *                 message is placed. The initial 'hello' greeting from Watson is
     *                 located at position 0.
     */
    void onLongClick(View view, int position);
}