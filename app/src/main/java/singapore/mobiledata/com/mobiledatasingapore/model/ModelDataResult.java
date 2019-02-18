package singapore.mobiledata.com.mobiledatasingapore.model;


import java.util.List;

public class ModelDataResult {
    public List<ModelDataResult> getMobileDataResults() {
        return mobileDataResults;
    }

    public void setMobileDataResults(List<ModelDataResult> mobileDataResults) {
        this.mobileDataResults = mobileDataResults;
    }

    private List<ModelDataResult> mobileDataResults;
}
