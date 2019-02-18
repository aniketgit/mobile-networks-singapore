package singapore.mobiledata.com.mobiledatasingapore.webservice;

public class NoInternetException extends Exception {

    public NoInternetException() {
        super("No Internet connection");
    }
}
