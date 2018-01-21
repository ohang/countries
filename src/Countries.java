import java.io.*;
import java.util.ArrayList;

/**
 * Created by Goro on 21.01.2018.
 */
public class Countries {
    public static void main(String[] args) throws IOException {
        Country c = new Country(1,"AM","Armenia","Armenie");
        ArrayList<Country> countryList= new ArrayList<Country>();
        String csvFile = "C:\\Users\\Goro\\Desktop\\countries.csv";
        String line = "";
        String cvsSplitBy = ",";



        int id=0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                countryList.add(new Country(id,country[0],country[1],country[2]));
                id++;


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char ch;

        BufferedReader buf  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("if you want sort by FrenchName click 1 if you want sort by EngName click 2");

        ch =(char) buf.read();
        if (ch=='1'){
            Country.sortbyEng(countryList);


        } else if (ch=='2'){
            Country.sortbyFrench(countryList);


        }


        for (int i=0; i<countryList.size(); i++) {
            System.out.println("  "+countryList.get(i).countryid+" " +
                    "" +countryList.get(i).countryCode+" " +
                    ""+countryList.get(i).nameEng + "/" + countryList.get(i).nameFrench);
        }










    }



}






class Country {
   int countryid ;
   String countryCode;
   String nameEng;
   String nameFrench;

    public Country(int countryid,String countryCode, String nameEng, String nameFrench) {
        this.countryid = countryid;
        this.countryCode=countryCode;
        this.nameEng = nameEng;
        this.nameFrench = nameFrench;
    }

    public int getCountryid() {
        return countryid;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNameEng() {
        return nameEng;
    }

    public String getNameFrench() {
        return nameFrench;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setNameFrench(String nameFrench) {
        this.nameFrench = nameFrench;
    }

   static  void sortbyFrench(ArrayList<Country> country){
     //   int i=0;
        for (int v = 0; v<country.size()-1;v++){
            for (int i=0 ; i<country.size()-v-1;i++){
            if (country.get(i).nameFrench.compareTo(country.get(i+1).nameFrench)>0){
                Country tmp = country.get(i);
                country.set(i,country.get(i+1));
                country.set(i+1,tmp);
              //  i++;
            }}
        }
    }
    static  void sortbyEng(ArrayList<Country> country){
        //   int i=0;
        for (int v = 0; v<country.size()-1;v++){
            for (int i=0 ; i<country.size()-v-1;i++){
                if (country.get(i).nameEng.compareTo(country.get(i+1).nameEng)>0){
                    Country tmp = country.get(i);
                    country.set(i,country.get(i+1));
                    country.set(i+1,tmp);
                    //  i++;
                }}
        }
    }
    static  void sortbyZone(ArrayList<Country> country){
        //   int i=0;
        for (int v = 0; v<country.size()-1;v++){
            for (int i=0 ; i<country.size()-v-1;i++){
                if (country.get(i).countryCode.compareTo(country.get(i+1).countryCode)>0){
                    Country tmp = country.get(i);
                    country.set(i,country.get(i+1));
                    country.set(i+1,tmp);
                    //  i++;
                }}
        }
    }
}

