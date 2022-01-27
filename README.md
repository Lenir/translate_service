# translate_service
### abstract
- 복습/공부용으로 개발하는 번역 서비스.
### requirements
- REST API 제공
- 필요 기능
  - 번역 기능
    - Input : 번역 대상 String, 목표 언어 (default: korean)
    - 입력된 번역 대상 언어는 알아서 감지.
    - 사용한 번역 API(Naver, kakao, etc.) 결과를 모두 표시.
  - 통계 기능
    - 가장 많이 입력된 단어를 기준으로 랭킹 지원.
      - 입력된 번역 대상 String이 문장인 경우 space로 분리하여 각각의 단어를 집계.
