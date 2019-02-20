package singapore.mobiledata.com.mobiledatasingapore.presenter;
import android.util.Log;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.Key;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import singapore.mobiledata.com.mobiledatasingapore.R;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataRecords;
import singapore.mobiledata.com.mobiledatasingapore.model.MobileNetworksFinalUsage;
import singapore.mobiledata.com.mobiledatasingapore.view.MobileDataUsageView;
import singapore.mobiledata.com.mobiledatasingapore.webservice.APICallInterface;
import singapore.mobiledata.com.mobiledatasingapore.webservice.APIConnector;
import singapore.mobiledata.com.mobiledatasingapore.webservice.NoInternetException;

public class MobileDataPresenter {


    private MobileDataUsageView.View view;

    public MobileDataPresenter(MobileDataUsageView.View mobileDataUsageView) {
        view = mobileDataUsageView;

    }


    /**
     * Method to prepare a list of {@link singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel} first ordered by Sport, then ordered
     */
    public void getAllMobileDataUsageNUmbers() throws NoInternetException {

        Call<MobileDataModel> mobileDataModelCall = APIConnector.getConnector().getMobileUsageData("a807b7ab-6cad-4aa6-87d0-e283a7353a0f", 120);
        mobileDataModelCall.enqueue(new Callback<MobileDataModel>() {

            @Override
            public void onResponse(Call<MobileDataModel> call, Response<MobileDataModel> response) {
                view.onFetchDataSuccess(response.body());
                addQuartersInData(response.body());
            }

            @Override
            public void onFailure(Call<MobileDataModel> call, Throwable t) {

            }
        });
    }

    /**
     * (This method is use to filter the data from the server and shown in the list)
     * @param mobileDataModel
     * @return

     */

    public void addQuartersInData(MobileDataModel mobileDataModel) {
        MobileNetworksFinalUsage mobileNetworksFinalUsage=null;
        List<MobileNetworksFinalUsage> mobileNetworksFinalUsageArrayList=new ArrayList<>();
        HashMap<String, List<MobileDataModel>> hashMap = new HashMap<String, List<MobileDataModel>>();
        for (int i = 0; i <= mobileDataModel.getResult().getRecords().size()-1 ; i++) {

            String key = mobileDataModel.getResult().getRecords().get(i).getQuarter().substring(0, 4);
            if (hashMap.containsKey(key)) {
                List<MobileDataModel> list = hashMap.get(key);
                list.add(mobileDataModel);
                mobileNetworksFinalUsage.setQuarter(mobileDataModel.getResult().getRecords().get(i).getQuarter().substring(0, 4));

                BigDecimal convertToInt= new BigDecimal(mobileDataModel.getResult().getRecords().get(i).getVolume_of_mobile_data());;
                BigDecimal convertToIntAnother= new BigDecimal(mobileNetworksFinalUsage.getAddingQuartersData());
                mobileNetworksFinalUsage.setAddingQuartersData(String.valueOf(convertToInt.add(convertToIntAnother)));
                BigDecimal compareToIntAnother= new BigDecimal(mobileNetworksFinalUsage.getOldDataQuarter());
                if(mobileNetworksFinalUsage.getIsQuarterDip() != -1) {
                    mobileNetworksFinalUsage.setIsQuarterDip(convertToInt.compareTo(compareToIntAnother));
                }

                mobileNetworksFinalUsage.setOldDataQuarter(mobileDataModel.getResult().getRecords().get(i).getVolume_of_mobile_data());




            } else {
                if(i!=0) {
                    mobileNetworksFinalUsageArrayList.add(mobileNetworksFinalUsage);
                }
                List<MobileDataModel> list = new ArrayList<MobileDataModel>();
                list.add(mobileDataModel);
                mobileNetworksFinalUsage=new MobileNetworksFinalUsage();
                mobileNetworksFinalUsage.setQuarter(mobileDataModel.getResult().getRecords().get(i).getQuarter().substring(0, 4));
                mobileNetworksFinalUsage.setAddingQuartersData(mobileDataModel.getResult().getRecords().get(i).getVolume_of_mobile_data());
                mobileNetworksFinalUsage.setOldDataQuarter(mobileDataModel.getResult().getRecords().get(i).getVolume_of_mobile_data());
                hashMap.put(key, list);
                if(key.equalsIgnoreCase("2018")){
                    mobileNetworksFinalUsageArrayList.add(mobileNetworksFinalUsage);
                }
            }

        }

        view.onGettingYearData(mobileNetworksFinalUsageArrayList);

    }
}

