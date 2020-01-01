package com.example.anfastats;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anfastats.ModelData.GameData;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.Matchadapterviewholder> {


    private List<GameData> gameData;
    private Context context;

    public MatchAdapter(List<GameData> gameData, Context context) {
        this.gameData = gameData;
        this.context = context;
    }

    @NonNull
    @Override
    public Matchadapterviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cardgames, viewGroup,false);
        return new Matchadapterviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Matchadapterviewholder matchadapterviewholder, int i) {

        matchadapterviewholder.textViewTeam1.setText(gameData.get(i).getFirstTeam());
        matchadapterviewholder.textViewTeam2.setText(gameData.get(i).getSecondTeam());
        matchadapterviewholder.textViewStadium.setText(gameData.get(i).getGameStadium());
        matchadapterviewholder.textViewMatchdate.setText(gameData.get(i).getGameTime());
        Picasso.with(context)
                .load(gameData.get(i).getImgTeam1()).into(matchadapterviewholder.imageViewTeam1);

        Picasso.with(context).load(gameData.get(i).getImgTeam2()).into(matchadapterviewholder.imageViewTeam2);


        matchadapterviewholder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateStats.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                intent.putExtra("gameid",gameData.get(i).getGameid());
                intent.putExtra("team1",gameData.get(i).getFirstTeam());
                intent.putExtra("team2",gameData.get(i).getSecondTeam());
                context.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return gameData.size();
    }

    public class Matchadapterviewholder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textViewTeam1, textViewTeam2, textViewStadium, textViewMatchdate;
        ImageView imageViewTeam1, imageViewTeam2;

        public Matchadapterviewholder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.matchday);
            textViewTeam1 = itemView.findViewById(R.id.textviewteam1);
            textViewTeam2 = itemView.findViewById(R.id.textviewteam2);
            textViewStadium = itemView.findViewById(R.id.Stadium);
            textViewMatchdate = itemView.findViewById(R.id.txtviewmatchdate);
            imageViewTeam1 = itemView.findViewById(R.id.Imageviewteam1);
            imageViewTeam2 = itemView.findViewById(R.id.Imageviewteam2);


        }






        }
    }

