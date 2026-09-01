class Solution{
    public int minMoves(String[] classroom,int energy){
        int m=classroom.length,n=classroom[0].length();
        int[][] id=new int[m][n];
        int startX=0,startY=0,count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c=classroom[i].charAt(j);
                if(c=='S'){
                    startX=i;
                    startY=j;
                }else if(c=='L'){
                    id[i][j]=count++;
                }
            }
        }
        if(count==0)return 0;
        boolean[][][][] visited=new boolean[m][n][energy+1][1<<count];
        int startMask=(1<<count)-1;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{startX,startY,energy,startMask});
        visited[startX][startY][energy][startMask]=true;
        int[] dirs={-1,0,1,0,-1};
        int moves=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int s=0;s<size;s++){
                int[] curr=queue.poll();
                int x=curr[0],y=curr[1],curEnergy=curr[2],mask=curr[3];
                if(mask==0)return moves;
                if(curEnergy==0)continue;
                for(int k=0;k<4;k++){
                    int nx=x+dirs[k],ny=y+dirs[k+1];
                    if(nx<0||nx>=m||ny<0||ny>=n)continue;
                    if(classroom[nx].charAt(ny)=='X')continue;
                    int nextEnergy;
                    if(classroom[nx].charAt(ny)=='R')nextEnergy=energy;
                    else nextEnergy=curEnergy-1;
                    int nextMask=mask;
                    if(classroom[nx].charAt(ny)=='L'){
                        nextMask&=~(1<<id[nx][ny]);
                    }
                    if(!visited[nx][ny][nextEnergy][nextMask]){
                        visited[nx][ny][nextEnergy][nextMask]=true;
                        queue.offer(new int[]{nx,ny,nextEnergy,nextMask});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}