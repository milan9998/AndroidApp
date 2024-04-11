package rs.ac.ecommerceapp.reqApi;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Apps {

    @JsonProperty("apps")
    List<App> lista;

    public Apps(List<App> lista) {
        this.lista = lista;
    }
    public Apps(){

    }
    @Override
    public String toString() {
        return "Details{" +
                "lista=" + lista +
                '}';
    }

    public List<App> getLista() {
        return lista;
    }

    public void setLista(List<App> lista) {
        this.lista = lista;
    }

}
