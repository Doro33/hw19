package ir.maktab.entity;

import ir.maktab.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follow extends BaseEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "following_id")
    private Account following;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private Account follower;

    private LocalDate followedAt;

    private boolean inCircle;

    public Follow(Account following, Account follower, boolean inCircle) {
        this.following = following;
        this.follower = follower;
        this.followedAt = LocalDate.now();
        this.inCircle = inCircle;
    }

    public static FollowBuilder builder() {
        return new FollowBuilder();
    }

    public String toString() {
        return "Follow(following=" + this.getFollowing().getUsername()
                + ", follower=" + this.getFollower().getUsername()
                + ", followedAt=" + this.getFollowedAt()
                + ", inCircle=" + this.isInCircle() + ")";
    }

    public static class FollowBuilder {
        private Account following;
        private Account follower;
        private boolean inCircle;

        FollowBuilder() {
        }

        public FollowBuilder following(Account following) {
            this.following = following;
            return this;
        }

        public FollowBuilder follower(Account follower) {
            this.follower = follower;
            return this;
        }


        public FollowBuilder inCircle(boolean inCircle) {
            this.inCircle = inCircle;
            return this;
        }

        public Follow build() {
            return new Follow(following, follower, inCircle);
        }
    }
}
