package rs.ac.ecommerceapp.reqApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppList {
    @JsonProperty("applist")
    public Apps applist;

    public AppList(Apps applist) {
        this.applist = applist;
    }
    public AppList(){

    }
    public Apps getApplist() {
        return applist;
    }

    public void setApplist(Apps applist) {
        this.applist = applist;
    }

    @Override
    public String toString() {
        return "AppList{" +
                "listApi=" + applist +
                '}';
    }
}
