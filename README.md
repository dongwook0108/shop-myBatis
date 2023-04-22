# shop-myBatis

-
-
-
---
### 사용 기술 및 개발 환경
- Java11, Spring Boot, Thymeleaf, MyBatis, H2, IntelliJ, Gradle

---
<H3>프로젝트 주요 관심사</H3>

- git-branch 
   > **Git-Flow** 전략
   >
   > 기능별로 브랜치를 나누어 작업하고 feature 브랜치에 대해 pull request를 통한 리뷰 완료 후 Merge를 하고 있습니다.   
   > release, hotfix 브랜치는 향후 작업 수행이 필요하지 않다고 판다 하여 적용하지 않았습니다.
   > - main : 제품으로 출시될 수 있는 브랜치 
   > - develop : 다음 출시 버전을 개발하는 브랜치 
   > - feature : 기능을 개발하는 브랜치    
   > 
   >  참고문헌 <https://sungjk.github.io/2023/02/20/branch-strategy.html/>

- git log prefix 
   > **도메인형 디렉토리** 구조  
   > 사용이유

- code convention 
   > **도메인형 디렉토리** 구조  
   > 사용이유


 + directory
   > **도메인형 디렉토리** 구조  
   > 사용이유
   >  >-계층형보다 도메인형으로 표현했을 경우 훨씬 더 직관적이며 해당 도메인을 이해하는 것에도 효율적     
   > 참고문헌 <https://cheese10yun.github.io/spring-guide-directory//>


---
### 프로젝트 주요 기능
- 사용자
1. 회원가입, 탈퇴 / 로그인, 로그아웃 / 소셜로그인(카카오)
2. 상품페이지 / 주문 / 리뷰
3. 결제   
4. 1:1 문의
5. FAQ(게시글)

- 관리자
1. 회원관리
2. 상품목록관리
3. 판매 내역
4. 1:1문의 관리
5. FAQ 관리(게시글)



