## 문제점

www.naver.com , www.youtube.com 등 깔끔하게 붙은 사이트들은 잘 가는데,
쿼리 파라미터들이 붙은 사이트는 잘 안가진다. why??

## 보충 해야될 점
현재 URL을 단축시키는 패턴을 다른 방식으로 바꾸는걸 생각해보자.

## 수정 

기존의 MVC Controller를 RestController로 바꾸어 Rest API로 받게 만들었다.

현재 사이트 URL이 잘 가진다. (위의 깔끔한 사이트 뿐 아니라, 뒤에 Path들이 붙은 사이트나, 쿼리 파라미터가 붙은 URL도 잘 가짐)
기존에는 그냥 String의 "redirect:{uri}"를 통해 가져갔다 이번에는 RedirectView 라는 클래스를 리턴 타입으로 받았다. 

Dto들을 이용해서 요청을 받게 만들었고, 따로 예외를 만들어 주었다. API 스펙에 Entity들을 그대로 노출시킬 경우 확장성에 어려움이 있고, 다른 문제들도 생길 수 있음.

Exception을 반환할때, Rest 형식의 반환 클래스를 만들어 Exception을 그 형식에 맞추어 반환하게 만들어 주었다. (오류 메시지 파악의 쉬움)


