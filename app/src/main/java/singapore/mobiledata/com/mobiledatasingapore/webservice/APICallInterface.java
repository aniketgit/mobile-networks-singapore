package singapore.mobiledata.com.mobiledatasingapore.webservice;


import retrofit2.http.GET;
import rx.Observable;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;

public interface APICallInterface {

    @GET("?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f&limit=120")
    Observable<MobileDataModel> getMobileUsageData();
}
