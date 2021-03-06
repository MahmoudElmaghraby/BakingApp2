package com.android.elmaghraby.bakingapp2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.elmaghraby.bakingapp2.Model.Step;
import com.android.elmaghraby.bakingapp2.R;
import com.android.elmaghraby.bakingapp2.StepActivity;
import com.android.elmaghraby.bakingapp2.StepFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepPagerAdapter extends RecyclerView.Adapter<StepPagerAdapter.ViewHolder> {


    private List<Object> list;
    private boolean isTwoPane;
    public static final String EXTRASTEP="steps";
    private Context context;

    public StepPagerAdapter(List<Object> list,boolean isTwoPane) {
        this.list = list;
        this.isTwoPane=isTwoPane;
    }

    @NonNull
    @Override
    public StepPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_holder_step,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepPagerAdapter.ViewHolder holder, int position) {

        Step step= (Step) list.get(position);
        if (step !=null){
            holder.shortDescription.setText(step.getShortDescription());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.description)
        TextView deccription;
        @BindView(R.id.short_description) TextView shortDescription;
        @BindView(R.id.videoUri) TextView VideoUrl;
        @BindView(R.id.stepImage)
        ImageView imageViewSetp;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if (position !=RecyclerView.NO_POSITION){
                        if (isTwoPane) {
                            Step clickItem = (Step) list.get(position);
                            Bundle argument = new Bundle();
                            argument.putParcelable(EXTRASTEP, clickItem);
                            //create fragment when activity is tablet
                            StepFragment fragment=new StepFragment();
                            fragment.setArguments(argument);

                            ((AppCompatActivity)context).getSupportFragmentManager()
                                    .beginTransaction().replace(R.id.frame_containar,fragment)
                                    .commit();

                        }else {
                            Context context=v.getContext();
                            Step clickItem = (Step) list.get(position);
                            Intent intent=new Intent(context,StepActivity.class);
                            intent.putExtra(EXTRASTEP,clickItem);
                            context.startActivity(intent);
                        }
                    }
                }
            });

        }
        public TextView getDeccription() {
            return deccription;
        }

        public void setDeccription(TextView deccription) {
            this.deccription = deccription;
        }

        public TextView getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(TextView shortDescription) {
            this.shortDescription = shortDescription;
        }

        public TextView getVideoUrl() {
            return VideoUrl;
        }

        public void setVideoUrl(TextView videoUrl) {
            VideoUrl = videoUrl;
        }
    }
}
