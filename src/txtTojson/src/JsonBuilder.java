
import java.io.*;
import java.util.*;

public class JsonBuilder {

    public static void customersToObject(Queue<customer> asiakkaat){
        try (BufferedReader br = new BufferedReader(new FileReader("txtTojson/customers.txt"))) {

            // Read file line by line
            String ln;
            while ((ln = br.readLine()) != null) {
                // Create new Employee object
                customer asiakas = new customer();
                asiakas.setId(Integer.parseInt(ln));
                for(int i = 0 ; i <= 4 ; i++){
                    ln = br.readLine();
                    if (i == 0){
                        asiakas.setEtunimi(ln);
                    }
                    else if (i == 1){
                        asiakas.setSukunimi(ln);
                    }
                    else if (i == 3){
                        asiakas.setOstotapahtumienSumma(Integer.parseInt(ln));
                    }
                }
                // Add object to list
                asiakkaat.add(asiakas);
                if (ln == null)
                    break;
            }

            // Further process your Employee objects...
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Queue<customer> asiakkaat = new ArrayDeque<>();
        customersToObject(asiakkaat);
        try {
            FileWriter writer = new FileWriter("txtTojson/customers.json");
            writer.write("[ \n");
            while (!asiakkaat.isEmpty()){
                customer asiakas = asiakkaat.poll();
                String json = "{\n\"asiakasID\":" + asiakas.getId() + ",\n\"etunimi\":\"" + asiakas.getEtunimi() + "\",\n\"sukunimi\":\"" + asiakas.getSukunimi() + "\",\n\"ostotapahtumienSumma\":" + asiakas.getOstotapahtumienSumma() + "\n}";
                writer.append(json);
                if(!asiakkaat.isEmpty())
                    writer.append(",\n");
            }
            writer.append("\n]");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
