package chanhee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StoreList {

    private Set<String> storeList;

    public StoreList() {
        this.storeList = new HashSet<>();
    }

    // key: 프로그램 이용자 , value: 매점물건
    private Map<MovieUser, StoreView> storeViewMap = new HashMap<>(

    );
}
