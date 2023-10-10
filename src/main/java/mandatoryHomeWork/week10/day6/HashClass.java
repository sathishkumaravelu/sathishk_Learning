package mandatoryHomeWork.week10.day6;

import java.util.Arrays;

class MyHashMap {

    int[] mapArray = new int[1000000];
    public MyHashMap() {
        Arrays.fill(mapArray,-1);
    }

    public void put(int key, int value) {
        mapArray[key] = value;
    }

    public int get(int key) {
        if ( mapArray[key]==-1){
            return -1;
        }else return mapArray[key];
    }

    public void remove(int key) {
        if(mapArray[key]!=0) mapArray[key]=-1;
    }
}
