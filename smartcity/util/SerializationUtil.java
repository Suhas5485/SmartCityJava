package com.smartcity.util;
import java.io.*;


public class SerializationUtil {


public static void serialize(Object obj, String file) {
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
oos.writeObject(obj);
} catch (Exception e) {
e.printStackTrace();
}
}


public static Object deserialize(String file) {
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
return ois.readObject();
} catch (Exception e) {
return null;
}
}
}