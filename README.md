# baeppo_server

# git flow
## 코드리뷰 방법
1. 하위작업(feature)가 완료되면, 상위작업(release)으로 PR 한다.
2. develop으로 merge되는 시점은 상위작업(release)가 끝날때 한다.

예)  
feature/search_room -> release/search  
feature/search_review -> release/search  
feature/search_address -> release/search  
release/search -> develop  
