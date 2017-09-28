package com.example.vmac.WatBot;

/**
 * Created by VMac on 17/11/16.
 */

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int SELF = 100;
    private ArrayList<Message> messageArrayList;
    private Map<String, Integer> images;

    {
        images = new HashMap<>();
        images.put("Ponga sus brazos alrededor de la cintura de la persona que se está asfixiando. Inclínelo un poco hacia delante de su cintura. Haga un puño con una de sus manos. Coloque el lado del dedo pulgar de su puño entre el ombligo de la persona y la parte más baja de sus costillas. No coloque su puño sobre las costillas. Coloque la otra mano sobre su puño. Presione su puño contra el abdomen de la persona con una compresión rápida hacia adentro y hacia arriba. Repita las compresiones hasta que el objeto salga. Si la persona vomita, acuéstelo de lado para evitar que el objeto obstruya totalmente sus vías respiratorias.",
                R.drawable.imagen_1);
        images.put("Se está atragantando con algo? Si no, realiza respiración boca a boca 12 veces cada minuto hasta que pueda respirar por su cuenta. Sigue alerta de ella.",
                R.drawable.imagen_2);
        images.put("Se está atragantando con algo? Si no, realiza respiración boca a boca 20 veces por minuto hasta que pueda respirar por su cuenta y sigue alerta de ella.",
                R.drawable.imagen_2);
        images.put("Realiza ciclos de 30 segundos donde hagas 30 compresiones torácicas y 2 insuflaciones",
                R.drawable.imagen_3);
    }


    public ChatAdapter(ArrayList<Message> messageArrayList) {
        this.messageArrayList=messageArrayList;

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
        if (message.getId()!=null && message.getId().equals("1")) {
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView message;

        public ViewHolder(View view) {
            super(view);
            message = (TextView) itemView.findViewById(R.id.message);
            ImageView image = (ImageView) itemView.findViewById(R.id.watson_image);

            String key = messageArrayList.get(getItemCount() - 1).getMessage();

            if(images.containsKey(key)) {
                image.setImageResource(images.get(key));
            }

            //TODO: Uncomment this if you want to use a custom Font
            /*String customFont = "Montserrat-Regular.ttf";
            Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), customFont);
            message.setTypeface(typeface);*/
        }
    }


}