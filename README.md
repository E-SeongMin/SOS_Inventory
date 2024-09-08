# SOS Cafe 재고 관리 시스템 💓

- WEB Hosting URL : https://sos-inventory-f3b16.web.app

<br>

## 프로젝트 소개

- 지인의 카페 창업에 도움을 주기 위해 해당 가게 재고 파악 시스템을 구축하였습니다.

<br>

## 팀원 구성

<div align="center">
E-SeongMin
summervinyl

</div>

<br>

## 0. 개발 일지
- 2024-09-01 : 1차 배포 완료.
- 2024-09-09 : 사용자 1차 피드백
  - [Front-end]
  - 1. 웹 페이지 글자 수정 (UI 수정 필요)
    2. 아이디 권한 부여 기능 추가 (실무자)
    3. 재고 수량 정수에서 실수로 변경 (소수점 노출 필요)
    [Android]
    1. 아이디 권한 체크 (실무자/관리자)
    2. 재고 수량 정수에서 실수로 변경 (소수점 노출 필요)
    3. APK 전달 불편함 (CI/CD 배포자동화 추가 필요)

## 1. 개발 환경

- Front-end : React
- Android : Kotlin
- Back-end : Firebase FireStore
- 버전 및 이슈 관리 : Github
- 협업 툴 : Figma, Kakao Talk
- 디자인 : https://www.figma.com/design/OjTnUAhLnHicyMBUC6YrND/SOS-INVENTORY?node-id=0-1&t=IP9h6ZO3MILkjYcH-0
<br>


## 2. 채택한 개발 기술과 브랜치 전략

### Web

- React
    - 컴포넌트화를 통해 유지보수와 재사용성을 고려했습니다.
 
### Android

- MVVM
    - 데이터 바인딩을 통해 뷰와 뷰모델 간의 상호 작용을 간소화하고, 모델과 뷰모델 사이의 의존성을 줄여줌으로써, 코드의 모듈성과 재사용성을 향상시켰습니다.
    - LiveData와 ViewModel를 통해 UI 컴포넌트와 데이터 사이의 결합도를 낮추고, UI가 데이터의 변경 사항을 자동으로 감지하고 반영하여 퍼포먼스적인 효율성을 고려했습니다.
- Timber
    - 로그 사용의 편의성을 위해 사용했습니다.
- Coroutine


### Back-End

- FireStore DataBase
    - 프로젝트 투입 인원이 안드로이드, 웹 프론트 파트로 이루어져 있기에 자체적인 서버를 제대로 구축하기에 부담이 있고, 프로젝트의 규모와 작업 속도를 생각해 빠르고 간편한 NoSQL 기반 FireStore DB를 채택했습니다.

### 브랜치 전략

- Git-flow 전략을 기반으로 release, develop 브랜치를 사용했습니다.
- release, develop
    - **release** 브랜치는 배포 단계에서만 사용하는 브랜치입니다.
    - **develop** 브랜치는 개발 단계에서 git-flow의 master 역할을 하는 브랜치입니다.
<br>


## 3. 프로젝트 구조

추후 작성 예정
<br>


## 4. 프로젝트 회고록
- summer
      1. 2024-09-01 : 웹 1차 배포에 성공했다. firebase를 처음 사용하느라 list를 가져와서 저장하는 데에 진을 뺐지만, 폭풍 서치 끝에 성공했다. 😂🥲
