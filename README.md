# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
### 프로그램
- 게임이 종료된 후 다시 시작하거나 프로그램을 종료시키게된다.
- 컴퓨터/플레이어가 선택한 수의 숫자들을 비교한 결과가 화면에 출력된다.
- 사용자가 값을 잘못 입력 할 경우 [ERROR]로 시작하는 에러 메시지가 출력된다.
- 에러 메시지가 출력되도 게임은 계속 진행된다.

### 게임로직
- 게임은 1~9의 서로 다른 숫자로 구성된 3자리 수를 맞추는것으로 진행된다.
- 2명으로 게임을 진행하며 상대방 역할은 컴퓨터가 된다.
- 컴퓨터가 수를 선택하고 플레이어가 해당 수를 맞추게된다.
- 플레이어는 컴퓨터가 선택한 수를 맞추면 승리하게된다.
- 게임은 플레이어가 컴퓨터가 선택한 수를 맞출때까지 진행된다.
- 컴퓨터/플레이어가 선택한 수가 전부 스트라이크로 판단시 게임이 종료된다.

### 도메인 모델
- 컴퓨터/플레이어가 선택한 수의 숫자가 같으며 동일한 자리에 있으면 스트라이크로 정의된다.
- 컴퓨터/플레이어가 선택한 수의 숫자는 같으며 다른자리에 있으면 볼로 정의된다.
- 컴퓨터/플레이어가 선택한 수의 숫자들이 같지 않으면 낫싱으로 정의된다.

## 구현할 기능 목록
- 화면시퀀스 열거자
- 화면전환을 제어하는 메인 프로그램
- 메뉴 열거자
- 화면 도메인 - `메뉴화면`
- 메뉴 화면에서 유저입력 기능
- 메뉴 화면에서 유저 입력에따른 메인 프로그램의 화면전환 기능
- 플레이어 도메인
- BallNumber 생성 전략
- BallNumber 도메인
- 화면 도메인 - `게임화면`
- 스트라이크 판단 로직
- 볼 판단 로직
- 낫싱 판단 로직
- 플레이어의 수와 컴퓨터의 수를 비교한 결과 출력
- 플레이어가 컴퓨터가 선택한 수를 맞추었는지 판단 로직
- 게임 로직에따른 메인 프로그램의 화면전환 기능
- 사용가자 오입력한 경우에대한 에러메시지 출력
- 단위 테스트