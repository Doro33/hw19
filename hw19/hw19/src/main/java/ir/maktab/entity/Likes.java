package ir.maktab.entity;

import ir.maktab.base.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Likes extends BaseEntity<Integer> {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    private LocalDate likedAt;

    public Likes(Tweet tweet, Account account) {
        this.tweet = tweet;
        this.account = account;
        this.likedAt = LocalDate.now();
    }

    public static LikesBuilder builder() {
        return new LikesBuilder();
    }

    public String toString() {
        return "Likes(tweet=" + this.getTweet().getAccount().getUsername()+": "+this.getTweet().getText()
                + ", liked by=" + this.getAccount().getUsername()
                + ", At=" + this.getLikedAt() + ")";
    }

    public static class LikesBuilder {
        private Tweet tweet;
        private Account account;

        LikesBuilder() {
        }

        public LikesBuilder tweet(Tweet tweet) {
            this.tweet = tweet;
            return this;
        }

        public LikesBuilder account(Account account) {
            this.account = account;
            return this;
        }

        public Likes build() {
            return new Likes(tweet, account);
        }
    }
}