package game.external;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="kakaoTalk", url="${api.url.kakaotalk}", fallback=KakaoTalkServiceFallback.class)
public interface KakaoTalkService {
    @RequestMapping(method= RequestMethod.GET, path="/kakaoTalks")
    public void use(@RequestBody KakaoTalk kakaoTalk);
}
