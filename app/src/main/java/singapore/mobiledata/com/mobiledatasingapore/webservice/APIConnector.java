package singapore.mobiledata.com.mobiledatasingapore.webservice;

/**
 * This class will provide the connectivity to the network interface, for one time initiation.
 */
public class APIConnector {

    /**
     * This method will establish the connection with retrofit and API network interface
     * @return API interface
     */
    public static APICallInterface getConnector() {
        APICallInterface apiInterface = APIRequestBuilder.apiBuilder().create(APICallInterface.class);
        return  apiInterface;
    }

}
