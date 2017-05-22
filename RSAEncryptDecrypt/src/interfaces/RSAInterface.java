package interfaces;

public interface RSAInterface {

    byte[] encrypt(byte[] message);
    byte[] decrypt(byte[] message);
    String bytesToString(byte[] encrypted);

}
