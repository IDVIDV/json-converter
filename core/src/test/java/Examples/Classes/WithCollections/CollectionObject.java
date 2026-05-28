package Examples.Classes.WithCollections;

import Examples.Classes.Simple.MixedAll;
import Examples.Enums.Color;
import Examples.Enums.Language;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionObject {
    private List<MixedAll> listMixed;

    public CollectionObject() {
        this.listMixed = new ArrayList<>();
        this.listMixed.add(new MixedAll("a", Color.RED, 1, Language.EN, "b", 2));
        this.listMixed.add(new MixedAll());
    }

    public CollectionObject(List<MixedAll> listMixed) {
        this.listMixed = listMixed;
    }

    public List<MixedAll> getListMixed() {
        return listMixed;
    }

    public void setListMixed(List<MixedAll> listMixed) {
        this.listMixed = listMixed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionObject that = (CollectionObject) o;
        return Objects.equals(getListMixed(), that.getListMixed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListMixed());
    }
}
