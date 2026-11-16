# 🚗 Volkswagen Group Archive 

Volkswagen Group Archive는 폭스바겐 그룹의 자동차 브랜드와 주요 모델을 살펴보는 안드로이드 앱입니다. 폭스바겐, 아우디, 포르쉐, 람보르기니, 벤틀리 중 하나를 선택하면 해당 브랜드의 모델 목록을 볼 수 있습니다.

## 사용 기술

- **Kotlin**
- **Jetpack Compose** — 컴포저블 기반 UI 구성
- **Material 3** — 테마와 UI 컴포넌트
- **Navigation Compose** — 화면 이동 및 백스택 관리
- **ViewModel** — 선택한 브랜드·차량과 즐겨찾기 상태 관리
- **Compose State** — 상태 변경에 따른 UI 갱신
  
## 화면 구성

1. **브랜드 선택** — 다섯 브랜드 중 하나를 선택합니다.
2. **모델 목록** — 선택한 브랜드의 주요 모델을 사진과 함께 보여줍니다.
3. **모델 상세** — 차량의 큰 사진과 간단한 소개, 외관 디자인의 특징을 보여줍니다.

예를 들어 **포르쉐 → 911 → 911 상세** 순서로 이동할 수 있습니다. 관심 모델은 목록과 상세 화면에서 별표로 저장할 수 있으며, 홈 버튼을 누르면 브랜드 선택 화면으로 돌아갑니다.

<img width="207" height="462" alt="스크린샷 2026-11-16 222415" src="https://github.com/user-attachments/assets/b8f8d23f-d561-494f-9468-746e72d96692" />
<img width="207" height="462" alt="스크린샷 2026-11-16 222428" src="https://github.com/user-attachments/assets/7f8180ce-8ecb-453a-b009-e0328cf77073" />
<img width="207" height="462" alt="image" src="https://github.com/user-attachments/assets/007de0bd-cfd1-4306-89aa-cab5052e4e41" />


## 주요 기능

### 브랜드별 차량 탐색
Lamborghini, Bentley, Audi, Volkswagen의 브랜드 카드를 제공하며, 선택한 브랜드에 해당하는 차량만 표시합니다.

### 차량 상세 정보
차량 사진, 이름, 짧은 소개와 함께 최고속도·파워트레인·가속 시간 및 상세 설명을 확인할 수 있습니다.

### 즐겨찾기
차량 목록과 상세 화면에서 별 버튼으로 즐겨찾기를 추가하거나 해제할 수 있습니다. 두 화면의 상태가 함께 반영되며, 화면 회전 후에도 유지됩니다.

> 즐겨찾기는 ViewModel에서 관리하며, 앱 종료 후의 영구 저장은 지원하지 않습니다.

### 화면 이동
브랜드 목록 → 차량 목록 → 차량 상세 순서로 이동합니다. 상단 바의 뒤로가기 버튼으로 이전 화면에 돌아가거나, 홈 버튼으로 브랜드 목록에 바로 돌아갈 수 있습니다.

## 프로젝트 구조

```text
app/src/main/
├─ java/com/example/volkswagengrouparchive/
│  ├─ MainActivity.kt
│  ├─ data/
│  │  ├─ Brand.kt
│  │  ├─ BrandDataSource.kt
│  │  ├─ Vehicle.kt
│  │  └─ VehicleDataSource.kt
│  └─ ui/
│     ├─ VolkswagenGroupApp.kt
│     ├─ GroupViewModel.kt
│     └─ theme/
└─ res/
   ├─ drawable/
   ├─ font/
   └─ values/
      ├─ strings.xml
      └─ dimens.xml
```

## 구현 특징

- `BrandCard`, `VehicleCard`, `FavoriteButton` 등 공통 컴포저블 재사용
- 데이터와 UI 코드 분리
- ViewModel에서 상태를 관리하고 화면에는 값과 이벤트 전달
- 문자열과 크기를 리소스 파일로 관리
- 커스텀 폰트와 Material 테마 적용
- 데이터 추가를 통한 브랜드별 차량 목록 확장
