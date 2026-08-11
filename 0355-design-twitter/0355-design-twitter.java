class Twitter {
 HashMap<Integer,List<int[]>> tweets;
 HashMap<Integer,HashSet<Integer>> following;
 int time;
    public Twitter() {
        tweets=new HashMap<>();
        following=new HashMap<>();
        time=0;
    }
    public void postTweet(int userId, int tweetId) {
     if(!tweets.containsKey(userId)){
        tweets.put(userId,new ArrayList<>());
     }   
     tweets.get(userId).add(new int[]{time,tweetId});
     time++;
    }
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)->b[0]-a[0]);
        List <Integer> users=new ArrayList<>();
        users.add(userId);
        if(following.containsKey(userId)){
            users.addAll(following.get(userId));
        }
        for(int user:users){
            if(!tweets.containsKey(user)){
                continue;
            }
            List <int[]> list=tweets.get(user);
            int index=list.size()-1;
            if(index>=0){
                int tweet[]=list.get(index);
                maxHeap.offer(new int[]{tweet[0],tweet[1],user,index});
            }
        }
        List<Integer> result=new ArrayList<>();
        while(!maxHeap.isEmpty() && result.size()<10){
            int current[]=maxHeap.poll();
            result.add(current[1]);
            int user=current[2];
            int index=current[3]-1;
            if(index>=0){
                int[] tweet=tweets.get(user).get(index);
                maxHeap.offer(new int[]{tweet[0],tweet[1],user,index});
            }
        }
        return result;
    }
    public void follow(int followerId, int followeeId) {
            if(!following.containsKey(followerId)) {
            following.put(followerId,new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */