package test;

import java.util.*;

/**
 * Created by rmandada on 27/1/15.
 */
public class ClosestPair {

    public static void main(String[] args) {

        List<Tuple> list = new ArrayList<Tuple>();
        Random rand = new Random();
        for (int i = 0; i <10 ; i++) {
            list.add(new Tuple(rand.nextInt(100),rand.nextInt(100)));
        }

        Collections.sort(list, Tuple.comapreWrtX());
        //int[] result = closestPair(ar,0,n-1);
        for(Tuple t : list){
            System.out.println("X : "+t.getX()+" Y: "+t.getY());
        }
        List<Tuple> result = closestPair(list,0,9);
        System.out.println("Closest pair is: ");
        for(Tuple t: result){
            System.out.println("X : "+t.getX()+" Y: "+t.getY());
        }

    }
    public static List closestPair(List<Tuple> a, int i, int j){
        //Collections.sort(a, Tuple.comapreWrtX());
        if(j-i<3) {
            /*if(j-i == 2){
                if(distance(a.get(0),a.get(1)) <= distance(a.get(0),a.get(2)) &&  distance(a.get(0),a.get(1)) <= distance(a.get(1),a.get(2))){
                    List tmp = new ArrayList();
                    tmp.add(a.get(0));
                    tmp.add(a.get(1));
                    return tmp;
                } else if(distance(a.get(1),a.get(2)) <= distance(a.get(0),a.get(2)) &&  distance(a.get(1),a.get(2)) <= distance(a.get(0),a.get(1))) {
                    List tmp = new ArrayList();
                    tmp.add(a.get(1));
                    tmp.add(a.get(2));
                    return tmp;
                }else {
                    List tmp = new ArrayList();
                    tmp.add(a.get(0));
                    tmp.add(a.get(2));
                    return tmp;
                }
            }
            else if (j-i ==1 ){
                List tmp = new ArrayList();
                tmp.add(a.get(0));
                tmp.add(a.get(1));
                return tmp;
            } else {
                return new ArrayList();
            }*/
            return bruteForce(a,i,j);
        }
        else {
            int mid = (i+j)/2;
            List<Tuple> left = closestPair(a,i,mid);
            List<Tuple> right = closestPair(a,mid+1,j);
           
            double d1, d2, d3;
            d1 = distance(left.get(0),left.get(1));
            d2 = distance(right.get(0), right.get(1));
            List<Tuple> split = closestPairSplit(a,i,j,Math.min(d1,d2));
            if(split.get(0) == null ){
                d3 = Double.MAX_VALUE;
            } else {
                d3 = distance(split.get(0), split.get(1));
            }
            if(d1 <= d2 && d1 <= d3){
                return left;
            } else if (d2 <= d1 && d2 <= d3) {
                return right;
            } else {
                return split;
            }
        }
    }

    public static List closestPairSplit(List<Tuple> a, int left, int right, double d) {
        List<Tuple> S = new ArrayList<Tuple>();
        int mid = (left+right)/2;
        for (int i = left; i <= right ; i++) {
            if(Math.abs(a.get(mid).getX()-a.get(i).getX()) <= d){
                S.add(a.get(i));
            }
        }
        Collections.sort(S,Tuple.comapreWrtY());
        double best = d;
        Tuple t1 = null;
        Tuple t2 = null;
        for (int i = 0; i <S.size()-1 ; i++) {
            for (int j = i+1; j <= Math.min(S.size()-1,i+7) ; j++) {
                if(distance(S.get(i),S.get(j))<best){
                    best = distance(S.get(i),S.get(j));
                    t1 = S.get(i);
                    t2 = S.get(j);
                }
            }
        }
        List tmp = new ArrayList();
        tmp.add(t1);
        tmp.add(t2);
        return tmp;
    }

    public static double distance(Tuple t1, Tuple t2) {
        return Math.sqrt(Math.pow(t1.getX()-t2.getX(),2)+Math.pow(t1.getY()-t2.getY(),2));
    }

    public static List bruteForce(List<Tuple> a, int left, int right){
        double best = Double.MAX_VALUE;
        int k =-1,l = -1;
        for (int i = left; i <=right ; i++) {
            for (int j = i+1; j <=right ; j++) {
                if (distance(a.get(i),a.get(j))<best){
                    best = distance(a.get(i),a.get(j));
                    k = i;
                    l = j;
                }
            }
        }
        List tmp = new ArrayList();
        tmp.add(a.get(k));
        tmp.add(a.get(l));
        return tmp;
    }
}
