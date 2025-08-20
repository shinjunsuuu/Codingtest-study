package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ 1316 - 그룹 단어 체커
 *
 * 정의 요약:
 * - "그룹 단어"는 각 문자가 등장할 때, 그 문자가 끊기지 않고 연속해서만 나타나는 단어를 의미.
 *   예) "ccazzzzbb" (c, a, z, b 모두 연속) → 그룹 단어 (O)
 *       "aabbbccb" (b가 끊겼다가 다시 등장) → 그룹 단어 (X)
 *
 * 접근 아이디어:
 * - 왼쪽부터 한 글자씩 보면서, 문자가 바뀌는 "경계"에서만 검사한다.
 *   - 현재 문자(c)가 이전 문자(prev)와 다를 때:
 *     1) c가 과거에 등장한 적(seen[c])이 있다면 → 이전에 한 번 끝났던 문자가 재등장 → 그룹 단어 아님.
 *     2) c가 처음 등장이라면 → 등장을 표시(seen[c] = true)하고 prev를 갱신.
 *   - 현재 문자(c)가 prev와 같으면 "연속 구간"이므로 그대로 진행.
 *
 * 자료구조 설명:
 * - boolean[] seen = new boolean[26]
 *   - 문제에서 "단어는 알파벳 소문자"만 주어진다고 했으므로,
 *     'a'~'z' 26개에 대해 등장 여부를 O(1)로 기록/조회하기 위해 길이 26 배열 사용.
 *   - 인덱스 매핑: 문자 c에 대해 idx = c - 'a' (예: 'a'→0, 'z'→25)
 *
 * 정당성:
 * - 문자가 바뀌는 지점에서 "이전에 끝났던 문자가 다시 등장했는지"만 확인하면 충분하다.
 * - 연속으로 같은 문자가 오는 동안에는 검사를 반복할 필요가 없음(동일 블록 안이므로 위반 불가).
 *
 * 복잡도:
 * - 각 단어 길이를 L이라 할 때 O(L)
 * - 단어 개수 N(≤100), 길이(≤100)이므로 전체 O(N*L) = 최대 10,000회 수준 → 매우 충분.
 */
public class BOJ_1316 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 단어 개수 N (정수 한 개가 한 줄에 들어오므로 readLine 후 parseInt)
        int N = Integer.parseInt(bf.readLine());

        int count = 0; // 그룹 단어 개수 누적

        for (int i = 0; i < N; i++) {
            String word = bf.readLine(); // 단어 한 줄 입력 (소문자, 길이 ≤ 100)
            if (isGroupWord(word)) {
                count++; // 그룹 단어라면 카운트 증가
            }
        }

        // 결과 출력: 그룹 단어의 총 개수
        System.out.println(count);
    }

    /**
     * 단어 s가 "그룹 단어"인지 판별한다.
     *
     * @param s 검사할 단어 (소문자만 주어진다고 가정)
     * @return true면 그룹 단어, false면 비그룹 단어
     */
    private static boolean isGroupWord(String s) {
        // 알파벳 소문자 26개('a'~'z')의 등장 여부를 기록
        // seen[x] == true: 문자가 "언젠가 한 번이라도 등장한 적이 있음"을 의미
        boolean[] seen = new boolean[26];

        // prev: 직전에 본 문자. 처음에는 '없음'을 의미하는 0으로 두되,
        //       어떤 소문자와도 다르므로 첫 글자에서 반드시 분기(c != prev)가 발생함.
        char prev = 0;

        // 문자열을 왼쪽 → 오른쪽으로 1글자씩 순회
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 현재 문자

            if (c != prev) { // 문자가 바뀌는 "경계" 지점에서만 검사
                int idx = c - 'a'; // 'a'→0, ..., 'z'→25

                // seen[idx]가 이미 true라면?
                // → 이전에 다른 문자로 바뀐 뒤, 다시 c가 등장한 것이므로 그룹 단어 규칙 위반
                if (seen[idx]) {
                    return false;
                }

                // 처음 등장하는 문자이므로 등장 표시
                seen[idx] = true;

                // 현재 문자를 이후 비교용 "이전 문자"로 갱신
                prev = c;
            }
            // c == prev인 경우:
            // 같은 문자가 연속으로 등장 중(같은 블록 내부)이므로 규칙 위반이 될 수 없음.
            // 별도 처리가 필요 없고, 다음 문자로 진행.
        }

        // 끝까지 위반이 없었다면 그룹 단어
        return true;
    }
}

