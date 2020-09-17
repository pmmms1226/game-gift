package game.external;

import org.springframework.stereotype.Component;

@Component
public class KakaoTalkServiceFallback implements KakaoTalkService{
    @Override
    public void use(KakaoTalk kakaoTalk) {
        System.out.println("Circuit breaker has been opened. Fallback returned instead.");
    }
}
