package singapore.mobiledata.com.mobiledatasingapore.presenter;




import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;


import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import singapore.mobiledata.com.mobiledatasingapore.R;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;
import singapore.mobiledata.com.mobiledatasingapore.view.MobileDataUsageView;
import singapore.mobiledata.com.mobiledatasingapore.webservice.APICallInterface;
import singapore.mobiledata.com.mobiledatasingapore.webservice.APIConnector;
import singapore.mobiledata.com.mobiledatasingapore.webservice.NoInternetException;

public class MobileDataPresenter {

    private final CompositeSubscription subscription;
    private MobileDataUsageView.View view;

    public MobileDataPresenter(MobileDataUsageView.View mobileDataUsageView) {
        view=mobileDataUsageView;
        subscription = new CompositeSubscription();
    }


    /**
     * Method to prepare a list of {@link singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel} first ordered by Sport, then ordered
     */
    public void getAllMobileDataUsageNUmbers() throws NoInternetException {

        final Subscription subscription = APIConnector.getConnector().getMobileUsageData()
                 .asObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                })
                .subscribe(new Observer<MobileDataModel>() {
                    @Override
                    public void onCompleted() {
                        view.onFetchDataCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onFetchDataError(e);


                    }



                    @Override
                    public void onNext(MobileDataModel mobileDataModel) {
                        view.onFetchDataSuccess(mobileDataModel);
                    }
                });

        this.subscription.add(subscription);

    }
}
