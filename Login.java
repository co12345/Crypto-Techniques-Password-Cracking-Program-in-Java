import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Login {

    public static boolean Auth(String name,String passwd) throws IOException {
        Map <String, String> map = new HashMap<>();
        InputStreamReader read = null;
        BufferedReader bufferedReader = null;
        try {
            read = new InputStreamReader(new FileInputStream("data/test.txt"), "utf-8");
            bufferedReader = new BufferedReader(read);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp = null;
        while ((temp = bufferedReader.readLine()) != null){
            String s[] = temp.split(" ");
            map.put(s[0], s[1]);
        }
        bufferedReader.close();
        read.close();
        encryptMd5 cp=new encryptMd5();
        String pass=cp.encrypByMd5Jar(passwd);
        boolean flag;
        flag= (map.containsKey(name) && map.get(name).equals(pass));

        return flag;
    }


    public void isLogin(String username,String password){
        try {
            if(Auth(username,password)){
                System.out.println(username+" Client logged in successfully");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Login auth= new Login();
        auth.isLogin("Jane","abases");
    }
}

