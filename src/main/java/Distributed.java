/*
import mpi.*;

public class Distributed {

    public static int N=11;

    public static int dest;

    public static int tag = 101;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MPI.Init(args);


        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        if(rank==0) {

            dest=1;

            int flag2 = 0;

            int rnd[] = new int[1];

            int total = 0;


            long startTime = System.currentTimeMillis();
            printMatrices(N,null,0);

            while(flag2 < MPI.COMM_WORLD.Size()-1) {

                if(MPI.COMM_WORLD.Iprobe(MPI.ANY_SOURCE, 101)!=null) {

                    MPI.COMM_WORLD.Recv(rnd,0,1,MPI.INT,MPI.ANY_SOURCE,tag);

                    total+=rnd[0];
                    flag2++;
                }

            }

            long endTime=System.currentTimeMillis();

            System.out.println("Total solutions: " + total);

            System.out.println("Time cost: " + (endTime - startTime) + "ms");


        }

        else {

            int numb = 0;

            int flag = 0;

            dest=0;

            int multi[][]=new int[N][N];

            while(flag < (factorial(N)/(size-1))) {

                if(MPI.COMM_WORLD.Iprobe(0, 101)!=null) {

                    MPI.COMM_WORLD.Recv(multi,0,multi.length,MPI.OBJECT,dest,tag);

                    boolean bol=true;

                    for(int k=0; k < multi.length; k++) {

                        for(int j=0; j < multi.length;j++) {

                            if(multi[k][j]==1) {

                                if(!isSafe(multi,k,j)) {

                                    bol=false;

                                }

                            }

                        }
                    }

                    if(bol) {

                        numb++;

                        System.out.println("Solution:");

                        for(int k=0; k < multi.length; k++) {

                            for(int j=0; j < multi.length;j++) {

                                System.out.print(multi[k][j]);

                            }
                            System.out.println();
                        }


                    }

                    flag++;

                }


            }

            int numb2[]=new int[1];
            numb2[0] = numb;

            MPI.COMM_WORLD.Send(numb2, 0, numb2.length, MPI.INT, 0, tag);

        }

        MPI.Finalize();
    }

    private static int factorial(int n2) {
        // TODO Auto-generated method stub
        if(n2==0) {
            return 1;
        }
        else {
            return n2*factorial(n2-1);
        }
    }

    private static void printMatrices(int n, int[] sequence, int currentIndex)
    {
        if(currentIndex==0){
            sequence=new int[n];
            for(int i=0;i<n;i++)
                sequence[i]=i;
        }

        */
/*the function is recursive function ,
         * and this if is checking if the end of recursion is reached or not
         * *//*


        if (currentIndex == sequence.length - 1) {

            int c[][]=new int[N][N];
            //System.out.println();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(sequence[i]==j) {
                        c[i][j]=1;
                        //System.out.print(1+" ");
                    }
                    else {
                        c[i][j]=0;
                        //System.out.print(0+" ");
                    }
                }
                //System.out.println();
            }

            if(dest > MPI.COMM_WORLD.Size()-1) {
                dest=1;
            }
            MPI.COMM_WORLD.Send(c, 0, c.length, MPI.OBJECT, dest, tag);

            dest++;


        }

        for (int i = currentIndex; i < sequence.length; i++)
        {
            int temp=sequence[currentIndex];
            sequence[currentIndex]=sequence[i];
            sequence[i]=temp;
            printMatrices(n,sequence, currentIndex + 1);
            temp=sequence[currentIndex];
            sequence[currentIndex]=sequence[i];
            sequence[i]=temp;
        }
    }

    private static boolean isSafe(int mat[][], int r, int c)
    {

        int i,j;


        for(i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--) {
            if( mat[i][j] == 1) {
                return false;
            }

        }

        for(i = r+1, j = c+1; i < mat.length && j < mat.length; i++, j++) {
            if( mat[i][j] == 1) {
                return false;
            }

        }

        for(i = r+1, j = c-1; i < mat.length && j >= 0; i++, j--) {
            if( mat[i][j] == 1) {
                return false;
            }

        }

        for(i = r-1, j = c+1; j < mat.length && i >= 0; i--, j++) {
            if( mat[i][j] == 1) {
                return false;
            }

        }

        return true;
    }

}
*/
