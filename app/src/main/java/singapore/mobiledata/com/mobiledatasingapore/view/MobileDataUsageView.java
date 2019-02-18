package singapore.mobiledata.com.mobiledatasingapore.view;

import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;

public interface MobileDataUsageView {

    interface View {

        void onFetchDataStarted();

        void onFetchDataCompleted();

        void onFetchDataSuccess(MobileDataModel mobileDataModel);

        void onFetchDataError(Throwable e);
    }

    interface Presenter {

        void loadData();

        void subscribe();

        void unsubscribe();

        void onDestroy();

    }

}
