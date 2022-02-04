package com.example.rxjava_retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {
    private List<com.example.rxjava_retrofit.MainData> arrayList;

    public MainAdapter(List<com.example.rxjava_retrofit.MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {                           //화면에 뷰를 그려준다 일반 onCreateView랑 비슷한거임

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {      // 아래ViewHolder의 연결된 각각의 변수값에 묵음 리스트의 인텍스 값을 할당 즉 해당 posion값은 같은 값이 들어갑니다.
        holder.iv_1.setImageResource(arrayList.get(position).getIv_1());
        holder.tv_userid.setText(arrayList.get(position).getUserid());
        holder.tv_id.setText(arrayList.get(position).getId());
        holder.tv_title.setText(arrayList.get(position).getTitle());
        holder.tv_body.setText(arrayList.get(position).getBody());



//        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {         //아래 ViewHolder의 클래스 itemView의 작은 아이템을 뭉쳐놓은 한뭉충이 주머니
            @Override
            public void onClick(View view) {
                String curName = holder.tv_userid.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show(); //해당 어댑터 클래스는 직접적으로 뷰랑 연결된 것이 아니기 때문에 뷰경로를 정해준다.(view.getContext())

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position){
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);  //어댑테에 내장 파일로 해당 기능은 데이터에 변경이 일어나면 F5해주는것이다.

        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder { //아이템들 각각의 뷰와 ArrayList안에 있는 실질적 데이터 변수들과 연결

        protected ImageView iv_1;
        protected TextView tv_userid;
        protected TextView tv_id;
        protected TextView tv_title;
        protected TextView tv_body;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_1=(ImageView) itemView.findViewById(R.id.iv_1);
            this.tv_userid=(TextView) itemView.findViewById(R.id.tv_userid);
            this.tv_id=(TextView) itemView.findViewById(R.id.tv_id);
            this.tv_title=(TextView) itemView.findViewById(R.id.tv_title);
            this.tv_body=(TextView) itemView.findViewById(R.id.tv_body);


        }
    }
}
