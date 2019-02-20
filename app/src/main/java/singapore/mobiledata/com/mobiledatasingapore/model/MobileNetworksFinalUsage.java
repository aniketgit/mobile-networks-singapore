package singapore.mobiledata.com.mobiledatasingapore.model;


public class MobileNetworksFinalUsage {
    private String quarter;
    private String oldDataQuarter;

    public String getOldDataQuarter() {
        return oldDataQuarter;
    }

    public void setOldDataQuarter(String oldDataQuarter) {
        this.oldDataQuarter = oldDataQuarter;
    }

    public int getIsQuarterDip() {
        return isQuarterDip;
    }

    public void setIsQuarterDip(int isQuarterDip) {
        this.isQuarterDip = isQuarterDip;
    }

    private int isQuarterDip;

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getAddingQuartersData() {
        return addingQuartersData;
    }

    public void setAddingQuartersData(String addingQuartersData) {
        this.addingQuartersData = addingQuartersData;
    }

    private String addingQuartersData;
}
