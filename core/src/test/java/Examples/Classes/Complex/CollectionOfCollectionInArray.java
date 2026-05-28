package Examples.Classes.Complex;

import Examples.Classes.Simple.MixedAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CollectionOfCollectionInArray {
    private List<List<MixedAll>[]> list;

    public CollectionOfCollectionInArray() {
        this.list = new ArrayList<>();
        List<MixedAll>[] listArr1 = new List[2];
        List<MixedAll>[] listArr2 = new List[1];

        List<MixedAll> list1 =  new ArrayList<>();
        list1.add(new MixedAll());

        List<MixedAll> list2 = new ArrayList<>();
        list2.add(null);

        listArr1[0] = list1;
        listArr1[1] = null;
        listArr2[0] = list2;

        this.list.add(listArr1);
        this.list.add(listArr1);
    }

    public CollectionOfCollectionInArray(List<List<MixedAll>[]> list) {
        this.list = list;
    }

    public List<List<MixedAll>[]> getList() {
        return list;
    }

    public void setList(List<List<MixedAll>[]> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionOfCollectionInArray that = (CollectionOfCollectionInArray) o;

        if (list.size() != that.list.size()) {
            return false;
        }

        for(int i = 0; i < list.size(); ++i) {
            if(!Arrays.equals(list.get(i), that.list.get(i)))
                return false;
        }
        return true;
        //return Objects.equals(getList(), that.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getList());
    }
}
