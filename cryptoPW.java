import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class cryptoPW {


    public void cryptoType1() throws IOException {

        InputStreamReader read = null;
        BufferedReader bufferedReader = null;
        try {
            read = new InputStreamReader(new FileInputStream("data/dictionary.txt"), "utf-8");
            bufferedReader = new BufferedReader(read);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String lineTxt = null;
        encryptMd5 cp = new encryptMd5();
        String pass;
        String hashPasswd;
        Map<String, String> passwdMap = new HashMap<>();
        while ((lineTxt = bufferedReader.readLine()) != null) {
            pass = lineTxt;
            hashPasswd = cp.encrypByMd5Jar(pass);
            passwdMap.put(hashPasswd, pass);

        }
        read.close();
        bufferedReader.close();

        InputStreamReader read2 = null;
        BufferedReader bufferedReader2 = null;
        String line = null;
        String originalPass;
        Map<String, String> map = new HashMap<>();
        read2 = new InputStreamReader(new FileInputStream("data/test.txt"), "utf-8");
        bufferedReader2 = new BufferedReader(read2);
        while ((line = bufferedReader2.readLine()) != null) {
            String s[] = line.split(" ");
            map.put(s[0], s[1]);
        }
        read.close();
        bufferedReader.close();

        for(Map.Entry entry : map.entrySet()){
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            if(passwdMap.containsKey(value)){
                System.out.println(key+" "+passwdMap.get(value));
            }
        }
//     return null;
    }




    public static void main(String[] args) {
        cryptoPW crack= new cryptoPW();
        try {
            crack.cryptoType1();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}





