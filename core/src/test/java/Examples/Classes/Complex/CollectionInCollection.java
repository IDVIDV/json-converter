package Examples.Classes.Complex;

import Examples.Classes.Simple.MixedAll;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionInCollection {
    private List<List<MixedAll>> listOfList;

    public CollectionInCollection() {

        this.listOfList = new ArrayList<>();

        List<MixedAll> listMixed1 = new ArrayList<>();
        listMixed1.add(new MixedAll());

        List<MixedAll> listMixed2 = new ArrayList<>();

        this.listOfList.add(listMixed1);
        this.listOfList.add(null);
        this.listOfList.add(listMixed2);
    }

    public CollectionInCollection(List<List<MixedAll>> list) {
        this.listOfList = list;
    }

    public List<List<MixedAll>> getListOfList() {
        return listOfList;
    }

    public void setList(List<List<MixedAll>> list) {
        this.listOfList = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionInCollection that = (CollectionInCollection) o;
        return Objects.equals(getListOfList(), that.getListOfList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListOfList());
    }
}
