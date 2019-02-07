import java.io.*;


public class Register {
    static BufferedWriter bufferedWriter = null;
    public Register(){

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("data/test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writer(String username,String password) {

        try {
            String str=username+" "+password;
            bufferedWriter.write(str);
            bufferedWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        encryptMd5 cp=new encryptMd5();
        String pass1=cp.encrypByMd5Jar("abases");
        String pass2=cp.encrypByMd5Jar("aback");
        String pass3=cp.encrypByMd5Jar("authentic");
        String pass4=cp.encrypByMd5Jar("abandonment");

        Register register = new Register();
        register.writer("Jane",pass1);
        register.writer("John" ,pass2);
        register.writer("Jerry" ,pass3);
        register.writer("Edward" ,pass4);


        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

