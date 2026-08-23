class Twitter {

    List<int []> recenttweets;
    HashMap<Integer,HashSet<Integer>>follows;
    public Twitter() {
        recenttweets=new ArrayList<>();
        follows=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        recenttweets.add(new int[]{userId,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>feed=new ArrayList<>();
        Set<Integer>userfollows=follows.getOrDefault(userId,new HashSet<>());

        for(int i=recenttweets.size()-1;i>=0;i--){
            int tweet[]=recenttweets.get(i);
            int postedby=tweet[0];
            int tweetId=tweet[1];

            if(userfollows.contains(postedby) || userId==postedby){
                feed.add(tweetId);
            }
            if(feed.size()==10) break;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId,new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)){
            follows.get(followerId).remove(followeeId);
        }
    }
}
