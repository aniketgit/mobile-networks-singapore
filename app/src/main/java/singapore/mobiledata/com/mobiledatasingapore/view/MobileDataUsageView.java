package singapore.mobiledata.com.mobiledatasingapore.view;

import java.util.List;

import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileNetworksFinalUsage;

public interface MobileDataUsageView {

    interface View {

        void onFetchDataStarted();

        void onFetchDataCompleted();

        void onFetchDataSuccess(MobileDataModel mobileDataModel);

        void onGettingYearData(List<MobileNetworksFinalUsage> mobileNetworksFinalUsage);

        void onFetchDataError(Throwable e);
    }

    interface Presenter {

        void loadData();

        void subscribe();

        void unsubscribe();

        void onDestroy();

    }

}
