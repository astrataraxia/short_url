## 문제점

www.naver.com , www.youtube.com 등 깔끔하게 붙은 사이트들은 잘 가는데,
쿼리 파라미터들이 붙은 사이트는 잘 안가진다. 
보니깐 github.com%2Fastrataraxia%2Fshort_url&short=wnWnGU 이런식으로 이스케이프때문에 그런듯?

## 보충 해야될 점
현재 URL을 단축시키는 패턴을 BASE56 으로 바꿔봐야됨.  
그리고 이거, 컨버터 사용해도 될듯? Spring에 Converter를 등록해서 그냥 바꾸는 식으로해도 될거
같긴 한데...
