package Examples.Classes.Complex;

import Examples.Classes.Simple.MixedAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayInCollection {
    private List<MixedAll[]> listOfArr;

    public ArrayInCollection() {
        this.listOfArr = new ArrayList<>();

        MixedAll[] arrMixed1 = new MixedAll[1];
        arrMixed1[0] = new MixedAll();

        MixedAll[] arrMixed2 = new MixedAll[0];

        this.listOfArr.add(arrMixed1);
        this.listOfArr.add(null);
        this.listOfArr.add(arrMixed2);
    }

    public ArrayInCollection(List<MixedAll[]> listOfArr) {
        this.listOfArr = listOfArr;
    }

    public List<MixedAll[]> getListOfArr() {
        return listOfArr;
    }

    public void setListOfArr(List<MixedAll[]> listOfArr) {
        this.listOfArr = listOfArr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayInCollection that = (ArrayInCollection) o;

        if (listOfArr.size() != that.listOfArr.size()) {
            return false;
        }

        for (int i = 0; i < listOfArr.size(); ++i) {
            if (!Arrays.equals(listOfArr.get(i), that.listOfArr.get(i)))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListOfArr());
    }
}
