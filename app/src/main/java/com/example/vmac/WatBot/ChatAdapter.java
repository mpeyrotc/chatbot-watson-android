package com.example.vmac.WatBot;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by VMac on 17/11/16.
 * Modified by mpeyrotc on 9/28/17.
 * <p>
 * The ChatAdapter extends a {@code RecycleView} and acts as a holder for the
 * message boxes generated between Watson and the user. It has a message size limit
 * of 100 and holds the mappings for showing helpful images to the user if requested.
 *
 * @author VMac
 * @author mpeyrotc
 * @version 1.0
 */
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int SELF = 100;
    private final ArrayList<Message> messageArrayList;
    private final Map<String, Integer> images;

    {
        images = new HashMap<>();
        images.put("Ponga sus brazos alrededor de la cintura de la persona vertical que se está asfixiando. Inclínelo un poco hacia delante de su cintura. Haga un puño con una de sus manos. Coloque el lado del dedo pulgar de su puño entre el ombligo de la persona y la parte más baja de sus costillas. No coloque su puño sobre las costillas. Coloque la otra mano sobre su puño. Presione su puño contra el abdomen de la persona con una compresión rápida hacia adentro y hacia arriba. Repita las compresiones hasta que el objeto salga. Si la persona vomita, acuéstelo de lado para evitar que el objeto obstruya totalmente sus vías respiratorias.",
                R.drawable.imagen_1);
        images.put("Se está atragantando con algo? Si no, realiza respiración boca a boca 12 veces cada minuto hasta que pueda respirar por su cuenta. Sigue alerta de ella.",
                R.drawable.imagen_2);
        images.put("Se está atragantando con algo? Si no, realiza respiración boca a boca 20 veces por minuto hasta que pueda respirar por su cuenta y sigue alerta de ella.",
                R.drawable.imagen_2);
        images.put("Realiza ciclos de 30 segundos donde hagas 30 compresiones torácicas y 2 insuflaciones",
                R.drawable.imagen_3);
        images.put("El auxiliante se coloca arrodillado y con sus manos una sobre la otra debe presionar fuerte mente la parte alta del abdomen (por debajo de las costillas) para hacer subir violentamente el diafragma y provocar la salida brusca del aire de los pulmones; de esta forma se expulsa el objeto de las vías respiratorias.",
                R.drawable.imagen_4);
        images.put("Ponga sus brazos alrededor de la cintura de la persona sentada que se está asfixiando. Inclínelo un poco hacia delante de su cintura. Haga un puño con una de sus manos. Coloque el lado del dedo pulgar de su puño entre el ombligo de la persona y la parte más baja de sus costillas. No coloque su puño sobre las costillas. Coloque la otra mano sobre su puño. Presione su puño contra el abdomen de la persona con una compresión rápida hacia adentro y hacia arriba. Repita las compresiones hasta que el objeto salga. Si la persona vomita, acuéstelo de lado para evitar que el objeto obstruya totalmente sus vías respiratorias.",
                R.drawable.imagen_5);
    }


    /**
     * Default constructor for the adapter. When created, receives a reference to the messages
     * held by the {@link com.example.vmac.WatBot.MainActivity MainActivity}.
     *
     * @param messageArrayList the {@code List} that contains the messages exchanged between
     *                         Watson and the user.
     */
    public ChatAdapter(ArrayList<Message> messageArrayList) {
        this.messageArrayList = messageArrayList;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        // view type is to identify where to render the chat message
        // left or right
        if (viewType == SELF) {
            // self message
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_item_self, parent, false);
        } else {
            // WatBot message
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_item_watson, parent, false);
        }


        return new ViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageArrayList.get(position);
        if (message.getId() != null && message.getId().equals("1")) {
            return SELF;
        }

        return position;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        Message message = messageArrayList.get(position);
        message.setMessage(message.getMessage());
        ((ViewHolder) holder).message.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }

    /**
     * The ViewHolder class identifies each message's content (the actual text message) and
     * determines if the given text should be accompanied by an explanatory image.
     * If this is the case, the image is appended to the conversation below the corresponding
     * message sent be Watson.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Each message generated during a char conversation
        TextView message;

        /**
         * The ViewHolder method checks each {@code View} object that represents a message.
         * If the message matches a given key, the corresponding image that accompanies
         * such text is appended in an {@code ImageView} object.
         * <p>
         * It is worth noting that the match could be made to either a Watson response
         * or a user's query.
         *
         * @param view the {@code View} object that holds a specific message instance.
         */
        public ViewHolder(View view) {
            super(view);
            message = itemView.findViewById(R.id.message);
            ImageView image = itemView.findViewById(R.id.watson_image);

            String key = messageArrayList.get(getItemCount() - 1).getMessage();

            if (images.containsKey(key)) {
                image.setImageResource(images.get(key));
            }
        }
    }
}