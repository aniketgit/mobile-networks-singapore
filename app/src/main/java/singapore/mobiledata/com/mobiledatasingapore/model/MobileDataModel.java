package singapore.mobiledata.com.mobiledatasingapore.model;

import java.util.List;

public class MobileDataModel {

    private String help;

    public String getGetOldDataInQuarter() {
        return getOldDataInQuarter;
    }

    public void setGetOldDataInQuarter(String getOldDataInQuarter) {
        this.getOldDataInQuarter = getOldDataInQuarter;
    }

    private String getOldDataInQuarter;

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }


    public ModelDataResult getResult() {
        return result;
    }

    public void setResult(ModelDataResult result) {
        this.result = result;
    }

    private ModelDataResult result;

}
