package codechef.LongJUNE2020;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TTUPLE2 {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
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

        public double nextDouble() throws IOException
        {
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

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws Exception {

        Reader reader = new Reader();
        int t = reader.nextInt();
        while (t-->0){
            long p, q, r, a, b, c;
            p = reader.nextLong();
            q = reader.nextLong();
            r = reader.nextLong();
            a = reader.nextLong();
            b = reader.nextLong();
            c = reader.nextLong();


            long d1, d2, d3;
            d1 = a - p;
            d2 = b - q;
            d3 = c - r;


            long m1 = 10000000001L, m2 = 10000000002L, m3 = 10000000003L;
            if(p != 0 && a % p == 0){
                m1 = a / p;
            }
            if(q != 0 && b % q == 0){
                m2 = b / q;
            }
            if(r != 0 && c % r == 0){
                m3 = c / r;
            }

            if(p==a && q==b && r==c){
                System.out.println("0");
            }else if((p==a && q==b) || (q==b && r==c) || (p==a && r==c)){
                System.out.println("1");
            }else if(p==a){
                if(d2==d3 || m2==m3){
                    System.out.println("1");
                }else{
                    System.out.println("2");
                }
            }else if(q==b){
                if(d1==d3 || m1==m3){
                    System.out.println("1");
                }else{
                    System.out.println("2");
                }
            }else if(r==c){
                if(d1==d2 || m1==m2){
                    System.out.println("1");
                }else{
                    System.out.println("2");
                }
            }else{
                if(d1==d2 && d2==d3){
                    System.out.println("1");
                    continue;
                }else if(d1==d2 || d2==d3 || d1==d3){
                    System.out.println("2");
                    continue;

                }else if(d1==d2+d3 || d2==d1+d3 || d3==d1+d2){
                    System.out.println("2");
                    continue;
                }
                if(m1==m2 && m2==m3){
                    System.out.println("1");
                    continue;
                }else if(m1==m2 || m2==m3 || m1==m3){
                    System.out.println("2");
                    continue;
                }else if(m1 == m2*m3 || m2 == m3*m1 || m3 == m1*m2){
                    System.out.println("2");
                    continue;
                }

                long d, m;
                if(p-q!=0) {
                    m = (a - b) / (p - q);
                    if (m * (p - q) == (a - b)) {
                        d = a - (p * m);
                        if (((r * m) + d) == c || r*m ==c || r + d == c ) {
                            System.out.println("2");
                            continue;
                        }
                    }
                }
                if(q-r!=0) {
                    m = (b - c) / (q - r);
                    if (m * (q - r) == (b - c)) {
                        d = b - (q * m);
                        if (((p * m) + d) == a || p*m ==a || p + d == a ) {
                            System.out.println("2");
                            continue;
                        }
                    }
                }
                if(r-p!=0) {
                    m = (c - a) / (r - p);
                    if (m * (r - p) == (c - a)) {
                        d = c - (r * m);
                        if (((q * m) + d) == b || q*m ==b || q + d == b ) {
                            System.out.println("2");
                            continue;
                        }
                    }
                }
                System.out.println("3");
            }
        }
    }
}
