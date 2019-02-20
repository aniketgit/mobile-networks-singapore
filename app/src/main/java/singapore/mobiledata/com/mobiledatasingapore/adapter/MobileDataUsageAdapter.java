package singapore.mobiledata.com.mobiledatasingapore.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import singapore.mobiledata.com.mobiledatasingapore.R;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileNetworksFinalUsage;

public class MobileDataUsageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<MobileNetworksFinalUsage> list;

    public MobileDataUsageAdapter(Context context, List<MobileNetworksFinalUsage> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile_data_usage,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListViewHolder listViewHolder = (ListViewHolder) holder;
        listViewHolder.textYear.setText(list.get(position).getQuarter());
        listViewHolder.textUsageDataYear.setText(list.get(position).getAddingQuartersData());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {


        public TextView textYear,textUsageDataYear;


        public ListViewHolder(View itemView) {

            super(itemView);
            this.setIsRecyclable(false);

            textYear = (TextView) itemView.findViewById(R.id.tvYear);
            textUsageDataYear = (TextView) itemView.findViewById(R.id.tvYearData);



        }

    }
}
