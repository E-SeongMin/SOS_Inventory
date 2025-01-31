# SOS Cafe 재고 관리 시스템 💓

## 🌐 WEB Hosting

---

## 📌 프로젝트 소개
SOS Cafe의 원활한 운영을 돕기 위해 재고 관리 시스템을 구축하였습니다.

---

## 👥 팀원 구성
- **E-SeongMin**  
- **summervinyl**  

---

## 📝 개발 일지
- **2024-09-01** : 1차 배포 완료.
- **2024-09-09** : 사용자 1차 피드백 반영  
  - **Front-end**  
    - 웹 페이지 UI 개선 (텍스트 수정)  
    - 아이디 권한 부여 기능 추가 (실무자)  
    - 재고 수량을 정수에서 실수로 변경 (소수점 노출 필요)  
  - **Android**  
    - 아이디 권한 체크 기능 추가 (실무자/관리자)  
    - 재고 수량을 정수에서 실수로 변경 (소수점 노출 필요)  
    - APK 전달 불편 해결을 위한 CI/CD 배포 자동화 추가 필요  

---

## ⚙ 개발 환경
- **Front-end** : React  
- **Android** : Kotlin  
- **Back-end** : Firebase FireStore  
- **버전 및 이슈 관리** : GitHub  
- **협업 툴** : Figma, KakaoTalk  
- **디자인** : [Figma 디자인 보기](https://www.figma.com/design/OjTnUAhLnHicyMBUC6YrND/SOS-INVENTORY?node-id=0-1&t=IP9h6ZO3MILkjYcH-0)  

---

## 🚀 채택한 기술 스택 및 브랜치 전략

### 🔹 Web
- **React**  
  - 컴포넌트화를 통해 유지보수성과 재사용성을 극대화  

### 🔹 Android
- **MVVM 패턴**  
  - 데이터 바인딩을 활용하여 뷰와 뷰모델 간 상호작용을 간소화  
  - LiveData와 ViewModel을 사용해 결합도를 낮추고 UI의 자동 반영 기능 구현  
- **Timber**  
  - 로그 사용의 편의성을 위해 채택  
- **Coroutine**  
  - 비동기 작업을 효율적으로 처리하기 위해 활용  

### 🔹 Back-End
- **Firebase FireStore**  
  - 빠르고 간편한 NoSQL 기반의 DB를 활용하여 개발 속도 향상  
  - 자체 서버 구축 부담을 줄이기 위한 선택  

### 🔹 브랜치 전략
- **Git-flow 전략**을 기반으로 `release`와 `develop` 브랜치 운영  
  - `release` : 배포 단계에서만 사용하는 브랜치  
  - `develop` : 개발 단계에서 Git-flow의 `master` 역할 수행  

---

## 📂 프로젝트 구조
📌 **추후 작성 예정**

---

## 💡 프로젝트 회고록

### summervinyl
- **2024-09-01** : 웹 1차 배포 성공!  
  Firebase를 처음 사용하면서 리스트를 가져와 저장하는 과정에서 어려움을 겪었지만, 폭풍 검색 끝에 해결했다. 😂🥲  

---
