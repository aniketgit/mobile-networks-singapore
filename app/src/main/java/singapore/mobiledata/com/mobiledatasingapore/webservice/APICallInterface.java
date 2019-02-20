package singapore.mobiledata.com.mobiledatasingapore.webservice;


import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;

public interface APICallInterface {

    @GET("datastore_search?")
    Call<MobileDataModel> getMobileUsageData(@Query("resource_id") String resourceId,@Query("limit") int limit);
}
