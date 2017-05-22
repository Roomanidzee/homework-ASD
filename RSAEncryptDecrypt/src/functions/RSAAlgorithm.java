package functions;

import interfaces.RSAInterface;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RSAAlgorithm implements RSAInterface {

    private BigInteger p;//используем два больших простых числа
    private BigInteger q;//первое число - p, второе - q
    private BigInteger n;//результат умножения р на q
    private BigInteger phiNum;//взаимно простое число с результатом (p - 1) * (q - 1)
    private BigInteger e;//проверка получения единицы при делении на phiNum и умножении на d
    private BigInteger d;//случайное взаимно простое число
    private int bitLength = 1024;

    //e и n - открытый ключ, d и n - закрытый ключ

    private Random r = new Random();

    public RSAAlgorithm(){

        this.p = BigInteger.probablePrime(this.bitLength, this.r);
        this.q = BigInteger.probablePrime(this.bitLength, this.r);

        this.n = this.p.multiply(this.q);

        this.phiNum = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));

        this.e = BigInteger.probablePrime(bitLength / 2, this.r);

        while(this.phiNum.gcd(e).compareTo(BigInteger.ONE) > 0 && this.e.compareTo(this.phiNum) < 0){

            this.e.add(BigInteger.ONE);

        }

        this.d = this.e.modInverse(this.phiNum);

    }

    public RSAAlgorithm(BigInteger newE, BigInteger newD, BigInteger newN){

        this.e = newE;
        this.d = newD;
        this.n = newN;

    }

    @Override
    public byte[] encrypt(byte[] message) {

        BigInteger result = new BigInteger(message);

        return result.modPow(e, n).toByteArray();

    }

    @Override
    public byte[] decrypt(byte[] message) {

        BigInteger result = new BigInteger(message);

        return result.modPow(d, n).toByteArray();
    }

    @Override
    public String bytesToString(byte[] encrypted) {

        String result = new String(encrypted, StandardCharsets.UTF_8);

        return result;

    }
}
