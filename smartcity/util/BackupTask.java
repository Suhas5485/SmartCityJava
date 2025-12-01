package com.smartcity.util;
import java.io.*;


public class BackupTask extends Thread {


@Override
public void run() {
while (true) {
try {
Thread.sleep(10000);
copy("users.ser", "users_backup.ser");
copy("requests.ser", "requests_backup.ser");
System.out.println("[AUTO BACKUP COMPLETED]");
} catch (Exception e) {
e.printStackTrace();
}
}
}


private void copy(String src, String dest) throws IOException {
FileInputStream fis = new FileInputStream(src);
FileOutputStream fos = new FileOutputStream(dest);
fos.write(fis.readAllBytes());
fis.close(); fos.close();
}
}