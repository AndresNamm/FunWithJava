import java.util.ArrayList;
public class Main {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int i = A.size()-1;
        while(i>=0){
            int tempR = A.get(i)+1;
            if(tempR>=10) {
                A.set(i,0);
            }else{
                A.set(i,tempR);
                break;
            }
            i--;
        }
        if(i==-1){
            A.add(0,1);
        }else {
            int num =0;// DONT REUSE VARIABLES https://softwareengineering.stackexchange.com/questions/115520/should-i-reuse-variables
            for(num=0;num<A.size();num++){
                if(A.get(num)!=0){
                    break;
                };
            }A = new ArrayList<>( A.subList(num,A.size()));
            //https://beginnersbook.com/2013/12/how-to-get-sublist-of-an-arraylist-with-example/
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
