import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class customer {

    private int id;
    private String etunimi;
    private String sukunimi;
    private int ostotapahtumienSumma;



    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getEtunimi(){
        return etunimi;
    }
    public void setEtunimi(String etunimi){
        this.etunimi = etunimi;
    }
    public String getSukunimi(){
        return sukunimi;
    }
    public void setSukunimi(String sukunimi){
        this.sukunimi = sukunimi;
    }
    public int getOstotapahtumienSumma(){
        return ostotapahtumienSumma;
    }
    public void setOstotapahtumienSumma(int ostotapahtumienSumma){
        this.ostotapahtumienSumma = ostotapahtumienSumma;
    }
    @Override
    public String toString() {
        return String.format("ID: %d\r\nEtunimi: %s\r\nSukunimi: %s\r\nOstotapahtumienSumma: %s\r\n",
                id, etunimi, sukunimi, ostotapahtumienSumma);
    }
}
