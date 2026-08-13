class Solution {
    class Node{
        char leftchar;
        char rightchar;
        int leftlen;
        int rightlen;
        int maxlen;
        int length;
    Node(){
    }
        Node(char leftchar,char rightchar,int leftlen,int rightlen,int maxlen,int length){
            this.leftchar=leftchar;
            this.rightchar=rightchar;
            this.leftlen=leftlen;
            this.rightlen=rightlen;
            this.maxlen=maxlen;
            this.length=length;
        }
    }
     Node [] tree;
     char[] s;
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.s=s.toCharArray();
        int n=s.length();
        tree=new Node[4*n];
        build(1,0,n-1);
        int k=queryCharacters.length();
        int answer[]=new int[k];
        for(int i=0;i<k;i++){
            int index=queryIndices[i];
            char ch=queryCharacters.charAt(i);
            this.s[index]=ch;
            update(1,0,n-1,index,ch);
            answer[i]=tree[1].maxlen;
        }
    return answer;
    }
    void build(int node,int start,int end){
        if(start==end){
            tree[node]=new Node(s[start],s[start],1,1,1,1);
            return;
        }
        int mid=(start+end)/2;
        build(node*2,start,mid);
        build(node*2+1,mid+1,end);
        tree[node]=merge(tree[node*2],tree[node*2+1]);
    }
    void update(int node,int start,int end,int index,char ch){
        if(start==end){
            tree[node]=new Node(ch,ch,1,1,1,1);
            return;
        }
        int mid=(start+end)/2;
        if(index<=mid){
            update(node*2,start,mid,index,ch);
        }
        else{
            update(node*2+1,mid+1,end,index,ch);
        }
        tree[node]=merge(tree[node*2],tree[node*2+1]);
    }
    Node merge(Node left,Node right){
        Node result=new Node();
        result.length=left.length+right.length;
        result.leftchar=left.leftchar;
        result.rightchar=right.rightchar;
        result.leftlen=left.leftlen;
        result.rightlen=right.rightlen;
        result.maxlen = Math.max(left.maxlen,right.maxlen);
        if(left.rightchar==right.leftchar){
            int combined=left.rightlen+right.leftlen;
             result.maxlen = Math.max(result.maxlen,combined);
             if(left.leftlen==left.length) {
                result.leftlen=left.length+right.leftlen;
            }
            if(right.rightlen==right.length) {
                result.rightlen=right.length+left.rightlen;
            }
        }
    return result;
    }
}