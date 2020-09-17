package game;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Gift_table")
public class Gift {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long rewardId;
    private Long walletId;
    private String status;

    @PostPersist
    public void onPostPersist(){
//        Used used = new Used();
//        BeanUtils.copyProperties(this, used);
//        used.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        game.external.KakaoTalk kakaoTalk = new game.external.KakaoTalk();
        // mappings goes here
        kakaoTalk.setId(this.getId());
        kakaoTalk.setStatus("send message!!!!");
        GiftApplication.applicationContext.getBean(game.external.KakaoTalkService.class)
                .use(kakaoTalk);


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }
    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
