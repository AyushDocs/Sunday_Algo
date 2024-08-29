package Sunday_Algos;

public class PrimMST {
    int findMinIndex(int mst[],int values[]){
        int minIndex=-1,minValue=Integer.MAX_VALUE;

        for(int i=0;i<mst.length;i++)
            if(mst[i]!=0 && values[i]<minValue){
                minValue=values[i];
                minIndex=i;
            }
        return minIndex;
    }
    int[] FindMstUsingPrimAlgo(int graph[][]){
        int n=graph.length;
        int mst[]=new int[n];
        int values[]=new int[n];
        int[] parent=new int[n];
        for(int i=0;i<n;i++)
            values[i]=Integer.MAX_VALUE;
        values[0]=0;
        parent[0]=-1;

        for(int i=0;i<n;i++){
            int minIndex=findMinIndex(mst, values);
            mst[minIndex]=1;
            for(int j=0;j<n;i++){
                if(graph[i][j]!=0 &&graph[i][j]<values[i]){
                    parent[j]=i;
                    values[i]=graph[i][j];
                }
            }
        }
        return mst;
    }
}
