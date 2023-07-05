package codechef.START97;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class NoPalindrome {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[100000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int t = reader.nextInt();
        while (t-->0){
            long n = reader.nextInt();
            long k = reader.nextInt();
            StringProvider stringProvider = new StringProvider(n);
            StringBuilder s = stringProvider.getString();
            while (!isValid(s,(int)k)){
             stringProvider.updateString();
             s = stringProvider.getString();
            }
            System.out.println(getSum(s));
        }
    }
    private static boolean isValid(StringBuilder s,int k){
        for(int i=0;i<s.length()-k;i++){
            int start = i, end = i+k;
            while(start<end){
                if(s.charAt(start)==s.charAt(end)){
                    start++;
                    end--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    private static long getSum(StringBuilder s){
        long sum = 0;
        for(int i=0;i<s.length();i++){
            sum += (s.charAt(i) - '0');
        }
        return sum;
    }
}
class StringProvider {
    private StringBuilder s;
    public StringProvider(long n){
        s = new StringBuilder("");
        if(n==1){
            s.append(0);
        }else{
            s.append(1);
            n--;
            while(n>0){
                s.append(0);
                n--;
            }
        }
    }
    public StringBuilder getString(){
        return s;
    }
    public void updateString(){
            int last = s.length()-1;
            int sum = (s.charAt(last) - '0') + 1;
    }
}
