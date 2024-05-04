package chanhee;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository {

    private static MovieUser user;
//    private static StoreList storeList;
    private static List<Store> storeList;
    private static List<Store> userStore;

    static {
        storeList = new ArrayList<>();
        userStore = new ArrayList<>();
        storeList.add(new Store(1,"\uD83C\uDF7F고소팝콘(M)", 6000));
        storeList.add(new Store(2,"\uD83C\uDF7F고소팝콘(L)", 6500));
        storeList.add(new Store(3,"\uD83C\uDF7F카라멜팝콘(M)", 6000));
        storeList.add(new Store(4,"\uD83C\uDF7F카라멜팝콘(L)", 6500));
        storeList.add(new Store(5,"\uD83C\uDF7F더블치즈팝콘(M)", 6000));
        storeList.add(new Store(6,"\uD83C\uDF7F더블치즈팝콘(L)", 6500));
        storeList.add(new Store(7,"\uD83C\uDF7F버질어니언팝콘(M)", 6000));
        storeList.add(new Store(8,"\uD83C\uDF7F버질어니언팝콘(L)", 6500));
        storeList.add(new Store(9,"🍹탄산음료(M)", 3000));
        storeList.add(new Store(10,"🍹탄산음료(L)", 3500));
        storeList.add(new Store(11,"☕아메리카노(ICE)", 4500));
        storeList.add(new Store(12,"☕아메리카노(HOT)", 4000));
        storeList.add(new Store(13,"🍹청포도에이드", 5500));
        storeList.add(new Store(14,"🍹자몽에이드", 5500));
        storeList.add(new Store(15,"🌭칠리치즈나쵸", 4900));
        storeList.add(new Store(16,"🌭플레인 핫도그", 4500));
        storeList.add(new Store(17,"🌭칠리치즈 핫도그", 5000));
    }

    public static List<Store> getStoreList() {
        return storeList;
    }

    public static void setStoreList(List<Store> storeList) {
        StoreRepository.storeList = storeList;
    }

    public static MovieUser getUser() {
        return user;
    }

    public static void setUser(MovieUser user) {
        StoreRepository.user = user;
    }

    public static List<Store> getUserStore() {
        return userStore;
    }

    public static void setUserStore(List<Store> userStore) {
        StoreRepository.userStore = userStore;
    }

}
