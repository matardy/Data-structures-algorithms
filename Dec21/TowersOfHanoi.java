package Inclass.IB.Dec21;

public class TowersOfHanoi {
    public static void solve(int n, String A, String B, String C){
        if(n==1){
            System.out.println(A + " --> " + C);
        }else{
            solve(n-1, A,C,B);
            System.out.println(A + " --> " + C);
            solve(n-1, B, A, C);
        }
    }
    public static void main(String[] args){
        int numOfDiscs = 3;
        solve(numOfDiscs, "A", "B", "C");
    }
}
