# shop-myBatis

- 전반적인 웹의 기본 소양이 되는 CRUD 게시판, 회원가입, spring security를 통한 login/out 기능
- 관리자 페이지에서도 회원과, 상품을 관리할 수 있는 쇼핑몰 기능을 구현 
- 단순한 기능만을 구현하는 것을 넘어 확장 가능하고 지속적인 코드 리뷰를 통해 불필요한 코드를 줄이는 뿐만 아니라 코드가 사용되는 본질적인 이유와 사용성이 더 좋은 코드를 작성하기 위해 노력했습니다.
---
### 사용 기술 및 개발 환경
- Java11, Spring Boot, Thymeleaf, MyBatis, H2, IntelliJ, Gradle

---
<H3>프로젝트 주요 관심사</H3>

- git-branch 
   > **Git-Flow** 전략
   > ![git-flow](https://user-images.githubusercontent.com/121872570/233758368-c1e1b7d2-6dba-4339-9e56-a2e22c919bea.png)
   >
   > 기능별로 브랜치를 나누어 작업하고 feature 브랜치에 대해 pull request를 통한 리뷰 완료 후 Merge를 하고 있습니다.   
   > release, hotfix 브랜치는 향후 작업 수행이 필요하지 않다고 판단 하여 적용하지 않았습니다.
   > - main : 제품으로 출시될 수 있는 브랜치 
   > - develop : 다음 출시 버전을 개발하는 브랜치 
   > - feature : 기능을 개발하는 브랜치    
   > 
   >  참고문헌 <https://sungjk.github.io/2023/02/20/branch-strategy.html/>

- git log prefix 
  >  - chore: 패키지 매니저 설정할 경우, 코드 수정 없이 설정을 변경            
  >  - docs: documentation 변경             
  >  - feat: 새로운 기능                      
  >  - fix: 버그 수정           
  >  - refactor: 버그를 수정하거나 기능을 추가하지 않는 코드 변경, 리팩토링              
  >  - style: 코드 의미에 영향을 주지 않는 변경사항               
  >  - test: 누락된 테스트 추가 또는 기존 테스트 수정            
  >  - revert: 작업 되돌리기  
  >
  >  참고문헌 <http://karma-runner.github.io/0.10/dev/git-commit-msg.html/>

- code convention 
   > **구글의 코딩 컨벤션** 사용    
   > 코드 규약은 소프트웨어의 가독성을 향상시켜 엔지니어가 새로운 코드를 더 빠르고 철저하게 이해할 수 있도록 합니다.  
   > 
   >  참고문헌 <https://www.oracle.com/java/technologies/javase/codeconventions-introduction.html/>


 + directory
   > **도메인형 디렉토리** 구조  
   > 사용이유
   >  > 계층형보다 도메인형으로 표현했을 경우 훨씬 더 직관적이며 해당 도메인을 이해하는 것에도 효율적입니다.   
   >  > "High cohesion" , "Loosly coupling"으로 각각의 도메인은 서로 철저히 분리되고,   
          높은 응집력과 낮은 결합도로 변경과 확장에 용이한 설계를 얻게된다.   
   > 참고문헌 <https://cheese10yun.github.io/spring-guide-directory/>. 
            <https://dev-coco.tistory.com/166/>


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



