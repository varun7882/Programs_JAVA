package codechef.LongJUNE2020;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Point2D implements Comparable<Point2D>
{
    public static final Comparator<Point2D> X_ORDER = new XOrder();
    public static final Comparator<Point2D> Y_ORDER = new YOrder();
    public static final Comparator<Point2D> R_ORDER = new ROrder();
    public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
    public final Comparator<Point2D> ATAN2_ORDER = new Atan2Order();
    public final Comparator<Point2D> DISTANCE_TO_ORDER = new DistanceToOrder();

    private final double x; // x coordinate
    private final double y; // y coordinate

    public Point2D(double x, double y)
    {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0)
            x = 0.0; // convert -0.0 to +0.0
        if (y == 0.0)
            y = 0.0; // convert -0.0 to +0.0
        this.x = x;
        this.y = y;
    }

    public double x()
    {
        return x;
    }

    public double y()
    {
        return y;
    }

    public double r()
    {
        return Math.sqrt(x * x + y * y);
    }

    public double theta()
    {
        return Math.atan2(y, x);
    }

    private double angleTo(Point2D that)
    {
        double dx = that.x - this.x;
        double dy = that.y - this.y;
        return Math.atan2(dy, dx);
    }

    public static int ccw(Point2D a, Point2D b, Point2D c)
    {
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area2 < 0)
            return -1;
        else if (area2 > 0)
            return +1;
        else
            return 0;
    }

    public static double area2(Point2D a, Point2D b, Point2D c)
    {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public double distanceTo(Point2D that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distanceSquaredTo(Point2D that)
    {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return dx * dx + dy * dy;
    }

    public int compareTo(Point2D that)
    {
        if (this.y < that.y)
            return -1;
        if (this.y > that.y)
            return +1;
        if (this.x < that.x)
            return -1;
        if (this.x > that.x)
            return +1;
        return 0;
    }

    private static class XOrder implements Comparator<Point2D>
    {
        public int compare(Point2D p, Point2D q)
        {
            if (p.x < q.x)
                return -1;
            if (p.x > q.x)
                return +1;
            return 0;
        }
    }

    private static class YOrder implements Comparator<Point2D>
    {
        public int compare(Point2D p, Point2D q)
        {
            if (p.y < q.y)
                return -1;
            if (p.y > q.y)
                return +1;
            return 0;
        }
    }

    private static class ROrder implements Comparator<Point2D>
    {
        public int compare(Point2D p, Point2D q)
        {
            double delta = (p.x * p.x + p.y * p.y) - (q.x * q.x + q.y * q.y);
            if (delta < 0)
                return -1;
            if (delta > 0)
                return +1;
            return 0;
        }
    }

    private class Atan2Order implements Comparator<Point2D>
    {
        public int compare(Point2D q1, Point2D q2)
        {
            double angle1 = angleTo(q1);
            double angle2 = angleTo(q2);
            if (angle1 < angle2)
                return -1;
            else if (angle1 > angle2)
                return +1;
            else
                return 0;
        }
    }

    private class PolarOrder implements Comparator<Point2D>
    {
        public int compare(Point2D q1, Point2D q2)
        {
            double dx1 = q1.x - x;
            double dy1 = q1.y - y;
            double dx2 = q2.x - x;
            double dy2 = q2.y - y;

            if (dy1 >= 0 && dy2 < 0)
                return -1; // q1 above; q2 below
            else if (dy2 >= 0 && dy1 < 0)
                return +1; // q1 below; q2 above
            else if (dy1 == 0 && dy2 == 0)
            { // 3-collinear and horizontal
                if (dx1 >= 0 && dx2 < 0)
                    return -1;
                else if (dx2 >= 0 && dx1 < 0)
                    return +1;
                else
                    return 0;
            } else
                return -ccw(Point2D.this, q1, q2); // both above or below
        }
    }

    private class DistanceToOrder implements Comparator<Point2D>
    {
        public int compare(Point2D p, Point2D q)
        {
            double dist1 = distanceSquaredTo(p);
            double dist2 = distanceSquaredTo(q);
            if (dist1 < dist2)
                return -1;
            else if (dist1 > dist2)
                return +1;
            else
                return 0;
        }
    }

    public boolean equals(Object other)
    {
        if (other == this)
            return true;
        if (other == null)
            return false;
        if (other.getClass() != this.getClass())
            return false;
        Point2D that = (Point2D) other;
        return this.x == that.x && this.y == that.y;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    public int hashCode()
    {
        int hashX = ((Double) x).hashCode();
        int hashY = ((Double) y).hashCode();
        return 31 * hashX + hashY;
    }

}
class GrahamScan
{
    public Stack<Point2D> hull = new Stack<Point2D>();
    public List<Point2D> colinearPoints = new ArrayList<>();

    public GrahamScan(HashSet<Point2D> pts)
    {


        int N = pts.size();
        Point2D[] points = new Point2D[N];
        int ii =0;
        for(Point2D p: pts){
            points[ii++] = new Point2D(p.x(), p.y());
        }

        Arrays.sort(points);

        Arrays.sort(points, 1, N, points[0].POLAR_ORDER);

        hull.push(points[0]); // p[0] is first extreme point
        int k1;
        for (k1 = 1; k1 < N; k1++)
            if (!points[0].equals(points[k1]))
                break;
        if (k1 == N)
            return; // all points equal

        int k2;
        for (k2 = k1 + 1; k2 < N; k2++)
            if (Point2D.ccw(points[0], points[k1], points[k2]) != 0)
                break;
            else{
                colinearPoints.add(points[k2-1]);
            }
        hull.push(points[k2 - 1]); // points[k2-1] is second extreme point

        for (int i = k2; i < N; i++)
        {
            Point2D top = hull.pop();
            while (Point2D.ccw(hull.peek(), top, points[i]) <= 0)
            {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }

        assert isConvex();
    }

    public Iterable<Point2D> hull()
    {
        Stack<Point2D> s = new Stack<Point2D>();
        for (Point2D p : hull)
            s.push(p);
        return s;
    }

    public Polygon getPolygon(){
        int size = hull.size();
        if(size<=2)return null;
        Point2D[] vers = new Point2D[size];
        int i=0;
        for(Point2D p: hull){
            vers[i++]= new Point2D(p.x(),p.y());
        }
        Polygon polygon = new Polygon(vers);
        return polygon;
    }
    private boolean isConvex()
    {
        int N = hull.size();
        if (N <= 2)
            return true;

        Point2D[] points = new Point2D[N];
        int n = 0;
        for (Point2D p : hull())
        {
            points[n++] = p;
        }

        for (int i = 0; i < N; i++)
        {
            if (Point2D
                    .ccw(points[i], points[(i + 1) % N], points[(i + 2) % N]) <= 0)
            {
                return false;
            }
        }
        return true;
    }

}

class Polygon{
    private Point2D[] vertices;
    private int size;
    Polygon(Point2D []list){
        vertices = list;
        size = list.length;
    }

    public Point2D[] getVertices() {
        return vertices;
    }

    public long getSize() {
        return size;
    }

    public boolean contains(Point2D test) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = vertices.length - 1; i < vertices.length; j = i++) {
            if(vertices[i].equals(test) || vertices[j].equals(test)){
                return false;
            }
            if(orientation(vertices[i],test,vertices[j])==0 && onSegment(vertices[i],test,vertices[j])){
                return false;
            }
            if ((vertices[i].y() > test.y()) != (vertices[j].y() > test.y()) &&
                    (test.x() < (vertices[j].x() - vertices[i].x()) * (test.y() - vertices[i].y()) / (vertices[j].y()-vertices[i].y()) + vertices[i].x())) {
                result = !result;
            }
        }
        return result ;
    }

    private boolean onSegment(Point2D p, Point2D q, Point2D r)
    {
        if (q.x() <= Math.max(p.x(), r.x()) &&
                q.x() >= Math.min(p.x(), r.x()) &&
                q.y() <= Math.max(p.y(), r.y()) &&
                q.y() >= Math.min(p.y(), r.y()))
        {
            return true;
        }
        return false;
    }

    // To find orientation of ordered triplet (p, q, r).
    // The function returns following values
    // 0 --> p, q and r are colinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    public static int orientation(Point2D p, Point2D q, Point2D r)
    {
        double val = (q.y() - p.y()) * (r.x() - q.x())
                - (q.x() - p.x()) * (r.y() - q.y());

        if (val == 0)
        {
            return 0; // colinear
        }
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    // The function that returns true if
    // line segment 'p1q1' and 'p2q2' intersect.
    private boolean doIntersect(Point2D p1, Point2D q1,
                                Point2D p2, Point2D q2)
    {
        // Find the four orientations needed for
        // general and special cases
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4)
        {
            return true;
        }

        // Special Cases
        // p1, q1 and p2 are colinear and
        // p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1))
        {
            return true;
        }

        // p1, q1 and p2 are colinear and
        // q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1))
        {
            return true;
        }

        // p2, q2 and p1 are colinear and
        // p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2))
        {
            return true;
        }

        // p2, q2 and q1 are colinear and
        // q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2))
        {
            return true;
        }

        // Doesn't fall in any of the above cases
        return false;
    }


    boolean isStriclyInside(Point2D p){
        int n = size, windingNumber = 0;
        for (int i = 0; i < n; ++i) {
            if (vertices[i].equals(p)) return false;
            int j = (i + 1)%n;
            if (vertices[i].y() == p.y() && vertices[j].y() == p.y()) {
                if (Math.min(vertices[i].x(), vertices[j].x()) <= p.x() &&
                        p.x() <= Math.max(vertices[i].x(), vertices[j].x())) return false;
            } else {
                boolean below = vertices[i].y() < p.y();

                if (below != (vertices[j].y() < p.y())) {
                    int orientation = Point2D.ccw(p, vertices[j], vertices[i]);
                    if (orientation == 0) return false;
                    if (below == (orientation > 0)){
                        windingNumber += (below ? 1 : -1);
                    }
                }
            }
        }
        return windingNumber != 0;
    }

    public boolean isInside(Point2D point){
        ArrayList<Double> A = new ArrayList<>();
        ArrayList<Double> B = new ArrayList<>();
        ArrayList<Double> C = new ArrayList<>();
        ArrayList<Double> D = new ArrayList<>();
        for(int i=0;i<size;i++){
            int j = (i+1)%size;
            Point2D p1 = vertices[i];
            Point2D p2 = vertices[j];
            double a = -(p2.y() - p1.y());
            double b = p2.x() - p1.x();
            double c = -(a * p1.x() + b * p1.y());
            A.add(a);
            B.add(b);
            C.add(c);
        }
        for(int i=0;i<size;i++){
            double d = A.get(i) * point.x() + B.get(i) * point.y() + C.get(i);
            D.add(d);
        }
        boolean t1= true,t2=true;
        for(Double d: D){
            if(d<0){
                t1 = false;
            }
            if(d>0){
                t2 = false;
            }
        }
        return t1 || t2;
    }
}
class CONTAIN {
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
            byte[] buf = new byte[64]; // line length
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

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int t = reader.nextInt();
        while (t-- > 0) {
            int n, q;
            n = reader.nextInt();
            q = reader.nextInt();
            Point2D points[] = new Point2D[n];
            HashSet<Point2D> hs = new HashSet<>();
            for (int i = 0; i < n; i++) {
                long x, y;
                x = reader.nextLong();
                y = reader.nextLong();
                points[i] = new Point2D(x, y);
                hs.add(points[i]);
            }
            ArrayList<Polygon> listPoly = new ArrayList<>();
            while (true){
                if(hs.size()==0)break;
                GrahamScan grahamScan = new GrahamScan(hs);
                int size = grahamScan.hull.size();
                if(size<=2){
                    break;
                }
                Point2D[] tmpPoints = new Point2D[size];
                int i = 0;
                for(Point2D p: grahamScan.hull){
                    tmpPoints[i++] = new Point2D(p.x(), p.y());
                    hs.remove(p);
                }
                for(Point2D p: grahamScan.colinearPoints){
                    hs.remove(p);
                }
                Polygon poly = new Polygon(tmpPoints);
                listPoly.add(poly);
            }
            //System.out.println("ho hey"+listPoly.size());
            while (q-->0){
                long x, y;
                x = reader.nextLong();
                y = reader.nextLong();
                Point2D p = new Point2D(x,y);
                System.out.println(getDeliciousness(listPoly,p));
            }

        }
    }

    private static int getDeliciousness(ArrayList<Polygon> listPoly, Point2D p) {
        if(listPoly.size()==0)return 0;
        int low=0,high = listPoly.size()-1,mid,ans=-1;
        int end = listPoly.size()-1;
        if(!listPoly.get(low).isInside(p)){
           return 0;
        }

        while (low <= high){
            mid = (low + high)/2;
            if(listPoly.get(mid).isInside(p)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return  ans+1;
    }

    private static int getDeliciousnessLinear(ArrayList<Polygon> listPoly, Point2D p) {
        if(listPoly.size()==0)return 0;
        int i=listPoly.size()-1;
        for(i=listPoly.size()-1;i>=0;i--){
            if(listPoly.get(i).isStriclyInside(p)){
                return i + 1;
            }
        }
        return  0;
    }

}


