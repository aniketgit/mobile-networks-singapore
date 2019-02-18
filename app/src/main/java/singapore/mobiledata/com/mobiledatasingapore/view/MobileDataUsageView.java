package singapore.mobiledata.com.mobiledatasingapore.view;

import singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel;

public interface MobileDataUsageView {

    /**
     * Method to display the passed {@link singapore.mobiledata.com.mobiledatasingapore.model.MobileDataModel} list
     *
     * @param mobileDataModel

     */
    void displayMobileUsage(MobileDataModel mobileDataModel);

    void error(String msg);
}
