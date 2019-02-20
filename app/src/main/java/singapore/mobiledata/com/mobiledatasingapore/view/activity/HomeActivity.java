package singapore.mobiledata.com.mobiledatasingapore.view.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import singapore.mobiledata.com.mobiledatasingapore.R;
import singapore.mobiledata.com.mobiledatasingapore.adapter.MobileDataUsageAdapter;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileNetworksFinalUsage;
import singapore.mobiledata.com.mobiledatasingapore.presenter.MobileDataPresenter;
import singapore.mobiledata.com.mobiledatasingapore.view.MobileDataUsageView;
import singapore.mobiledata.com.mobiledatasingapore.webservice.NoInternetException;

public class HomeActivity extends AppCompatActivity implements MobileDataUsageView.View {

    private MobileDataPresenter presenter;
    private RecyclerView mobileUsageRecyclerView;
    private MobileDataUsageAdapter adapter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mobileUsageRecyclerView=findViewById(R.id.rvMobileDataUsageList);
         dialog = new ProgressDialog(this);
        dialog.setMessage(getString(R.string.toast_loading));
        dialog.show();
        presenter = new MobileDataPresenter(this);
        try {
            presenter.getAllMobileDataUsageNUmbers();
        } catch (NoInternetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFetchDataStarted() {

    }

    @Override
    public void onFetchDataCompleted() {

    }

    @Override
    public void onFetchDataSuccess(MobileDataModel mobileDataModel) {

    }

    @Override
    public void onGettingYearData(List<MobileNetworksFinalUsage> mobileNetworksFinalUsage) {
        mobileUsageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MobileDataUsageAdapter(this, mobileNetworksFinalUsage);
        mobileUsageRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        dialog.dismiss();
    }

    @Override
    public void onFetchDataError(Throwable e) {

    }
}
