package rs.ac.ecommerceapp.reqApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class App {
    @JsonProperty("appid")
    public int appid;
    @JsonProperty("name")
    public String name;

    public App(int appid, String name) {
        this.appid = appid;
        this.name = name;
    }
    public App(){}


    @Override
    public String toString() {
        return "Detail{" +
                "appid=" + appid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
