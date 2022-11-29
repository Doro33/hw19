package ir.maktab.entity;

import ir.maktab.base.entity.BaseEntity;
import ir.maktab.utils.AppContext;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tweet extends BaseEntity<Integer> {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne
    private Tweet tweet;
    @Column(length = 280)
    private String text;
    private LocalDate createAt;


    public Tweet(Account account, String text,Tweet tweet) {
        this.account = account;
        this.text = text;
        this.tweet = tweet;
        this.createAt = LocalDate.now();
    }

    public static TweetBuilder builder() {
        return new TweetBuilder();
    }

    public String toString() {
        //todo count likes and comment at tweet service
        if (this.tweet==null) {
            return "Tweet(account=" + this.getAccount().getUsername()
                    + ", text=" + this.getText()
                    + ", createAt=" + this.getCreateAt()
                    + ", likes=" + 0
                    + ", comments=" + 0 + ")";
        }else {
            return "Comment(tweet=" + this.getTweet().getAccount().getUsername() +": "+this.getTweet().getText()
                    +", account=" + this.getAccount().getUsername()
                    + ", comment=" + this.getText()
                    + ", createAt=" + this.getCreateAt()
                    + ", likes=" + AppContext.getLIKES_SER().countATweetLikes(this)
                    + ", comments=" +0 + ")";
        }
    }

    public static class TweetBuilder {
        private Account account;
        private String text;

        private Tweet tweet;
        TweetBuilder() {
        }

        public TweetBuilder account(Account account) {
            this.account = account;
            return this;
        }

        public TweetBuilder text(String text) {
            this.text = text;
            return this;
        }

        public TweetBuilder tweet(Tweet tweet){
            this.tweet = tweet;
            return this;
        }

        public Tweet build() {
            return new Tweet(account, text,tweet);
        }
    }
}