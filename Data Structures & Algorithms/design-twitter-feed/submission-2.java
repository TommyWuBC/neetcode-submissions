class Twitter {
    Map<Integer, Set<Integer>> followingMap;
    int timeCounter;
    Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followingMap = new HashMap<>();
        timeCounter = 0;
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> list = new ArrayList<>();
        List<Tweet> tweets = tweetMap.getOrDefault(userId, list);
        Tweet t = new Tweet(tweetId, userId, timeCounter, tweets.size());
        tweets.add(t);
        timeCounter++;
        tweetMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        List<Tweet> def = new ArrayList<>();
        for (int follower: followingMap.getOrDefault(userId, new HashSet<>())) {
            if (follower != userId) {
                List<Tweet> t = tweetMap.getOrDefault(follower, def);
                if (t.size() != 0) {
                    maxheap.add(t.get(t.size()-1));
                }
            }
        }
        List<Tweet> t = tweetMap.getOrDefault(userId, def);
        if (t.size() != 0) {
            maxheap.add(t.get(t.size() -1));
        }
        List<Integer> output = new ArrayList<>();
        while (output.size() < 10 && !maxheap.isEmpty()) {
            Tweet tweet = maxheap.poll();
            if (tweet.index > 0) {
                maxheap.add(tweetMap.get(tweet.userId).get(tweet.index -1));
            }
            output.add(tweet.tweetId);
        }
        return output;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> following = followingMap.getOrDefault(followerId, set);
        following.add(followeeId);
        followingMap.put(followerId, following);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
        }
    }
    private class Tweet {
        int tweetId;
        int userId;
        int time;
        int index;
        public Tweet(int tweetId, int userId, int time, int index) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.time = time;
            this.index = index;
        }
    }
}
