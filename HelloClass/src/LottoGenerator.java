
import java.util.ArrayList;
import java.util.Collections;

public class LottoGenerator {
    public static void main(String[] args) {
        // 1부터 45까지 숫자를 리스트에 추가
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        // 리스트를 섞어서 무작위 순서로 변경
        Collections.shuffle(numbers);

        // 앞에서부터 6개 숫자를 출력
        System.out.println("랜덤 로또 번호:");
        for (int i = 0; i < 6; i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
