package Examples.Classes.Complex;

import Examples.Classes.Simple.MixedAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionInArray {
    private List<MixedAll>[] arrOfList;

    public CollectionInArray() {
        this.arrOfList = new List[3];

        List<MixedAll> listMixed1 = new ArrayList<>();
        listMixed1.add(new MixedAll());

        List<MixedAll> listMixed2 = new ArrayList<>();

        this.arrOfList[0] = listMixed1;
        this.arrOfList[1] = null;
        this.arrOfList[2] = listMixed2;
    }

    public CollectionInArray(List<MixedAll>[] arrOfList) {
        this.arrOfList = arrOfList;
    }

    public List<MixedAll>[] getArrOfList() {
        return arrOfList;
    }

    public void setArrOfList(List<MixedAll>[] arrOfList) {
        this.arrOfList = arrOfList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionInArray that = (CollectionInArray) o;



        return Arrays.equals(getArrOfList(), that.getArrOfList());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getArrOfList());
    }
}
