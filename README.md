## 문제점

www.naver.com , www.youtube.com 등 깔끔하게 붙은 사이트들은 잘 가는데,
쿼리 파라미터들이 붙은 사이트는 잘 안가진다. 

## 보충 해야될 점
현재 URL을 단축시키는 패턴을 BASE56 으로 바꿔봐야됨.  
그리고 이거, 컨버터 사용해도 될듯? Spring에 Converter를 등록해서 그냥 바꾸는 식으로해도 될거
같긴 한데...


## 1차 수정 

기존의 MVC Controller를 RestController로 바꾸어 Rest API로 받게 만들었다.

현재 사이트 URL이 잘 가진다. (위의 깔끔한 사이트 뿐 아니라, 뒤에 Path들이 붙은 사이트나,
쿼리 파라미터가 붙은 URL도 잘 가짐)

Spring의 `RedirectView` 클래스 를 이용해서 view로 가게 만들었다.

Dto들을 이용해서 요청을 받게 만들었고, 따로 예외를 만들어 주엇다. API 스펙에
Entity들을 그대로 노출시킬 경우 확장성에 어려움이 있고, 다른 문제들도 생길 수 있음

