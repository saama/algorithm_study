# 유용한 알고리즘 정리

## 목차
- [자료구조](#자료구조)
- [정렬](#정렬)
- [그래프](#그래프)
- [분할 정복](#분할-정복)
- [동적 프로그래밍](#동적-프로그래밍)
- [LCS](#lcs)
- [기타 알고리즘](#기타-알고리즘)
- [프로그래머스](#프로그래머스)
- [COS Pro Level 1](#cos-pro-level-1)
- [팁](#팁)

---

## 자료구조

| # | 파일 | 알고리즘 | 설명 |
|---|------|----------|------|
| - | [LinkedList_singly.java](LinkedList_singly.java) | 단방향 연결 리스트 | 노드 삽입(중간/마지막), 삭제, 탐색, 역순 정렬 구현 |

---

## 정렬

> 병합, 선택, 퀵 정렬

| # | 파일 | 알고리즘 | 문제 | 설명 |
|---|------|----------|------|------|
| 1 | [Exam1_quicksort_11650.java](Sort/Exam1_quicksort_11650.java) | 퀵 정렬 / 선택 정렬 | [BOJ 11650](https://www.acmicpc.net/problem/11650) | 좌표를 X기준으로 퀵 정렬 후 그룹핑, Y기준으로 재정렬 |
| 3 | [Exam3_greedy_11399.java](Exam3_greedy_11399.java) | 그리디 + 퀵 정렬 | [BOJ 11399](https://www.acmicpc.net/problem/11399) | ATM 대기 시간 최소화 - 오름차순 정렬 후 누적합 계산 |

---

## 그래프

### DFS / BFS

| # | 파일 | 알고리즘 | 문제 | 설명 |
|---|------|----------|------|------|
| 5 | [Gragh/Exam5_DFS_2667.java](Gragh/Exam5_DFS_2667.java) | DFS | [BOJ 2667](https://www.acmicpc.net/problem/2667) | 단지번호붙이기 - 2차원 배열에서 DFS로 연결된 구역 탐색 |
| 10 | [Gragh/Exam10_DFS_BFS_1260.java](Gragh/Exam10_DFS_BFS_1260.java) | DFS / BFS | [BOJ 1260](https://www.acmicpc.net/problem/1260) | 인접 리스트로 그래프 구성 후 DFS, BFS 탐색 |

### 최소 신장 트리 (MST)

| # | 파일 | 알고리즘 | 설명 |
|---|------|----------|------|
| 11 | [Gragh/Gragh_Prim_Algorithm.java](Gragh/Gragh_Prim_Algorithm.java) | 프림 알고리즘 | 우선순위 큐(Min Heap) + 방문 배열로 MST 구현 |
| 12 | [Gragh/Gragh_Kruskal_Algorithm.java](Gragh/Gragh_Kruskal_Algorithm.java) | 크루스칼 알고리즘 | Union-Find(Disjoint Set)로 사이클 판별하며 MST 구현 |

### 최단 경로

> 벨만-포드: 방향 그래프, 음의 가중치에서 최단 경로(SSP) 탐색
> 다익스트라: 임의의 한 점에서 모든 정점까지의 최단 경로 탐색

| # | 파일 | 알고리즘 | 문제 | 설명 |
|---|------|----------|------|------|
| 13 | [Gragh/Bellman_Ford/Exam13_Bellman_Ford_Algorithm_11657.java](Gragh/Bellman_Ford/Exam13_Bellman_Ford_Algorithm_11657.java) | 벨만-포드 | [BOJ 11657](https://www.acmicpc.net/problem/11657) | 음의 가중치 포함 최단 경로, 음수 사이클 감지 |
| 14 | [Gragh/Dijkstra/Exam14_Dijkstra.java](Gragh/Dijkstra/Exam14_Dijkstra.java) | 다익스트라 | - | 인접 행렬 방식으로 시작 노드에서 모든 노드까지 최단 거리 계산 |

---

## 분할 정복

> 분할 정복 마스터!

| # | 파일 | 알고리즘 | 문제 | 설명 |
|---|------|----------|------|------|
| 15 | [DivideAndConquer/Exam15_DivideAndConquer_1780.java](DivideAndConquer/Exam15_DivideAndConquer_1780.java) | 분할 정복 | [BOJ 1780](https://www.acmicpc.net/problem/1780) | 종이를 3x3으로 분할, 동일 숫자 여부 체크하며 재귀 |
| 16 | [DivideAndConquer/Exam16_DivideAndConquer_2630.java](DivideAndConquer/Exam16_DivideAndConquer_2630.java) | 분할 정복 | [BOJ 2630](https://www.acmicpc.net/problem/2630) | 색종이 만들기 - 4등분 분할하며 흰/파랑 색종이 수 카운트 |
| 17 | [DivideAndConquer/Exam17_DivideAndConquer_2447.java](DivideAndConquer/Exam17_DivideAndConquer_2447.java) | 분할 정복 | [BOJ 2447](https://www.acmicpc.net/problem/2447) | 별 찍기 - 3x3 재귀 분할, 가운데(1,1)는 공백 처리 |
| 18 | [DivideAndConquer/Exam18_DivideAndConquer_1992.java](DivideAndConquer/Exam18_DivideAndConquer_1992.java) | 분할 정복 (쿼드트리) | [BOJ 1992](https://www.acmicpc.net/problem/1992) | 쿼드트리 압축 - 4등분 재귀, 동일값이면 그 값 출력 |

---

## 동적 프로그래밍

| # | 파일 | 알고리즘 | 문제 | 설명 |
|---|------|----------|------|------|
| 17 | [Dynamic_Programming/Exam17_DP_1149/Exam17_DP_1149.java](Dynamic_Programming/Exam17_DP_1149/Exam17_DP_1149.java) | DP | [BOJ 1149](https://www.acmicpc.net/problem/1149) | RGB거리 - 인접한 집은 다른 색으로 칠할 때 최소 비용 |

---

## LCS

| # | 파일 | 알고리즘 | 문제 | 설명 |
|---|------|----------|------|------|
| 21 | [LCS/Exam21_LCS_9251.java](LCS/Exam21_LCS_9251.java) | LCS (최장 공통 부분 수열) | [BOJ 9251](https://www.acmicpc.net/problem/9251) | 점화식: 끝자리 같으면 `f(a-1,b-1)+1`, 다르면 `MAX(f(a-1,b), f(a,b-1))` |

---

## 기타 알고리즘

| # | 파일 | 알고리즘 | 문제 | 설명 |
|---|------|----------|------|------|
| 2 | [Exam2_segment_tree_2357.java](Exam2_segment_tree_2357.java) | 세그먼트 트리 | [BOJ 2357](https://www.acmicpc.net/problem/2357) | 구간 최댓값/최솟값 쿼리를 O(logN)에 처리 |
| 4 | [Exam4_findingPath_3155.java](Exam4_findingPath_3155.java) | 경로 탐색 | [BOJ 3155](https://www.acmicpc.net/problem/3155) | 천장/바닥 배열 사이 경로 찾기 |
| 6 | [Exam6_backtracking_9663.java](Exam6_backtracking_9663.java) | 백트래킹 | [BOJ 9663](https://www.acmicpc.net/problem/9663) | N-Queen - 같은 행/대각선 충돌 체크하며 DFS |
| 7 | [Exam7_LineSweep_2261.java](Exam7_LineSweep_2261.java) | 라인 스위핑 | [BOJ 2261](https://www.acmicpc.net/problem/2261) | 가장 가까운 두 점 - TreeSet으로 y범위 필터링, O(nlogn) |
| 8 | [Exam8_StringExplosion_9935.java](Exam8_StringExplosion_9935.java) | 스택 (문자열 폭발) | [BOJ 9935](https://www.acmicpc.net/problem/9935) | 문자열에서 폭탄 패턴 연쇄 제거, 스택 방식으로 구현 |
| 9 | [Exam9_KMP_1786.java](Exam9_KMP_1786.java) | KMP | [BOJ 1786](https://www.acmicpc.net/problem/1786) | 실패 함수(PI 배열) 이용한 문자열 패턴 매칭 |
| 19 | [Exam19_6190.java](Exam19_6190.java) | 시뮬레이션 | [BOJ 6190](https://www.acmicpc.net/problem/6190) | 콜라츠 수열 - 홀수면 ×3+1, 짝수면 ÷2, 1이 될 때까지 반복 |
| 20 | [Exam20_Hanoitop_11729.java](Exam20_Hanoitop_11729.java) | 재귀 (하노이 탑) | [BOJ 11729](https://www.acmicpc.net/problem/11729) | 이동 횟수 2^N-1, 재귀로 이동 경로 출력 |

---

## 프로그래머스

### Level 2

| # | 파일 | 문제 | 설명 |
|---|------|------|------|
| 22 | [Exam22_Programers_level2_1.java](programmers/Exam22_Programers_level2_1.java) | [카카오프렌즈 컬러링북](https://programmers.co.kr/learn/courses/30/lessons/1829) | DFS로 같은 색깔 영역 탐색, 영역 수와 최대 크기 반환 |
| 24 | [Exam24_Programers_level2_2.java](programmers/Exam24_Programers_level2_2.java) | [탑](https://programmers.co.kr/learn/courses/30/lessons/42588) | 각 탑에서 왼쪽 방향으로 더 높은 탑의 인덱스 탐색 |
| 26 | [Exam26_Programers_Study_1.java](programmers/Exam26_Programers_Study_1.java) | [문자열 압축 (카카오 2020)](https://programmers.co.kr/learn/courses/30/lessons/60057) | 단위 길이별 반복 문자열 압축, 최소 길이 반환 |
| 27 | [Exam27_Programers_level2_3.java](programmers/Exam27_Programers_level2_3.java) | [스킬트리](https://programmers.co.kr/learn/courses/30/lessons/49993) | 선행 스킬 순서 검증 - 배운 스킬의 순서가 올바른지 체크 |
| 29 | [Exam29_Programers_level2_4.java](programmers/Exam29_Programers_level2_4.java) | [주식가격](https://programmers.co.kr/learn/courses/30/lessons/42584) | 각 시점에서 가격이 떨어지지 않은 기간 계산 |
| 31 | [Exam31_Programers_level2_5.java](programmers/Exam31_Programers_level2_5.java) | [쇠막대기](https://programmers.co.kr/learn/courses/30/lessons/42585) | 레이저(괄호쌍)와 depth로 잘린 막대기 조각 수 계산 |
| 33 | [Exam33_Programers_level2_6.java](programmers/Exam33_Programers_level2_6.java) | [기능개발](https://programmers.co.kr/learn/courses/30/lessons/42586) | 작업 완료 순서에 따라 배포 가능한 기능 수 계산 |
| 35 | [Exam35_Programers_level2_7.java](programmers/Exam35_Programers_level2_7.java) | [프린터](https://programmers.co.kr/learn/courses/30/lessons/42587) | 우선순위 큐 시뮬레이션으로 특정 문서의 출력 순서 계산 |
| 37 | [Exam37_Programers_level2_8.java](programmers/Exam37_Programers_level2_8.java) | [124 나라의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12899) | 3진수 변환 응용 - 0 대신 4를 쓰는 변환 규칙 |

### Level 3

| # | 파일 | 문제 | 설명 |
|---|------|------|------|
| 23 | [Exam23_Programers_level3_1.java](programmers/Exam23_Programers_level3_1.java) | [가장 긴 팰린드롬](https://programmers.co.kr/learn/courses/30/lessons/12904) | 길이를 줄여가며 팰린드롬 여부 재귀 검사 |
| 25 | [Exam25_Programers_level3_2.java](programmers/Exam25_Programers_level3_2.java) | [종이접기](https://programmers.co.kr/learn/courses/30/lessons/62049) | 규칙성: 중간값은 0, 우측은 좌측의 반대값 |
| 28 | [Exam28_Programers_level3_3.java](programmers/Exam28_Programers_level3_3.java) | [추석 트래픽 (카카오 2018)](https://programmers.co.kr/learn/courses/30/lessons/17676) | Timestamp 활용, 1초 슬라이딩 윈도우로 최대 처리량 계산 |
| 30 | [Exam30_Programers_level3_4.java](programmers/Exam30_Programers_level3_4.java) | [네트워크](https://programmers.co.kr/learn/courses/30/lessons/43162) | 인접 행렬 DFS로 연결된 컴퓨터 그룹(네트워크) 수 계산 |
| 32 | [Exam32_Programers_level3_5.java](programmers/Exam32_Programers_level3_5.java) | [섬 연결하기](https://programmers.co.kr/learn/courses/30/lessons/42861) | 크루스칼(Union-Find) 알고리즘으로 MST 최소 비용 |
| 34 | [Exam34_Programers_level3_6.java](programmers/Exam34_Programers_level3_6.java) | [N으로 표현](https://programmers.co.kr/learn/courses/30/lessons/42895) | DP + HashSet으로 N을 최소 몇 번 써서 숫자를 만들 수 있는지 |
| 36 | [Exam36_Programers_level3_7.java](programmers/Exam36_Programers_level3_7.java) | [타일 장식물](https://programmers.co.kr/learn/courses/30/lessons/43104) | 피보나치 수열로 N번째 타일의 둘레 계산 |
| 38 | [Exam38_Programers_level3_8.java](programmers/Exam38_Programers_level3_8.java) | [피보나치 수](https://programmers.co.kr/learn/courses/30/lessons/12945) | 피보나치 DP, 1234567로 모듈러 연산 |

---

## COS Pro Level 1

| 폴더 | 설명 |
|------|------|
| [cos_level1/Exam01/](cos_level1/Exam01/) | COS Pro Level 1 - 1회차 문제 풀이 (Solution1 ~ Solution10) |
| [cos_level1/Exam02/](cos_level1/Exam02/) | COS Pro Level 1 - 2회차 문제 풀이 (Solution001 ~ Solution009) |

---

## 팁

> 앞으로 자주 쓰게 될 유용한 팁 소스들 정리

| 파일 | 설명 |
|------|------|
| [tip/Pair.java](tip/Pair.java) | 범용 Pair 클래스 |
