package chanhee;

import java.util.stream.Collectors;

import static util.SimpleInput.*;

public class StoreView {

    public void showStoreScreen() {
        System.out.println("# 1. 매점 이용하기");
        System.out.println("# 2. 매점 이용 종료");
    }

    public void store() {

        int count = 0;
        for (Store store : StoreRepository.getStoreList()) {
            System.out.printf("%d. %s ", store.getMenuNumber(), store.getName());
            count++;
            if(count % 3 == 0) System.out.print("\n");
        }

        while (true) {
            int inputNumber = 0;
            try {
                inputNumber = Integer.parseInt(input("\n====================================\n- 구매하실 메뉴번호를 입력해주세요: "));
                int finalInputNumber = inputNumber;
                Store selectedStore = StoreRepository.getStoreList().stream()
                        .filter(store -> store.getMenuNumber() == finalInputNumber).collect(Collectors.toList()).get(0);
                StoreRepository.getUserStore().add(selectedStore);
                System.out.printf("%s가 %d원에 구매되었습니다.\n", selectedStore.getName(), selectedStore.getPrice());
                break;
            } catch (NumberFormatException e) {
                System.out.println("메뉴번호를 숫자로 입력해주세요.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("유효하지 않은 메뉴번호입니다.");
            }

        }
    }
}
