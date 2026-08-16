class Twitter {

    // follower -> people they follow
    Map<Integer, Set<Integer>> following;

    // user -> their own tweets
    Map<Integer, List<Tweet>> tweets;

    int timestamp;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public void postTweet(int userId, int tweetId) {

        tweets
            .computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> ans = new ArrayList<>();

        // Max heap -> newest tweet first
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        // Add user's own tweets
        List<Tweet> myTweets = tweets.get(userId);

        if (myTweets != null) {
            for (Tweet tweet : myTweets) {
                pq.offer(tweet);
            }
        }

        // Add tweets of people user follows
        Set<Integer> followees = following.get(userId);

        if (followees != null) {

            for (Integer followee : followees) {

                List<Tweet> followeeTweets = tweets.get(followee);

                if (followeeTweets != null) {
                    for (Tweet tweet : followeeTweets) {
                        pq.offer(tweet);
                    }
                }
            }
        }

        // Get latest 10
        while (!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll().tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        Set<Integer> followees = following.get(followerId);

        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}