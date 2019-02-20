package singapore.mobiledata.com.mobiledatasingapore.model;


import java.util.List;

public class ModelDataResult {

    public List<MobileDataRecords> getRecords() {
        return records;
    }

    public void setRecords(List<MobileDataRecords> records) {
        this.records = records;
    }

    private List<MobileDataRecords> records;
}
